package com.example.rent.constants;

public enum ResMessage {

	SUCCESS(200, "Success!!"),//
	ACCOUNT_IS_REQUIRED(400,"Accoint is required!!"),//帳號必填
	PWD_IS_REQUIRED(400,"PWD is required!!"),//密碼必填
	NAME_PHONE_MEAIL_REQUIRED(400,"name and phone and email required"),//名子、電話、信箱都必填
	NAME_IS_REQUIRED(400,"Name is required!!"),//名子必填
	PHONE_IS_REQUIRED(400,"Phone is required!!"),//電話必填
	EMAIL_IS_REQUIRED(400,"Email is required!!"),//信箱必填
	
	ACCOUNT_NOT_FOUND(400,"Account not found"),//帳號不存在
	PWD_ERRO(400,"Pwd erro"),//密碼錯誤
	
	OLD_PWD_IS_REQUIRED(400,"Old PWD is required!!"),//舊密碼必填
	NEW_PWD_IS_REQUIRED(400,"New PWD is required!!"),//新密碼必填
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
