package com.example.rent.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.rent.constants.ResMessage;
import com.example.rent.service.ifs.BillService;
import com.example.rent.service.ifs.ContractService;
import com.example.rent.service.ifs.RegisterService;
import com.example.rent.service.ifs.RoomService;
import com.example.rent.vo.AllInformationReq;
import com.example.rent.vo.AllInformationRes;
import com.example.rent.vo.BasicRes;
import com.example.rent.vo.BillForContractReq;
import com.example.rent.vo.BillForContractRes;
import com.example.rent.vo.BillReq;
import com.example.rent.vo.BillRes;
import com.example.rent.vo.BillSearchReq;
import com.example.rent.vo.BillSearchRes;
import com.example.rent.vo.ContractSearchReq;
import com.example.rent.vo.ContractSearchRes;
import com.example.rent.vo.CreateContractReq;
import com.example.rent.vo.CreateRoomAndphotoReq;
import com.example.rent.vo.CreateRoomReq;
import com.example.rent.vo.DeleteRoomReq;
import com.example.rent.vo.LoginReq;
import com.example.rent.vo.RegisterReq;
import com.example.rent.vo.RegisterRes;
import com.example.rent.vo.RoomSearchReq;
import com.example.rent.vo.RoomSearchRes;
import com.example.rent.vo.TenantListReq;
import com.example.rent.vo.TenantListRes;
import com.example.rent.vo.UpdateBillReq;
import com.example.rent.vo.UpdateContractReq;
import com.example.rent.vo.UpdateCutDateReq;
import com.example.rent.vo.UpdatePwdReq;
import com.example.rent.vo.UpdatePwdRes;
import com.example.rent.vo.UpdateRoomReq;
import com.example.rent.vo.VerifyEmailReq;
import com.example.rent.vo.UpdateRegisterReq;

@CrossOrigin
@RestController
public class RegisterController {

	@Autowired
	private RegisterService registerService;

	@Autowired
	private RoomService roomService;

	@Autowired
	private ContractService contractService;

	@Autowired
	private BillService billService;

//	@Autowired
//	private Bill2Service bill2Service;

	// 帳號註冊
	// value後面是postman要連接的網址
	@PostMapping(value = "rent/account")
	public BasicRes register(@Valid @RequestBody RegisterReq req) {
		return registerService.register(req);

	}
	
	//驗證碼檢驗
	@PostMapping(value = "rent/verifyEmail")
	public BasicRes verifyEmail( @RequestBody VerifyEmailReq req) {
		return registerService.verifyEmail(req);
	}

	// 帳號登入
	@PostMapping(value = "rent/login")
	public RegisterRes login(@Valid @RequestBody LoginReq req,HttpSession session) {
//		session.setMaxInactiveInterval(30); //設定秒數 ;預設值為30分鐘
		System.out.println("session_id: "+session.getId());
		System.out.println("account:"+session.getAttribute("account"));
		if(session.getAttribute("account")!=null) {
			return new RegisterRes(ResMessage.SUCCESS.getCode(),ResMessage.SUCCESS.getMessage());
		}
		RegisterRes res = registerService.login(req);
		if(res.getCode()==200) {
			session.setAttribute("account", req.getOwnerAccount());
		}
		System.out.println("account:"+session.getAttribute("account"));
		return res;
	}

	// 更新密碼
	@PostMapping(value = "rent/updatePwd")
	public UpdatePwdRes updatePwd(@Valid @RequestBody UpdatePwdReq req,HttpSession session) {
		if(session.getAttribute("account")==null) {
			return new UpdatePwdRes(ResMessage.PLEASE_FIRST_LONGIN.getCode(),ResMessage.PLEASE_FIRST_LONGIN.getMessage());
		}
		return registerService.updatePwd(req);
	}

	// 更新個人資訊(姓名、電話、信箱)
	@PostMapping(value = "rent/updateregister")
	public RegisterRes updateregister(@Valid @RequestBody UpdateRegisterReq req,HttpSession session) {
		if(session.getAttribute("account")==null) {
			return new RegisterRes(ResMessage.PLEASE_FIRST_LONGIN.getCode(),ResMessage.PLEASE_FIRST_LONGIN.getMessage());
		}
		return registerService.updateregister(req);
	}

