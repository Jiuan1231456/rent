package com.example.rent.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.rent.constants.ResMessage;
import com.example.rent.entity.Register;
import com.example.rent.repository.RegisterDao;
import com.example.rent.service.ifs.RegisterService;
import com.example.rent.vo.BasicRes;
import com.example.rent.vo.LoginReq;
import com.example.rent.vo.RegisterReq;
import com.example.rent.vo.RegisterRes;
import com.example.rent.vo.UpdatePwdReq;
import com.example.rent.vo.UpdatePwdRes;
import com.example.rent.vo.updateRegisterReq;

@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterDao registerDao;

	// 新增帳號與個人資訊 或者 更新個人資訊 或者單純進入
	@Override
	public RegisterRes register(RegisterReq req) {

		// 先看看帳號存不存在
//		Optional<Register> op=registerDao.findById(req.getOwnerAccount());
		// 如果已存在，則直接登入，不需註冊
		if (registerDao.existsByOwnerAccount(req.getOwnerAccount())) {
			return new RegisterRes(ResMessage.ACCOUNT_EXIST.getCode(), //
					ResMessage.ACCOUNT_EXIST.getMessage());
//			//如果沒有帳號，則新增帳號，新增帳號就 "名子"、電話"、"信箱"都必填
//			if (!StringUtils.hasText(req.getOwnerName())
//	                || !StringUtils.hasText(req.getOwnerPhone())
//	                || !StringUtils.hasText(req.getOwnerEmail())) {
//	            return new RegisterRes(ResMessage.NAME_PHONE_MEAIL_REQUIRED.getCode(),//
//						ResMessage.NAME_PHONE_MEAIL_REQUIRED.getMessage());
//	        }
//			//增加一個，電話不重複
//			if(registerDao.existsByOwnerPhone(req.getOwnerPhone())) {
//				return new RegisterRes(ResMessage.PHONR_DUPLICATED_FILLIN.getCode(),//
//						ResMessage.PHONR_DUPLICATED_FILLIN.getMessage());
		}
		// 檢查密碼是否有人使用
		if (registerDao.existsByOwnerPwd(req.getOwnerPwd())) {
			return new RegisterRes(ResMessage.PWD_ALREADYUSED.getCode(), //
					ResMessage.PWD_ALREADYUSED.getMessage());
		}
		// 檢查電話是否重複
		if (registerDao.existsByOwnerPhone(req.getOwnerPhone())) {
			return new RegisterRes(ResMessage.PHONR_DUPLICATED_FILLIN.getCode(), //
					ResMessage.PHONR_DUPLICATED_FILLIN.getMessage());
		}

		Register register = new Register();
		register.setOwnerAccount(req.getOwnerAccount());
		register.setOwnerPwd(req.getOwnerPwd());
		register.setOwnerName(req.getOwnerName());
		register.setOwnerPhone(req.getOwnerPhone());
		register.setOwnerEmail(req.getOwnerEmail());

		registerDao.save(register);

		return new RegisterRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage(), //
				req.getOwnerAccount(), req.getOwnerName(), req.getOwnerPhone(), req.getOwnerEmail());
//	}

//		//如果有帳號
//		Register register = op.get();
//		//先檢查密碼(當我資料庫的密碼與我輸入的密碼不相等時,顯示錯誤)
//		if(!register.getOwnerPwd().equals(req.getOwnerPwd())) {
//			return new RegisterRes(ResMessage.PWD_ERRO.getCode(),//
//					ResMessage.PWD_ERRO.getMessage());
//		}
//		//如果沒有寫名子/電話/信箱，就抓取資料庫資料，如果有填寫就是變更資料
//		if (StringUtils.hasText(req.getOwnerName())) {
//			//更新資料時也要注意電話不重複
//			if(registerDao.existsByOwnerPhone( req.getOwnerPhone())) {
//				return new RegisterRes(ResMessage.PHONR_DUPLICATED_FILLIN.getCode(),//
//						ResMessage.PHONR_DUPLICATED_FILLIN.getMessage());
//			}
//	        register.setOwnerName(req.getOwnerName());
//	    }
//	    if (StringUtils.hasText(req.getOwnerPhone())) {
//	        register.setOwnerPhone(req.getOwnerPhone());
//	    }
//	    if (StringUtils.hasText(req.getOwnerEmail())) {
//	        register.setOwnerEmail(req.getOwnerEmail());
//	    }
//		
//		registerDao.save(register);

