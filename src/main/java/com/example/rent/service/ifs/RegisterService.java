package com.example.rent.service.ifs;

import javax.validation.Valid;

import com.example.rent.vo.CreateRoomReq;
import com.example.rent.vo.RegisterReq;
import com.example.rent.vo.RegisterRes;
import com.example.rent.vo.UpdatePwdReq;
import com.example.rent.vo.UpdatePwdRes;

public interface RegisterService {

	public RegisterRes register(RegisterReq req);
	
	public UpdatePwdRes updatePwd(UpdatePwdReq req);


}
