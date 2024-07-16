package com.example.rent.service.ifs;

import com.example.rent.vo.AllInformationReq;
import com.example.rent.vo.AllInformationRes;
import com.example.rent.vo.BasicRes;
import com.example.rent.vo.LoginReq;
import com.example.rent.vo.RegisterReq;
import com.example.rent.vo.RegisterRes;
import com.example.rent.vo.UpdatePwdReq;
import com.example.rent.vo.UpdatePwdRes;
import com.example.rent.vo.UpdateRegisterReq;
import com.example.rent.vo.VerifyEmailReq;

public interface RegisterService {

	//註冊資料
	public RegisterRes register(RegisterReq req);
	
	//檢查驗證碼
	public BasicRes verifyEmail(VerifyEmailReq req);
	
	//更新個資
	public RegisterRes updateregister(UpdateRegisterReq req);

	//登入
	public RegisterRes login(LoginReq req);

	//更新密碼
	public UpdatePwdRes updatePwd(UpdatePwdReq req);
	
	//所有資訊
	public AllInformationRes allInformation(AllInformationReq req);

}