	// 創造房間資訊
	@PostMapping(value = "room/creatRoom1")
	public BasicRes creatRoom(@Valid @RequestBody CreateRoomReq req,HttpSession session) {
		if(session.getAttribute("account")==null) {
			return new BasicRes(ResMessage.PLEASE_FIRST_LONGIN.getCode(),ResMessage.PLEASE_FIRST_LONGIN.getMessage());
		}
		return roomService.creatRoom(req);
	}

	// 更新房間資訊
	@PostMapping(value = "room/updateRoom")
	public BasicRes updateRoom(@Valid @RequestBody UpdateRoomReq req,HttpSession session) {
		if(session.getAttribute("account")==null) {
			return new BasicRes(ResMessage.PLEASE_FIRST_LONGIN.getCode(),ResMessage.PLEASE_FIRST_LONGIN.getMessage());
		}
		return roomService.updateRoom(req);
	}

	// 房間搜索(會跳出所有房東的資料，不是單獨的房東資料喔!)
	@PostMapping(value = "room/roomSearch")
	public RoomSearchRes roomSearch(@Valid @RequestBody RoomSearchReq req,HttpSession session) {
		if(session.getAttribute("account")==null) {
			return new RoomSearchRes(ResMessage.PLEASE_FIRST_LONGIN.getCode(),ResMessage.PLEASE_FIRST_LONGIN.getMessage());
		}
		return roomService.roomSearch(req);
	}

	// 刪除房間
	@PostMapping(value = "room/deleteRoom")
	public BasicRes deleteRoom(@Valid @RequestBody DeleteRoomReq req,HttpSession session) {
		if(session.getAttribute("account")==null) {
			return new BasicRes(ResMessage.PLEASE_FIRST_LONGIN.getCode(),ResMessage.PLEASE_FIRST_LONGIN.getMessage());
		}
		return roomService.deleteRoom(req);
	}

	// 創造契約書
	@PostMapping(value = "contract/createContract")
	public BasicRes createContract(@Valid @RequestBody CreateContractReq req,HttpSession session) {
		if(session.getAttribute("account")==null) {
			return new BasicRes(ResMessage.PLEASE_FIRST_LONGIN.getCode(),ResMessage.PLEASE_FIRST_LONGIN.getMessage());
		}
		return contractService.createContract(req);
	}

	// 更新契約書(違約部分)
	@PostMapping(value = "contract/updateContract")
	public BasicRes updateContract(@Valid @RequestBody UpdateContractReq req,HttpSession session) {
		if(session.getAttribute("account")==null) {
			return new BasicRes(ResMessage.PLEASE_FIRST_LONGIN.getCode(),ResMessage.PLEASE_FIRST_LONGIN.getMessage());
		}
		return contractService.updateContract(req);
	}

	// 契約書搜索
	@PostMapping(value = "contract/contratSearch")
	public ContractSearchRes contratSearch(@Valid @RequestBody ContractSearchReq req,HttpSession session) {
		if(session.getAttribute("account")==null) {
			return new ContractSearchRes(ResMessage.PLEASE_FIRST_LONGIN.getCode(),ResMessage.PLEASE_FIRST_LONGIN.getMessage());
		}
		return contractService.contratSearch(req);
	}

	// 帳單(一期一期的)
	@PostMapping(value = "bill/BillsForContract")
	public BillForContractRes BillsForContract(@Valid @RequestBody BillForContractReq req,HttpSession session) {
		if(session.getAttribute("account")==null) {
			return new BillForContractRes(ResMessage.PLEASE_FIRST_LONGIN.getCode(),ResMessage.PLEASE_FIRST_LONGIN.getMessage());
		}
		return billService.BillsForContract(req);
	}

	// 帳單
	@PostMapping(value = "bill/bill")
	public BillRes bill(@Valid @RequestBody BillReq req) {
		return billService.bill(req);
	}

	// 帳單更新
	@PostMapping(value = "bill/updateBill")
	public BillRes updateBill(@Valid @RequestBody UpdateBillReq req,HttpSession session) {
		if(session.getAttribute("account")==null) {
			return new BillRes(ResMessage.PLEASE_FIRST_LONGIN.getCode(),ResMessage.PLEASE_FIRST_LONGIN.getMessage());
		}
		return billService.updateBill(req);
	}

	@PostMapping(value = "bill/updateCutDate")
	public BillRes updateCutDate(@Valid @RequestBody UpdateCutDateReq req,HttpSession session) {
		if(session.getAttribute("account")==null) {
			return new BillRes(ResMessage.PLEASE_FIRST_LONGIN.getCode(),ResMessage.PLEASE_FIRST_LONGIN.getMessage());
		}
		return billService.updateCutDate(req);
	}

