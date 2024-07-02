package com.example.rent.service.impl;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rent.constants.ResMessage;
import com.example.rent.entity.Bill;
import com.example.rent.entity.Contract;
import com.example.rent.entity.Room;
import com.example.rent.repository.BillDao;
import com.example.rent.repository.ContractDao;
import com.example.rent.repository.RegisterDao;
import com.example.rent.repository.RoomDao;
import com.example.rent.service.ifs.BillService;
import com.example.rent.vo.BillReq;
import com.example.rent.vo.BillRes;
import com.example.rent.vo.UpdateBillReq;

@Service
public class BillServiceImlp implements BillService {

	// 房東帳號
	@Autowired
	private RegisterDao registerDao;

	// 建立房間
	@Autowired
	private RoomDao roomDao;

	// 契約書
	@Autowired
	private ContractDao contractDao;

	// 帳單
	@Autowired
	private BillDao billDao;

	@Override
	public BillRes bill(BillReq req) {
	
	    Optional<Contract> op = contractDao.findById(req.getAi());
	    if (op.isEmpty()) {
	        return new BillRes(ResMessage.AI_IS_NOT_FOUND.getCode(), ResMessage.AI_IS_NOT_FOUND.getMessage());
	    }
	    
	    //這list我要放入我的帳單資料
	    List<Bill> generatedBills = new ArrayList<>();
	    
	    Contract contract = op.get();

	    String address = contract.getAddress();  //地址
	    String roomId = contract.getRoomId();  //房號
	    String tenantIdentity = contract.getTenantIdentity(); //租約者身分證
	    LocalDate startDate = contract.getStartDate();  //租約開始日期
	    LocalDate endDate = contract.getEndDate();   //租約結束日期
	    LocalDate cutDate = contract.getCutDate();  //中止日期
	    //如果中止日期有填寫，則以中止日期為最後一天，如果沒有就以結束日期
	    LocalDate billEndDate = (cutDate != null) ? cutDate : endDate;  
	    
////	    ===============================================================
	    //檢查機制  //當 地址 、 身分證 、開始時間 其中一個一樣但其他的不一樣的話則報錯
	    if((address.equals(req.getAddress())&& !tenantIdentity.equals(req.getTenantIdentity())&& !startDate.equals(req.getPeriodStart()) ) ||
	    		(!address.equals(req.getAddress())&& tenantIdentity.equals(req.getTenantIdentity())&& !startDate.equals(req.getPeriodStart())) ||
	    		(!address.equals(req.getAddress())&& !tenantIdentity.equals(req.getTenantIdentity())&& startDate.equals(req.getPeriodStart())) ) {
	        return new BillRes(ResMessage.MULTIPLE_DATA_EXIST.getCode(), ResMessage.MULTIPLE_DATA_EXIST.getMessage());
	    }
	    //當只有一個錯誤的時候(分開告知) //租月開始日期有誤
	    if(address.equals(req.getAddress())&& tenantIdentity.equals(req.getTenantIdentity())
	    		&& !startDate.equals(req.getPeriodStart())) {
	        return new BillRes(ResMessage.PERIODSTART_ERROR.getCode(), ResMessage.PERIODSTART_ERROR.getMessage());
	    }
	    //房客身分證可能有誤
	    if(address.equals(req.getAddress())&& !tenantIdentity.equals(req.getTenantIdentity())
	    		&& startDate.equals(req.getPeriodStart())) {
	        return new BillRes(ResMessage.TENANTIDENTITY_CHECK_ERROR.getCode(), ResMessage.TENANTIDENTITY_CHECK_ERROR.getMessage());
	    }
	    //地址可能有誤
	    if(!address.equals(req.getAddress())&& tenantIdentity.equals(req.getTenantIdentity())
	    		&& startDate.equals(req.getPeriodStart())) {
	        return new BillRes(ResMessage.ADDRESS_CKECK_ERROR.getCode(), ResMessage.ADDRESS_CKECK_ERROR.getMessage());
	    }
	    if(billDao.existsByAddress(req.getAddress())&& billDao.existsByPeriodStart(req.getPeriodStart())&&billDao.existsByTenantIdentity(req.getTenantIdentity())) {
	        return new BillRes(ResMessage.BILLING_INFORMATION_MAY_ALREADY_EXIST.getCode(), 
	        		ResMessage.BILLING_INFORMATION_MAY_ALREADY_EXIST.getMessage());
	    }

//============================================================
	    //將開始日期先定義為一個計費開開始日期後進入循環
	    LocalDate currentBillingStart = startDate;
	    //開始時間在結束時間之前都是為true
	    while (currentBillingStart.isBefore(billEndDate)) {
//	        LocalDate currentBillingEnd = currentBillingStart.plusDays(30).isAfter(billEndDate) ? billEndDate
//	                : currentBillingStart.plusDays(30);
	    	//當前計費的結束日期:計費的開始日期往後推30天(這邊要寫29 因為在包含今天+29=30天
	    	//例如就想   :  如果我現在數字是 1 我要到10這個數字就要 +9 才會到10
	    	LocalDate currentBillingEnd = currentBillingStart.plusDays(29);
	    	//如果計費的結束時間是在結束時間的後面，就要將它改成最後的時間點(中止日期或者結束日期)
	        if (currentBillingEnd.isAfter(billEndDate)) {
	            currentBillingEnd = billEndDate;
	        }
	        // 可以參考這個網址https://juejin.cn/post/6962774993927143461
	        Period period = Period.between(currentBillingStart, currentBillingEnd);
	        //這段是用來計算日期的相差天數(只有這個可以用Int)
	        int daysInBillingPeriod = period.getDays();

	        Optional<Room> roomOptional = roomDao.findById(address);
            Room room = roomOptional.get();

            int rent = contract.getRentP();//租金
            int waterCharge;
            int electricCharge=room.getEletricP() * req.getEletricV();
            int manageCharge;

            //這邊是用來判斷當前計費開始日期（currentBillingStart）的日期（DayOfMonth）是否與合約開始日期（startDate）的日期是否一致
            //.getDayOfMonth() :傳回範圍為 1-31 的月份中的第幾天。
            //currentBillingStart.getDayOfMonth() != startDate.getDayOfMonth() 之前寫法
            //假設租約7/15~9/20，所以第一期:7/15~8/14  第二期:8/15~9/14  第三期:9/15~9/20
            //所以計算的開始時間會 7/15 -> 8/15 -> 9/15   結束時間 8/14 -> 9/14 -> 9/20
            // 相差天數要記得在+1，這個+1是指今天 (所以當相差天數不足30天時就抱錯)
            if ( daysInBillingPeriod+1  <30 ) {
            	waterCharge = (int)Math.round(room.getWaterP()*((double) daysInBillingPeriod/30));
                manageCharge = (int)Math.round(room.getManageP()*((double) daysInBillingPeriod/30));
            } else {
                waterCharge = room.getWaterP();
                manageCharge = room.getManageP();
            }

            Bill bill = new Bill();
            bill.setAddress(address);// 地址
            bill.setRoomId(roomId);//房號
            bill.setTenantIdentity(tenantIdentity);//租客身分證
            bill.setTenantName(contract.getTenantName());//租客名子
            bill.setOwnerName(contract.getOwnerName());//房東名子
            bill.setFloor(contract.getFloor());//樓層
            bill.setPeriodStart(currentBillingStart);//開始時間(這裡的開始時間是，每一期的開始時間)
            bill.setPeriodEnd(currentBillingEnd);//這裡的結束時間是每一期的最後一天
            bill.setEletricV(req.getEletricV());//使用多少電量
            bill.setRentP(rent);//租金
            bill.setEletricP(room.getEletricP());//電量一度多少錢
            bill.setWaterOneP(waterCharge);//一個月的水費，如果不足一個月則除30在成天數
            bill.setManageOneP(manageCharge);//管理費，同上
            bill.setEletricOneP(electricCharge);//電費  抓取房間的一度電量在去乘以使用電量getEletricV

            //總金額: 水費+管理費+電費+租金(+違約金)
            int totalCharge = waterCharge + manageCharge + electricCharge + rent;
            
            // 違約金
            if (cutDate != null && currentBillingEnd.equals(billEndDate)) {
                totalCharge += room.getCutP();
                bill.setCutP(room.getCutP());//如果違約時間不為空值就要計算
            }

            bill.setTotalOneP(totalCharge);//總共金額
            bill.setPaymentDate(currentBillingEnd.plusDays(10));//繳費日期
            
            billDao.save(bill);
            generatedBills.add(bill);// 將生成的帳單加入列表

	         // 更新開始日期為下一個計費周期的開始日期
	        currentBillingStart = currentBillingEnd.plusDays(1);
	        
	    }

	    return new BillRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage(), generatedBills);
	}

	@Override
	public BillRes updateBill(UpdateBillReq req) {
		
		 Optional<Bill> bill = billDao.findById(req.getAi());
		 
		 if(bill.isEmpty()) {
			 return new BillRes(ResMessage.MAYBE_NOT_THIS_BILLING.getCode(), //
					 ResMessage.MAYBE_NOT_THIS_BILLING.getMessage());
		 }
		//這list我要放入我的帳單資料
		 List<Bill> generatedBills = new ArrayList<>();
		 Bill billAll = bill.get();
		 //寫法一
		 //如果直接寫ai ，抓取單筆帳單，進行(電費)費用更新 
			
//		 Optional<Room> roomOptional = roomDao.findById(req.getAddress());
//		 Room room = roomOptional.get();
		 billAll.setEletricV(req.getEletricV());
		 billAll.setEletricOneP(req.getEletricV()*billAll.getEletricP());
		 int totalP = billAll.getEletricOneP()+billAll.getWaterOneP()+billAll.getManageOneP()+billAll.getCutP()+billAll.getRentP();
		 billAll.setTotalOneP(totalP);
		 
		 billDao.save(billAll);
		 generatedBills.add(billAll);
		 
		
//		 //寫法二
//		 //如果不寫ai，那就寫: 地址、租客身分證、租期開始日與租期結束日(租期的期間)  ，共四個
//		 //第一個判斷，只要下面其中有一個填寫就需要全都寫
//		 if(req.getAddress()!=null || req.getTenantIdentity()!=null || req.getPeriodStart()!=null || req.getPeriodEnd()!=null){
//			 //這邊的判斷是就是 ，只要上面有任何一個有填寫，其他就都不能為null
//			 if(req.getAddress()==null || req.getTenantIdentity()==null || req.getPeriodStart()==null || req.getPeriodEnd()==null) {
//				 return new BillRes(ResMessage.PLEASE_FILLIN_ADDRESS_TENANTIDENTITY_PERIOD.getCode(), //
//						 ResMessage.PLEASE_FILLIN_ADDRESS_TENANTIDENTITY_PERIOD.getMessage());
//			 }
//			 
//			 //接著判斷是否填寫的資訊相同
//			 if( !billAll.getAddress().equals(req.getAddress())) {
//				 return new BillRes(ResMessage.ADDRESS_INFORMATION_ERROR.getCode(), //
//						 ResMessage.ADDRESS_INFORMATION_ERROR.getMessage());
//			 }
//			 if( !billAll.getTenantIdentity().equals(req.getTenantIdentity())) {
//				 return new BillRes(ResMessage.TENANTIDENTITY_INFORMATION_ERROR.getCode(), //
//						 ResMessage.TENANTIDENTITY_INFORMATION_ERROR.getMessage());
//			 }
//			 if( !billAll.getPeriodStart().equals(req.getPeriodStart())) {
//				 return new BillRes(ResMessage.PERIODSTART_ERROR.getCode(), //
//						 ResMessage.PERIODSTART_ERROR.getMessage());
//			 }
//			 if( !billAll.getPeriodEnd().equals(req.getPeriodEnd())) {
//				 return new BillRes(ResMessage.PERIODEND_ERROR.getCode(), //
//						 ResMessage.PERIODEND_ERROR.getMessage());
//			 }
//			 
//			 Optional<Room> roomOptional = roomDao.findById(req.getAddress());
//			 Room room = roomOptional.get();
//			 billAll.setEletricOneP(req.getEletricV()*room.getEletricP());
//			 
//			 billDao.save(billAll);
//		 }
//		 
		 
		
		
		return new BillRes(ResMessage.SUCCESS.getCode(), //
				 ResMessage.SUCCESS.getMessage(),generatedBills);
	}
}
