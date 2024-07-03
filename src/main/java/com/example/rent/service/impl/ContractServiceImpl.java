package com.example.rent.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.rent.constants.ResMessage;
import com.example.rent.entity.Contract;
import com.example.rent.entity.Register;
import com.example.rent.entity.Room;
import com.example.rent.repository.ContractDao;
import com.example.rent.repository.RegisterDao;
import com.example.rent.repository.RoomDao;
import com.example.rent.service.ifs.ContractService;
import com.example.rent.vo.BasicRes;
import com.example.rent.vo.CreateContractReq;
import com.example.rent.vo.UpdateContractReq;

@Service
public class ContractServiceImpl implements ContractService {

	// 這裡有房東的資訊
	@Autowired
	private RegisterDao registerDao;

	// 這裡有房子的資訊
	@Autowired
	private RoomDao roomDao;

	// 這裡是契約書
	@Autowired
	private ContractDao contractDao;

	@Override
	public BasicRes createContract(CreateContractReq req) {

		// 先設定抓取房子的資訊
		Optional<Room> room = roomDao.findById(req.getAddress());
		// 先查看房間存不存在(先從我房間資訊中的id尋找是否存在)
		if (room.isEmpty()) {
			return new BasicRes(ResMessage.ADDRESS_NOT_FOUND.getCode(), ResMessage.ADDRESS_NOT_FOUND.getMessage());
		}
		Room roomAll = room.get();
		// 抓取房間地址與房號
		String roomAddress = roomAll.getAddress();
		String roomId = roomAll.getRoomId();
		// 如果我創建的房間號碼與我這邊填寫的將號碼不一樣
		// 當地只存在時，地址相等但房號不相等時報錯
		if (!roomId.equals(req.getRoomId())) {
			return new BasicRes(ResMessage.RID_FILLIN_ERRO.getCode(), ResMessage.RID_FILLIN_ERRO.getMessage());
		}

		// 抓取房東那張表的帳號(因為帳號與房間創造那張有關連所以要從房間下手)
		// 抓取房東帳號
        String ownerAccount = roomAll.getAccount(); //先假設有此欄..
		//然後再靠這個抓回房東資訊
        Optional<Register> register=registerDao.findById(ownerAccount);
        if (register.isEmpty()) {
            // 先查看有沒有這位房東
            return new BasicRes(ResMessage.REGISTER_NAME_IS_NOT_FOUND.getCode(), ResMessage.REGISTER_NAME_IS_NOT_FOUND.getMessage());
        }
        Register registerAll = register.get();
        String ownerName = registerAll.getOwnerName();
        //用來檢查手機號，不可重複(因為房東的手機號已經是唯一性，所以可以檢查，房客寫的電話在房東列中也沒存在就型)
        if(registerDao.existsByOwnerPhone(req.getTenantPhone())) {
        	return new BasicRes(ResMessage.PHONR_DUPLICATED_FILLIN.getCode(), ResMessage.PHONR_DUPLICATED_FILLIN.getMessage());
        }
        //檢查房東和房客間的身分證避免重複填寫
        if(registerDao.existsByOwnerIdentity(req.getTenantIdentity())) {
        	return new BasicRes(ResMessage.TENANTIDENTITY_DUPLICATED_FILLIN.getCode(), ResMessage.TENANTIDENTITY_DUPLICATED_FILLIN.getMessage());
        }
//        ================================================================
        

        List<Contract> contracts = contractDao.findByAddress(req.getAddress());
        if(contracts.isEmpty()) {
//        	return new BasicRes(ResMessage.ROOM_NOT_RENTED.getCode(), ResMessage.ROOM_NOT_RENTED.getMessage());
        }
        //檢查違約的欄位
        //minusDays(n):生成當天日期的n天之"前"(前n天)
        LocalDate latestAvailableDate = LocalDate.now().minusDays(1);
        for (Contract contract : contracts) {
            if (contract.getCutDate() != null) {
                // 如果中止的欄位上有資料填寫，則以"中止日期"為準，來查看房間是否重複出租
                if (contract.getCutDate().isAfter(latestAvailableDate)) {
                    latestAvailableDate = contract.getCutDate();
                }
            } else {
                // 如果中止欄位沒有資料，則已"結束日期"為基準，來查看房間是否重複出租
                if (contract.getEndDate().isAfter(latestAvailableDate)) {
                    latestAvailableDate = contract.getEndDate();
                    
                }
            }
        }

        if (req.getStartDate().isBefore(latestAvailableDate.plusDays(1))) {
            return new BasicRes(ResMessage.ROOM_OCCUPIED.getCode(), ResMessage.ROOM_OCCUPIED.getMessage());
        }
        
        // 檢查租客手機號唯一性（在合同有效期內）
        if (!req.getEndDate().isAfter(latestAvailableDate.plusDays(1))&&//
        		contractDao.existsByTenantPhone(req.getTenantPhone())) {
            return new BasicRes(ResMessage.PHONR_DUPLICATED_FILLIN.getCode(), ResMessage.PHONR_DUPLICATED_FILLIN.getMessage());
        }

        // 檢查租客身份證唯一性（在合同有效期內）
        if (!req.getEndDate().isAfter(latestAvailableDate.plusDays(1))&&//
        		contractDao.existsByTenantIdentityAndAddress(req.getTenantIdentity(), req.getAddress())) {
            return new BasicRes(ResMessage.TENANTIDENTITY_DUPLICATED_FILLIN.getCode(), ResMessage.TENANTIDENTITY_DUPLICATED_FILLIN.getMessage());
        }
        

        if(contractDao.existsByTenantIdentityAndTenantPhoneAndStartDateLessThanEqualAndEndDateGreaterThanEqual( req.getTenantIdentity(),req.getTenantPhone(), req.getStartDate(), latestAvailableDate)) {
            return new BasicRes(ResMessage.TENANTIDENTITY_DUPLICATED_FILLIN.getCode(), ResMessage.TENANTIDENTITY_DUPLICATED_FILLIN.getMessage());
        }
        
        if(contractDao.existsByTenantPhoneAndStartDateLessThanEqualAndEndDateGreaterThanEqual(req.getTenantPhone(), req.getStartDate(), latestAvailableDate)) {
            return new BasicRes(ResMessage.PHONR_DUPLICATED_FILLIN.getCode(), ResMessage.PHONR_DUPLICATED_FILLIN.getMessage());
        }

		//其他參數就不檢查了，因為下面這邊我是直接帶入前面表格的資料，所以就算寫錯，進去資料庫之後也是會自動調整的
        Contract contract = new Contract();
        //抓取創造房間的資訊
        contract.setAddress(roomAddress);//地址
        contract.setFloor(roomAll.getFloor());//樓層
        contract.setRoomId(roomAll.getRoomId());//房間
        contract.setRentP(roomAll.getRentP());//租金
        contract.setCutP(roomAll.getCutP());//違約金
        //房東名子(從房子在抓回管理者)
        contract.setOwnerName(ownerName);
        contract.setOwnerIdentity(registerAll.getOwnerIdentity());
        //抓取填寫的訊息
        contract.setTenantName(req.getTenantName());//承租人姓名
        contract.setTenantEmail(req.getTenantEmail());//承租人信箱
        
        //假設說我的結束時間未結束時，房客的身分證是不能重複的!!
        contract.setTenantIdentity(req.getTenantIdentity());//承租人身分證
        contract.setTenantPhone(req.getTenantPhone());//承租人電話
        contract.setStartDate(req.getStartDate());//承租開始時間
        contract.setEndDate(req.getEndDate());//承租結束時間
        
        contract.setTenantHomeAddress(req.getTenantHomeAddress());
        contract.setTenantContactAddress(req.getTenantContactAddress());
        contract.setOwnerHomeAddress(req.getOwnerHomeAddress());
        contract.setOwnerContactAddress(req.getOwnerContactAddress());
        if(req.getcOther()!=null) {
        	contract.setcOther(req.getcOther());
        }
       
        
        contractDao.save(contract);
		return new BasicRes(ResMessage.SUCCESS.getCode(),
				ResMessage.SUCCESS.getMessage());
	}