	// 帳單搜索
	@PostMapping(value = "bill/billSearch")
	public BillSearchRes billSearch(@Valid @RequestBody BillSearchReq req,HttpSession session) {
		if(session.getAttribute("account")==null) {
			return new BillSearchRes(ResMessage.PLEASE_FIRST_LONGIN.getCode(),ResMessage.PLEASE_FIRST_LONGIN.getMessage());
		}
		return billService.billSearch(req);
	}

	// 房客的全部資訊
	@PostMapping(value = "bill/tenantList")
	public TenantListRes tenantList(@Valid @RequestBody TenantListReq req) {
//	public TenantListRes tenantList(@Valid @RequestBody TenantListReq req,HttpSession session) {
//		if(session.getAttribute("account")==null) {
//			return new TenantListRes(ResMessage.PLEASE_FIRST_LONGIN.getCode(),ResMessage.PLEASE_FIRST_LONGIN.getMessage());
//		}
		return contractService.tenantList(req);
	}

	// 傳入圖片
	@PostMapping(value = "/room/insertPhoto")
	public BasicRes insertPhoto(@RequestParam("address") String address, @RequestParam("photo") MultipartFile photo) {
		try {
			byte[] photoBytes = photo.getBytes();
			return roomService.insertPhoto(address, photoBytes);
		} catch (Exception e) {
			return new BasicRes(ResMessage.ERROR.getCode(), ResMessage.ERROR.getMessage());
		}
	}

	// 房間req再加上圖片
	@PostMapping(value = "/room/creatRoomAndInsertPhoto", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)

	public BasicRes creatRoomAndInsertPhoto(@Valid @RequestPart("room") CreateRoomReq req,
			@RequestPart("photo") MultipartFile photo) {
		try {
			byte[] photoBytes = photo.getBytes();
			return roomService.creatRoomAndInsertPhoto(req, photoBytes);
		} catch (Exception e) {
			return new BasicRes(ResMessage.ERROR.getCode(), ResMessage.ERROR.getMessage());
		}
	}

	@PostMapping(value = "room/creatRoom")
	public BasicRes creatRoom(@RequestParam("photo") MultipartFile photo, @RequestParam("address") String address,
			@RequestParam("account") String account, @RequestParam("floor") String floor,
			@RequestParam("rId") String rId, @RequestParam("rentP") int rentP, @RequestParam("deposit") int deposit,
			@RequestParam("cutP") int cutP, @RequestParam("eletricP") int eletricP, @RequestParam("waterP") int waterP,
			@RequestParam("manageP") int manageP, @RequestParam("acreage") int acreage,
			@RequestParam("parking") boolean parking, @RequestParam("equip") String equip,
			@RequestParam("rOther") String rOther,HttpSession session) {
		
		if(session.getAttribute("account")==null) {
			return new BasicRes(ResMessage.PLEASE_FIRST_LONGIN.getCode(),ResMessage.PLEASE_FIRST_LONGIN.getMessage());
		}
		
		CreateRoomAndphotoReq req = new CreateRoomAndphotoReq();
		req.setAddress(address);
		req.setAccount(account);
		req.setFloor(floor);
		req.setrId(rId);
		req.setRentP(rentP);
		req.setDeposit(deposit);
		req.setCutP(cutP);
		req.setEletricP(eletricP);
		req.setWaterP(waterP);
		req.setManageP(manageP);
		req.setAcreage(acreage);
		req.setParking(parking);
		req.setEquip(equip);
		req.setrOther(rOther);

		try {
			req.setPhoto(photo.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
			return new BasicRes(ResMessage.ERROR.getCode(), "Failed to process photo");
		}

		return roomService.creatRoomAndphoto(req);
	}

	// 所有資訊
	@PostMapping(value = "/room/allInformation")
	public AllInformationRes allInformation(@Valid @RequestBody AllInformationReq req) {
//	public AllInformationRes allInformation(@Valid @RequestBody AllInformationReq req,HttpSession session) {
//		if(session.getAttribute("account")==null) {
//			return new AllInformationRes(ResMessage.PLEASE_FIRST_LONGIN.getCode(),ResMessage.PLEASE_FIRST_LONGIN.getMessage());
//		}
		return registerService.allInformation(req);
	}

}
