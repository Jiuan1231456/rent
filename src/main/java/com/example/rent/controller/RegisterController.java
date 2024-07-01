package com.example.rent.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rent.service.ifs.ContractService;
import com.example.rent.service.ifs.RegisterService;
import com.example.rent.service.ifs.RoomService;
import com.example.rent.vo.BasicRes;
import com.example.rent.vo.CreateContractReq;
import com.example.rent.vo.CreateRoomReq;
import com.example.rent.vo.LoginReq;
import com.example.rent.vo.RegisterReq;
import com.example.rent.vo.RegisterRes;
import com.example.rent.vo.RoomSearchReq;
import com.example.rent.vo.RoomSearchRes;
import com.example.rent.vo.UpdateContractReq;
import com.example.rent.vo.UpdatePwdReq;
import com.example.rent.vo.UpdatePwdRes;
import com.example.rent.vo.UpdateRoomReq;
import com.example.rent.vo.updateRegisterReq;

@CrossOrigin
@RestController
public class RegisterController {

	@Autowired
	private RegisterService registerService;

	@Autowired
	private RoomService roomService;
	
	@Autowired
	private ContractService contractService;

	//帳號註冊
	@PostMapping(value = "rent/account")
	public BasicRes register(@Valid @RequestBody RegisterReq req) {
		return registerService.register(req);

	}
	
	//帳號登入
	@PostMapping(value = "rent/login")
	public RegisterRes login(@Valid @RequestBody LoginReq req) {
		return registerService.login(req);
	}

	//更新密碼
	@PostMapping(value = "rent/updatePwd")
	public UpdatePwdRes updatePwd(@Valid @RequestBody UpdatePwdReq req) {
		return registerService.updatePwd(req);
	}
	
	//更新個人資訊(姓名、電話、信箱)
	@PostMapping(value = "rent/updateregister")
	public RegisterRes updateregister(@Valid @RequestBody updateRegisterReq req) {
		return registerService.updateregister(req);
	}

	//創造房間資訊
	@PostMapping(value = "room/creatRoom1")
	public BasicRes creatRoom(@Valid @RequestBody CreateRoomReq req) {
		return roomService.creatRoom(req);
	}
	
	
	//更新房間資訊
	@PostMapping(value = "room/updateRoom")
	public BasicRes updateRoom(@Valid @RequestBody UpdateRoomReq req) {
		return roomService.updateRoom(req);
	}
	
	//房間搜索(會跳出所有房東的資料，不是單獨的房東資料喔!)
	@PostMapping(value = "room/roomSearch")
	public RoomSearchRes roomSearch(@Valid @RequestBody RoomSearchReq req) {
		return roomService.roomSearch(req);
	}
	
	//創造契約書
	@PostMapping(value = "contract/createContract")
	public BasicRes createContract(@Valid @RequestBody CreateContractReq req) {
		return contractService.createContract(req);
	}
	
	//更新契約書(違約部分)
	@PostMapping(value = "contract/updateContract")
	public BasicRes updateContract(@Valid @RequestBody UpdateContractReq req) {
		return contractService.updateContract(req);
	}
	
	/*
	@PostMapping(value = "room/creatRoom")
	public BasicRes creatRoom(@RequestParam("photo") MultipartFile photo, @RequestParam("address") String address,
			@RequestParam("account") String account, @RequestParam("floor") String floor,
			@RequestParam("rId") String rId, @RequestParam("rentP") int rentP, @RequestParam("deposit") int deposit,
			@RequestParam("cutP") int cutP, @RequestParam("eletricP") int eletricP, @RequestParam("waterP") int waterP,
			@RequestParam("manageP") int manageP, @RequestParam("acreage") int acreage,
			@RequestParam("parking") boolean parking, @RequestParam("equip") String equip) {

		CreateRoomReq req = new CreateRoomReq();
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

		try {
			req.setPhoto(photo.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
			return new BasicRes(ResMessage.ERROR.getCode(), "Failed to process photo");
		}

		return roomService.creatRoom(req);
	}*/



}
