package com.example.rent.constants;

public enum ResMessage {

	SUCCESS(200, "Success!!"),//
	ERROR(400,"Error!"),//
	
	ACCOUNT_IS_REQUIRED(400,"Accoint is required!!"),//帳號必填
	PWD_IS_REQUIRED(400,"PWD is required!!"),//密碼必填
	NAME_PHONE_MEAIL_REQUIRED(400,"name and phone and email required"),//名子、電話、信箱都必填
	NAME_IS_REQUIRED(400,"Name is required!!"),//名子必填
	PHONE_IS_REQUIRED(400,"Phone is required!!"),//電話必填
	EMAIL_IS_REQUIRED(400,"Email is required!!"),//信箱必填
	PHONR_DUPLICATED_FILLIN(400,"Phone duplocated fillin"),//電話重複填寫
	
	ACCOUNT_NOT_FOUND(400,"Account not found"),//帳號不存在
	PWD_ERRO(400,"Pwd erro"),//密碼錯誤
	
	OLD_PWD_IS_REQUIRED(400,"Old PWD is required!!"),//舊密碼必填
	NEW_PWD_IS_REQUIRED(400,"New PWD is required!!"),//新密碼必填
	
	ADDRESS_IS_REQUIRED(400,"Address is required!!"),//地址必填
	ADDRESS_DUPLICATED_FILLIN(400,"Address duplocated fillin"),//地址重複填寫
	ADDRESS_NOT_FOUND(400,"Address not found!"),//
	
	FLOOR_IS_REQUIRED(400,"Floor is required!!"),//樓層必填
	RID_IS_REQUIRED(400,"R_id is required!!"),//房號必填
	RID_DUPLICATED_FILLIN(400,"R_id duplocated fillin"),//房號重複填寫
	RENTP_IS_REQUIRED(400,"Rent_p is required!!"),//租金必填
	RENTP_IS_ERRO(400,"Rent_p is error!!"),//租金填寫錯誤
	DEPOSIT_IS_REQUIRED(400,"Deposit is required!!"),//押金必填
	DEPOSIT_IS_ERRO(400,"Deposit is error!!"),//押金填寫錯誤
	CUTP_IS_REQUIRED(400,"cut_P is required!!"),//違約金必填
	CUTP_IS_ERRO(400,"cut_P is error!!"),//違約金填寫錯誤
	ELETRICP_IS_REQUIRED(400,"eletric_P is required!!"),//電費一度必填
	ELETRICP_IS_ERRO(400,"eletric_P is error!!"),//電費一度填寫錯誤
	WATERP_IS_REQUIRED(400,"water_P is required!!"),//水費必填
	WATERP_IS_ERRO(400,"water_P is error!!"),//水費填寫錯誤
	MANAGEP_IS_REQUIRED(400,"manage_P is required!!"),//管理費必填
	MANAGEP_IS_ERRO(400,"manage_P is error!!"),//管理費填寫錯誤
	ACREAGE_IS_REQUIRED(400,"acreage is required!!"),//面積必填
	ACREAGE_IS_ERRO(400,"acreage is error!!"),//面積填寫錯誤
	Parking_IS_REQUIRED(400,"acreage is required!!"),//是否有無停車場，必填
	
	;
	
	
	
//	這裡的code指200、400、401、403、404(請求的權限)
	private int code;

	private String message;

//	這個建構方法主要是為了SUCCESS取消紅蚯蚓
//	private是私有所以在這裡也無其他作用了
	private ResMessage(int code, String message) {
		this.code = code;
		this.message = message;
	}

	
//	enum只會用到get，set在此無用
	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	
}
