package com.example.rent.constants;

public enum ResMessage {

	SUCCESS(200, "Success!!"),//
	ERROR(400,"Error!"),//
	
	AI_IS_NOT_FOUND(400,"ai is not found"),//契約書編碼未找到
	AI_IS_REQUIRED(400,"ai is required"),//契約書編碼必田
	
	ACCOUNT_IS_REQUIRED(400,"Accoint is required!!"),//帳號必填
	ACCOUNT_IS_NOT_FOUND(400,"Account is not found"),//帳號不存在
	ACCOUNT_EXIST(400,"Account exist"),//帳號已存在
	ACCOUNT_IS_NULL(400,"Account is null"),
	PWD_IS_NULL(400,"pwd is null"),//
	
	PWD_IS_REQUIRED(400,"PWD is required!!"),//密碼必填
	PWD_ALREADYUSED(400,"pwd already used"),//密碼已有人使用
	
	NAME_PHONE_MEAIL_REQUIRED(400,"name and phone and email required"),//名子、電話、信箱都必填
	NAME_IS_REQUIRED(400,"Name is required!!"),//名子必填
	REGISTER_NAME_ERROR(400,"Register name error"),//房東的名子輸入錯誤
	REGISTER_NAME_IS_NOT_FOUND(400,"Register name is not found"),//房東名子不存在
	
	PHONE_IS_REQUIRED(400,"Phone is required!!"),//電話必填
	PHONE_ERROR(400,"Phone error!!"),//電話格式錯誤
	EMAIL_IS_REQUIRED(400,"Email is required!!"),//信箱必填
	EMAIL_ERROR(400,"Email error!!"),//信箱格式錯誤
	PHONR_DUPLICATED_FILLIN(400,"Phone duplocated fillin"),//電話重複填寫
	
	ACCOUNT_NOT_FOUND(400,"Account not found"),//帳號不存在
	PWD_ERRO(400,"Pwd erro"),//密碼錯誤
	
	OLD_PWD_IS_REQUIRED(400,"Old PWD is required!!"),//舊密碼必填
	NEW_PWD_IS_REQUIRED(400,"New PWD is required!!"),//新密碼必填
	
	ADDRESS_IS_REQUIRED(400,"Address is required!!"),//地址必填
	ADDRESS_DUPLICATED_FILLIN(400,"Address duplocated fillin"),//地址重複填寫
	ADDRESS_NOT_FOUND(400,"Address not found!"),//地址沒有找到
	ADDRESS_INFORMATION_ERROR(400,"Address information error"),//地址資料填寫錯誤
	
	FLOOR_IS_REQUIRED(400,"Floor is required!!"),//樓層必填
	
	PREVIOUS_ROOM_NOT_VACATED(400,"Previous room not vacated"),//前一位房子未退
	RID_FILLIN_ERRO(400,"R_id fillin error!!"),//房號錯誤
	RID_IS_REQUIRED(400,"R_id is required!!"),//房號必填
	RID_DUPLICATED_FILLIN(400,"R_id duplocated fillin"),//房號重複填寫
	ROOM_NOT_RENTED(400,"room not rented"),//房間未出租
	ROOM_OCCUPIED(400,"room occupied"),//房間出租
	
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
	
	TENANTIDENTITY_IS_REQUIRED(400,"Tenant identity is required!!"),//房客身分證必填
	TENANTIDENTITY_ERROR(400,"Tenant identity error"),//身分證輸入錯誤
	TENANTIDENTITY_DUPLICATED_FILLIN(400,"Tenant identity duplocated fillin!"),//房客身分證重複填寫
	TENANTIDENTITY_INFORMATION_ERROR(400,"Tenant identity information error"),//房客資料填寫錯誤
	
	TENANTNAME_IS_REQUIRED(400,"tenantName is required!!"),//房客名子必填
	TENANTPHONE_IS_REQUIRED(400,"tenantPhone is required!!"),//房客電話必填
	TENANTPHONE_ERROR(400,"Tenant phone error"),//電話格式錯誤
	TENANTPHONE_DUPLICATED_FILLIN(400,"Tenant phone duplocated fillin!"),//房客電話重複填寫
	
	TENANTEMAIL_IS_REQUIRED(400,"tenantEmail is required!!"),//房客信箱必填
	TENANTEMAIL_ERROR(400,"Tenant email error"),//信箱輸入格是錯誤
	STARTDATE_IS_REQUIRED(400,"startDate is required!!"),//承租日期必填
	STARTDATE_ERROR(400,"startDate error"),//開始時間錯誤
	ENDDATE_IS_REQUIRED(400,"endDate is required!!"),//結束日期必填
	ENDDATE_ERROR(400,"endDate error"),//開始時間錯誤
	CUTDATE_IS_REQUIRED(400,"cutDate is required!!"),//中止日期
	CUTDATE_REPEAT_FILLIN(400,"cutDate repeat fillin"),//中止日期重複填寫
	CUTDATE_SET_ERROR(400,"cutDate set error"),//中止日期填寫錯誤
	CUTREASON_IS_REQUIRED(400,"cutReason is required!!"),//中止理由
	CUT_P_IS_REQUIRED(400,"cut_p is required"),//違約金必田
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
