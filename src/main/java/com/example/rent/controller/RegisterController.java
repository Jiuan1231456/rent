package com.example.rent.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rent.service.ifs.RegisterService;
import com.example.rent.vo.BasicRes;
import com.example.rent.vo.RegisterReq;
import com.example.rent.vo.UpdatePwdReq;
import com.example.rent.vo.UpdatePwdRes;

@CrossOrigin
@RestController
public class RegisterController {

	@Autowired
	private RegisterService registerService;
	
	@PostMapping(value = "rent/account")
	public BasicRes register(@Valid @RequestBody RegisterReq req) {
		return registerService.register(req);
		
	}
	
	@PostMapping(value = "rent/updatePwd")
	public UpdatePwdRes updatePwd(@Valid @RequestBody UpdatePwdReq req) {
		return registerService.updatePwd(req);
	}
	
}
