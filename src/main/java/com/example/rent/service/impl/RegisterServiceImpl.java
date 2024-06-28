package com.example.rent.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.example.rent.constants.ResMessage;
import com.example.rent.entity.Register;
import com.example.rent.repository.RegisterDao;
import com.example.rent.service.ifs.RegisterService;
import com.example.rent.vo.BasicRes;
import com.example.rent.vo.RegisterReq;
import com.example.rent.vo.RegisterRes;

@Service
public class RegisterServiceImpl implements RegisterService{

	@Autowired
	private RegisterDao registerDao;
	
	@Override
	public RegisterRes register(RegisterReq req) {
		
		//先看看帳號存不存在
		Optional<Register> op=registerDao.findById(req.getOwnerAccount());
		if(op.isEmpty()) {
			//如果沒有帳號，則新增帳號，新增帳號就 "名子"、電話"、"信箱"都必填
			if (!StringUtils.hasText(req.getOwnerName())
	                || !StringUtils.hasText(req.getOwnerPhone())
	                || !StringUtils.hasText(req.getOwnerEmail())) {
	            return new RegisterRes(ResMessage.NAME_PHONE_MEAIL_REQUIRED.getCode(),//
						ResMessage.NAME_PHONE_MEAIL_REQUIRED.getMessage());
	        }
			
			Register register = new Register();
	        register.setOwnerAccount(req.getOwnerAccount());
	        register.setOwnerPwd(req.getOwnerPwd());
	        register.setOwnerName(req.getOwnerName());
	        register.setOwnerPhone(req.getOwnerPhone());
	        register.setOwnerEmail(req.getOwnerEmail());
	        
	        registerDao.save(register);
	        
	        return new RegisterRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage(),//
	        		req.getOwnerAccount(),req.getOwnerName(),req.getOwnerPhone(),req.getOwnerEmail());
		}
		
		
		
		//如果有帳號
		Register register = op.get();
		//先檢查密碼(當我資料庫的密碼與我輸入的密碼不相等時,顯示錯誤)
		if(!register.getOwnerPwd().equals(req.getOwnerPwd())) {
			return new RegisterRes(ResMessage.PWD_ERRO.getCode(),//
					ResMessage.PWD_ERRO.getMessage());
		}
		//如果沒有寫名子/電話/信箱，就抓取資料庫資料，如果有填寫就是變更資料
		if (StringUtils.hasText(req.getOwnerName())) {
	        register.setOwnerName(req.getOwnerName());
	    }
	    if (StringUtils.hasText(req.getOwnerPhone())) {
	        register.setOwnerPhone(req.getOwnerPhone());
	    }
	    if (StringUtils.hasText(req.getOwnerEmail())) {
	        register.setOwnerEmail(req.getOwnerEmail());
	    }
		
		registerDao.save(register);
		
		return new RegisterRes(ResMessage.SUCCESS.getCode(),//
				ResMessage.SUCCESS.getMessage(),req.getOwnerAccount(),register.getOwnerName(),register.getOwnerPhone(),register.getOwnerEmail());
	}

}
