package com.example.rent.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.rent.constants.ResMessage;
import com.example.rent.entity.Bill;
import com.example.rent.entity.Contract;
import com.example.rent.entity.Register;
import com.example.rent.entity.Room;
import com.example.rent.repository.BillDao;
import com.example.rent.repository.ContractDao;
import com.example.rent.repository.RegisterDao;
import com.example.rent.repository.RoomDao;
import com.example.rent.service.ifs.RegisterService;
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

@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterDao registerDao;

	// 這裡是契約書
	@Autowired
	private ContractDao contractDao;

	// 建立房間
	@Autowired
	private RoomDao roomDao;

	// 帳單
	@Autowired
	private BillDao billDao;
	
	//信箱
	@Autowired
    private JavaMailSender javaMailSender; 

	// 註冊帳號
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
		// 房東與房客間的身分證重複填寫
		if (contractDao.existsByTenantIdentity(req.getOwnerIdentity())) {
			return new RegisterRes(ResMessage.OWNERIDENTITY_IS_ERROR.getCode(),
					ResMessage.OWNERIDENTITY_IS_ERROR.getMessage());
		}
		// 檢查身分證是否重複
		if (registerDao.existsByOwnerIdentity(req.getOwnerIdentity())) {
			return new RegisterRes(ResMessage.OWNERIDENTITY_IS_ERROR.getCode(), //
					ResMessage.OWNERIDENTITY_IS_ERROR.getMessage());
		}

		// 檢查電話是否重複
		if (registerDao.existsByOwnerPhone(req.getOwnerPhone())) {
			return new RegisterRes(ResMessage.PHONR_DUPLICATED_FILLIN.getCode(), //
					ResMessage.PHONR_DUPLICATED_FILLIN.getMessage());
		}
		if (contractDao.existsByTenantPhone(req.getOwnerPhone())) {
			return new RegisterRes(ResMessage.PHONR_DUPLICATED_FILLIN.getCode(),
					ResMessage.PHONR_DUPLICATED_FILLIN.getMessage());
		}

		// 檢查銀行帳號是否重複
		if (registerDao.existsByAccountBank(req.getAccountBank())) {
			return new RegisterRes(ResMessage.ACCOUNT_BANK_DUPLICATED_FILLIN.getCode(), //
					ResMessage.ACCOUNT_BANK_DUPLICATED_FILLIN.getMessage());
		}

		String verificationCode = RandomStringUtils.randomAlphanumeric(6);

		Register register = new Register();
		register.setOwnerAccount(req.getOwnerAccount());
		register.setOwnerPwd(req.getOwnerPwd());
		register.setOwnerName(req.getOwnerName());
		register.setOwnerPhone(req.getOwnerPhone());
		register.setOwnerEmail(req.getOwnerEmail());
		register.setOwnerIdentity(req.getOwnerIdentity());
		register.setAccountBank(req.getAccountBank());

		
		//保存驗證碼
		register.setEmailVerificationCode(verificationCode);
		
		registerDao.save(register);
		
		// 發送電子郵件
	    sendVerificationEmail(req.getOwnerEmail(), verificationCode);

		return new RegisterRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage(), //
				req.getOwnerAccount(),req.getOwnerPwd(), req.getOwnerName(), req.getOwnerIdentity(), req.getOwnerPhone(),
				req.getOwnerEmail(), req.getAccountBank());
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

	//驗證碼參數
	private void sendVerificationEmail(String ownerEmail, String verificationCode) {
		SimpleMailMessage message = new SimpleMailMessage();
	    message.setTo(ownerEmail);
	    message.setSubject("Verify Your Email Address");
	    message.setText("Your verification code is: " + verificationCode);
	    
	    try {
	        // Send email
	        javaMailSender.send(message);
	        System.out.println("Email sent successfully.");
	    } catch (MailException e) {
	        System.err.println("Failed to send email: " + e.getMessage());
	        // Handle exception appropriately
	    }
		
	}
	
	//檢查驗證碼
	@Override
	public BasicRes verifyEmail(VerifyEmailReq req) {
		//檢查是否都有輸入資訊
		if (req.getOwnerAccount() == null || req.getVerificationCode() == null) {
	        return new BasicRes(ResMessage.INVALID_INPUT.getCode(), 
	                ResMessage.INVALID_INPUT.getMessage());
	    }
		Optional<Register> optionalRegister = registerDao.findById(req.getOwnerAccount());
	    if (optionalRegister.isPresent()) {
	        Register register = optionalRegister.get();
	        //搜尋這著帳號， 如果驗證碼不為null則檢查驗證碼匹配是否正確
	        if (register.getEmailVerificationCode() != null && //
	        		register.getEmailVerificationCode().equals(req.getVerificationCode())) {
	            // 更新用戶為已驗證
	            register.setEmailVerificationCode(null); // 清除驗證碼
	            register.setIsEmailVerified(true); // 設置為已驗證
	            registerDao.save(register);
	            return new BasicRes(ResMessage.SUCCESS.getCode(), //
						ResMessage.SUCCESS.getMessage());
	        } else {
                // 驗證碼不匹配，返回錯誤信息
                return new BasicRes(ResMessage.INVALID_VERIFICATION_CODE.getCode(), 
                        ResMessage.INVALID_VERIFICATION_CODE.getMessage());
            }
        }else {
	        // 找不到用戶，也返回錯誤信息
	        return new BasicRes(ResMessage.ERROR.getCode(), 
	                ResMessage.ERROR.getMessage());
        }
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

		// 檢查郵箱是否已驗證
	    if (!register.getIsEmailVerified()) {
	        return new RegisterRes(ResMessage.EMAIL_NOT_VERIFIED.getCode(), 
	                ResMessage.EMAIL_NOT_VERIFIED.getMessage());
	    }
		
//		 如果舊密碼不等於原本的密碼
		if (!req.getOwnerPwd().equals(register.getOwnerPwd())) {
			return new RegisterRes(ResMessage.PWD_ERRO.getCode(), //
					ResMessage.PWD_ERRO.getMessage());
		}

		return new RegisterRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage(), register.getOwnerAccount(),register.getOwnerPwd(), register.getOwnerName(),
				register.getOwnerIdentity(), register.getOwnerPhone(), register.getOwnerEmail(),
				register.getAccountBank());
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
		// 如果新密碼已經存在則報錯
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
	public RegisterRes updateregister(UpdateRegisterReq req) {
		// 先看看帳號存不存在
		Optional<Register> op = registerDao.findById(req.getOwnerAccount());
		if (op.isEmpty()) {
			return new RegisterRes(ResMessage.ACCOUNT_NOT_FOUND.getCode(), //
					ResMessage.ACCOUNT_NOT_FOUND.getMessage());
		}
		Register register = op.get();

		String account = register.getOwnerAccount();
		String phone = register.getOwnerPhone();
		// 更新資料時也要注意電話不重複

		// 帳號相同時，允許手機號存在
		// 當帳號不同時，不允許手機號同時存在
		if (!phone.equals(req.getOwnerPhone())) {
			if (registerDao.existsByOwnerPhone(req.getOwnerPhone())) {
				return new RegisterRes(ResMessage.PHONR_DUPLICATED_FILLIN.getCode(), //
						ResMessage.PHONR_DUPLICATED_FILLIN.getMessage());
			}
		}

		if (req.getOwnerName() != null) {
			register.setOwnerName(req.getOwnerName());
		}
		if (req.getOwnerPhone() != null) {
			register.setOwnerPhone(req.getOwnerPhone());
		}
		if (req.getOwnerEmail() != null) {
			register.setOwnerEmail(req.getOwnerEmail());
		}

		if (req.getAccountBank() != null) {
			register.setAccountBank(req.getAccountBank());
		}

		registerDao.save(register);

		return new RegisterRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage(), register.getOwnerAccount(),register.getOwnerPwd(), register.getOwnerName(),
				register.getOwnerIdentity(), register.getOwnerPhone(), register.getOwnerEmail(),
				register.getAccountBank());
	}

	@Override
	public AllInformationRes allInformation(AllInformationReq req) {
		// 如果req的帳號為null，則顯示全部資訊
		String ownerAccount = req.getOwnerAccount();
		List<Room> roomList;
		List<Contract> contractList;
		List<Bill> billList;

		if (!StringUtils.hasText(ownerAccount)) {
			// 顯示全部房間資訊
			roomList = roomDao.findAll();
			// 顯示全部契約資訊
			contractList = contractDao.findAll();
			// 顯示全部帳單資訊
			billList = billDao.findAll();

		} else {
			// 顯示此房東的全部資訊
			// 房間資訊
			roomList = roomDao.findByAccountEquals(ownerAccount);
			// 契約資訊
			contractList = contractDao.findByOwnerAccountEquals(ownerAccount);

			// 獲取與此房東相關的所有地址
			String address = null;
			for (Contract item : contractList) {
				address = item.getAddress();
			}

			// 根據地址找到相關的帳單資訊
			billList = billDao.findByAddressEquals(address);
		}

		// 如果req的房東帳號不為空值，則顯示此房東的全部資訊
		// 房間資訊
		// 契約資訊
		// 帳單資訊
//		Optional<Register> register=registerDao.findById(req.getOwnerAccount());
//		List<Room> roomList=roomDao.findByAccountEquals(req.getOwnerAccount());
//		List<Contract> contractList=contractDao.findByOwnerAccountEquals(req.getOwnerAccount());
//		String address=null;
//		for(Contract item:contractList) {
//			address=item.getAddress();
//		}
//		List<Bill> billList=billDao.findByAddressEquals(address);
		return new AllInformationRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage(), roomList, contractList, billList);
	}

	

}
