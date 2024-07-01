package com.example.rent.service.ifs;

import com.example.rent.vo.LoginReq;
import com.example.rent.vo.RegisterReq;
import com.example.rent.vo.RegisterRes;
import com.example.rent.vo.UpdatePwdReq;
import com.example.rent.vo.UpdatePwdRes;
import com.example.rent.vo.updateRegisterReq;

public interface RegisterService {

	//註冊資料
	public RegisterRes register(RegisterReq req);
	
	//更新個資
	public RegisterRes updateregister(updateRegisterReq req);

	//登入
	public RegisterRes login(LoginReq req);

	//更新密碼
	public UpdatePwdRes updatePwd(UpdatePwdReq req);

}