//		return new RegisterRes(ResMessage.SUCCESS.getCode(),//
//				ResMessage.SUCCESS.getMessage(),req.getOwnerAccount(),register.getOwnerName(),register.getOwnerPhone(),register.getOwnerEmail());
	}

	// 進行帳號登入
	@Override
	public RegisterRes login(LoginReq req) {
		// 先看看帳號存不存在
		Optional<Register> op = registerDao.findById(req.getOwnerAccount());
		if (op.isEmpty()) {
			return new RegisterRes(ResMessage.ACCOUNT_NOT_FOUND.getCode(), //
					ResMessage.ACCOUNT_NOT_FOUND.getMessage());
		}
		Register register = op.get();

//		 如果舊密碼不等於原本的密碼
		if (!req.getOwnerPwd().equals(register.getOwnerPwd())) {
			return new RegisterRes(ResMessage.PWD_ERRO.getCode(), //
					ResMessage.PWD_ERRO.getMessage());
		}

		return new RegisterRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage(), register.getOwnerAccount(), register.getOwnerName(),
				register.getOwnerPhone(), register.getOwnerEmail());
	}

	// 變更密碼
	@Override
	public UpdatePwdRes updatePwd(UpdatePwdReq req) {
		// 先看看帳號存不存在
		Optional<Register> op = registerDao.findById(req.getOwnerAccount());
		if (op.isEmpty()) {
			return new UpdatePwdRes(ResMessage.ACCOUNT_NOT_FOUND.getCode(), //
					ResMessage.ACCOUNT_NOT_FOUND.getMessage());
		}
		Register register = op.get();
		// 如果舊密碼不等於原本的密碼
		if (!req.getOwnerOldPwd().equals(register.getOwnerPwd())) {
			return new UpdatePwdRes(ResMessage.PWD_ERRO.getCode(), //
					ResMessage.PWD_ERRO.getMessage());
		}
		// 如果新密碼已經存在則抱錯
		if (registerDao.existsByOwnerPwd(req.getOwnerNewPwd())) {
			return new UpdatePwdRes(ResMessage.PWD_ALREADYUSED.getCode(), //
					ResMessage.PWD_ALREADYUSED.getMessage());
		}
		register.setOwnerPwd(req.getOwnerNewPwd());
		registerDao.save(register);
		return new UpdatePwdRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage(), req.getOwnerAccount(), req.getOwnerOldPwd(), req.getOwnerNewPwd());
	}

	// 更新個人資訊
	@Override
	public RegisterRes updateregister(updateRegisterReq req) {
		// 先看看帳號存不存在
		Optional<Register> op = registerDao.findById(req.getOwnerAccount());
		if (op.isEmpty()) {
			return new RegisterRes(ResMessage.ACCOUNT_NOT_FOUND.getCode(), //
					ResMessage.ACCOUNT_NOT_FOUND.getMessage());
		}
		Register register = op.get();
<<<<<<< HEAD

		// 更新資料時也要注意電話不重複

		// 帳號相同時，允許手機號存在
		// 當帳號不同時，不允許手機號同時存在
		String phone = register.getOwnerPhone();
		if (!phone.equals(req.getOwnerPhone())) {
			if (registerDao.existsByOwnerPhone(req.getOwnerPhone())) {
				return new RegisterRes(ResMessage.PHONR_DUPLICATED_FILLIN.getCode(), //
						ResMessage.PHONR_DUPLICATED_FILLIN.getMessage());
			}
		}

		if (req.getOwnerName() != null) {
=======
		String account = register.getOwnerAccount();
		String phone = register.getOwnerPhone();
		//更新資料時也要注意電話不重複
		
		//帳號相同時，允許手機號存在
		//當帳號不同時，不允許手機號同時存在
		if(!phone.equals(req.getOwnerPhone())) {
			if(registerDao.existsByOwnerPhone( req.getOwnerPhone())) {
				return new RegisterRes(ResMessage.PHONR_DUPLICATED_FILLIN.getCode(),//
						ResMessage.PHONR_DUPLICATED_FILLIN.getMessage());
			}
		}
		
		
		if(req.getOwnerName()!=null) {
>>>>>>> 2f5532c0dc523b51151f73cd921d5deb776bf16d
			register.setOwnerName(req.getOwnerName());
		}
		if (req.getOwnerPhone() != null) {
			register.setOwnerPhone(req.getOwnerPhone());
		}
		if (req.getOwnerEmail() != null) {
			register.setOwnerEmail(req.getOwnerEmail());
		}

		registerDao.save(register);

		return new RegisterRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage(), register.getOwnerAccount(), register.getOwnerName(),
				register.getOwnerPhone(), register.getOwnerEmail());
	}

}