	@Override
	public BasicRes updateContract(UpdateContractReq req) {
	    // 檢查是否存在指定的合同流水號
	    Optional<Contract> aiai = contractDao.findById(req.getAi());
	    if (aiai.isEmpty()) {
	        return new BasicRes(ResMessage.AI_IS_NOT_FOUND.getCode(), ResMessage.AI_IS_NOT_FOUND.getMessage());
	    }
	    Contract rentInformation = aiai.get();
	    //填寫的地址錯誤
	    if(!rentInformation.getAddress().equals(req.getAddress())) {
	    	return new BasicRes(ResMessage.ADDRESS_INFORMATION_ERROR.getCode(),//
					ResMessage.ADDRESS_INFORMATION_ERROR.getMessage());
	    }
	    if(rentInformation.getCutDate()!=null) {
	    	return new BasicRes(ResMessage.CUTDATE_REPEAT_FILLIN.getCode(),//
					ResMessage.CUTDATE_REPEAT_FILLIN.getMessage());
	    }
	  if(!req.getCutDate().isAfter(rentInformation.getStartDate()) || !req.getCutDate().isBefore(rentInformation.getEndDate())) {
		  	return new BasicRes(ResMessage.CUTDATE_SET_ERROR.getCode(),//
                  ResMessage.CUTDATE_SET_ERROR.getMessage());
	  }
	    
	    // 取得現有的合同物件
	    Contract update = aiai.get();
	    
	    if(req.getTenantHomeAddress()!=null) {
	    	update.setTenantHomeAddress(req.getTenantHomeAddress());
	    }
	    if(req.getTenantContactAddress()!=null) {
	    	update.setTenantContactAddress(req.getTenantContactAddress());
	    }
	    if(req.getOwnerHomeAddress()!=null) {
	    	update.setOwnerHomeAddress(req.getOwnerHomeAddress());
	    }
	    if(req.getOwnerContactAddress()!=null) {
	    	update.setOwnerContactAddress(req.getOwnerContactAddress());
	    }
	    if(req.getcOther()!=null) {
	    	update.setcOther(req.getcOther());
	    }
	    
	    // 更新現有合同物件的資訊
	    update.setCutDate(req.getCutDate());
	    update.setCutReason(req.getCutReason());

	    // 儲存更新後的合同資訊
	    contractDao.save(update);

	    return new BasicRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage());
	}


}
