package com.example.rent.constants;

public enum ResMessage {
	/*
	200 OK - 請求成功並返回結果。最常見的狀態碼，表示操作已成功完成。
	201 Created - 請求已成功處理並創建了"新"的資源。常用於創建新資源的情境。
	204 No Content - 請求成功，但沒有返回內容。常用於"刪除"操作或"更新"操作成功但無需返回數據的情況。
	400 Bad Request - 請求無法被伺服器理解，通常由於語法錯誤或無效的請求參數。
	401 Unauthorized - 請求需要身份驗證。用於"身份驗證失敗"或"未提供身份驗證信息"的情況。
	403 Forbidden - 伺服器理解請求，但"拒絕執行"。用於用戶"沒有權限"進行該操作的情況。
	404 Not Found - 請求的資源"未找到"。用於資源"不存在"或"無法找到"的情況。
	409 Conflict - 請求的操作與伺服器的現有狀態發生衝突。常用於處理"資源衝突"的情況，例如帳號已存在。
	422 Unprocessable Entity - 請求格式正確，但無法處理。用於提供的數據符合語法規範，但無法處理的情況，例如驗證錯誤。
	500 Internal Server Error - 伺服器遇到意外情況，無法完成請求。這是伺服器端的通用錯誤。
	502 Bad Gateway - 伺服器作為網關或代理時收到無效回應。通常是代理伺服器的問題。
	503 Service Unavailable - 伺服器目前無法處理請求，通常是由於過載或維護。
	504 Gateway Timeout - 伺服器作為網關或代理時，沒有收到來自上游伺服器的及時回應。
	 */
	
	
	SUCCESS(200, "Success!!"),//
	ERROR(400,"Error!"),//
	
	PLEASE_FIRST_LONGIN(400,"Please first login"),//請先登入
//	PLEASE_FIRST_LONGIN(401,"Please first login"),
	
//	AI_IS_NOT_FOUND(400,"ai is not found"),//契約書編碼未找到
	AI_IS_NOT_FOUND(404,"AI is not found"),
	
	AI_IS_REQUIRED(400,"ai is required"),//契約書編碼必填
	
	ACCOUNT_IS_REQUIRED(400,"Account is required!!"),//帳號必填
	
//	ACCOUNT_IS_NOT_FOUND(400,"Account is not found"),//帳號不存在
	ACCOUNT_IS_NOT_FOUND(404,"Account is not found"), 
	
//	ACCOUNT_EXIST(400,"Account exist"),//帳號已存在
	ACCOUNT_EXIST(409,"Account exists"),
	
	ACCOUNT_IS_NULL(400,"Account is null"),
	PWD_IS_NULL(400,"Pwd is null"),//
	
	PWD_IS_REQUIRED(400,"PWD is required!!"),//密碼必填
	
	ACCOUNT_BANK_IS_REQUIRED(400,"account Bank is required!!"),//銀行帳號必填
	ACCOUNT_BANK_ERROR(400,"account Bank error"),//銀行帳號錯誤
//	ACCOUNT_BANK_DUPLICATED_FILLIN(400,"account Bank duplocated fillin"),//帳號可能重複填寫
	ACCOUNT_BANK_DUPLICATED_FILLIN(409,"account Bank duplocated fillin"),//帳號可能重複填寫
	
	NAME_PHONE_MEAIL_REQUIRED(400,"name and phone and email required"),//名子、電話、信箱都必填
	NAME_IS_REQUIRED(400,"Name is required!!"),//名子必填
	REGISTER_NAME_ERROR(400,"Register name error"),//房東的名子輸入錯誤
//	REGISTER_NAME_IS_NOT_FOUND(400,"Register name is not found"),//房東名子不存在
	REGISTER_NAME_IS_NOT_FOUND(404,"Register name is not found"),
	
	PHONE_IS_REQUIRED(400,"Phone is required!!"),//電話必填
//	PHONE_ERROR(400,"Phone error!!"),//電話格式錯誤
	PHONE_ERROR(422,"Phone error!!"),//電話格式錯誤
	
	EMAIL_IS_REQUIRED(400,"Email is required!!"),//信箱必填
//	EMAIL_ERROR(400,"Email error!!"),//信箱格式錯誤
	EMAIL_ERROR(422,"Email error!!"),//信箱格式錯誤
	
//	PHONR_DUPLICATED_FILLIN(400,"Phone duplocated fillin"),//電話重複填寫
	PHONR_DUPLICATED_FILLIN(409,"Phone duplocated fillin"),//電話重複填寫
	
//	ACCOUNT_NOT_FOUND(400,"Account not found"),//帳號不存在
	ACCOUNT_NOT_FOUND(404,"Account not found"),//帳號不存在
	
	PWD_ERRO(400,"Pwd erro"),//密碼錯誤
	
	OLD_PWD_IS_REQUIRED(400,"Old PWD is required!!"),//舊密碼必填
	NEW_PWD_IS_REQUIRED(400,"New PWD is required!!"),//新密碼必填
	
	ADDRESS_IS_REQUIRED(400,"Address is required!!"),//地址必填
//	ADDRESS_DUPLICATED_FILLIN(400,"Address duplocated fillin"),//地址重複填寫
	ADDRESS_DUPLICATED_FILLIN(409,"Address duplocated fillin"),//地址重複填寫
	
//	ADDRESS_NOT_FOUND(400,"Address not found!"),//地址沒有找到
	ADDRESS_NOT_FOUND(404,"Address not found!"),//地址沒有找到
	
	ADDRESS_INFORMATION_ERROR(400,"Address information error"),//地址資料填寫錯誤
	
	FLOOR_IS_REQUIRED(400,"Floor is required!!"),//樓層必填
	
//	PREVIOUS_ROOM_NOT_VACATED(400,"Previous room not vacated"),//前一位房子未退
	PREVIOUS_ROOM_NOT_VACATED(409,"Previous room not vacated"),//前一位房子未退
	
	RID_FILLIN_ERRO(400,"R_id fillin error!!"),//房號錯誤
	RID_IS_REQUIRED(400,"R_id is required!!"),//房號必填
//	RID_DUPLICATED_FILLIN(400,"R_id duplocated fillin"),//房號重複填寫
	RID_DUPLICATED_FILLIN(409,"R_id duplocated fillin"),//房號重複填寫
	
	ROOM_NOT_RENTED(400,"room not rented"),//房間未出租
//	ROOM_NOT_RENTED(404,"Room not rented"),
	
	ROOM_OCCUPIED(400,"room occupied"),//房間出租
//	ROOM_OCCUPIED(409,"Room occupied"), 
	
	
	RENTP_IS_REQUIRED(400,"Rent_p is required!!"),//租金必填
//	RENTP_IS_ERRO(400,"Rent_p is error!!"),//租金填寫錯誤
	RENTP_IS_ERROR(422,"Rent_p is error!!"),//租金填寫錯誤
	
	DEPOSIT_IS_REQUIRED(400,"Deposit is required!!"),//押金必填
//	DEPOSIT_IS_ERRO(400,"Deposit is error!!"),//押金填寫錯誤
	DEPOSIT_IS_ERROR(422,"Deposit is error!!"),//押金填寫錯誤
	
	CUTP_IS_REQUIRED(400,"cut_P is required!!"),//違約金必填
//	CUTP_IS_ERRO(400,"cut_P is error!!"),//違約金填寫錯誤
	CUTP_IS_ERROR(422,"cut_P is error!!"),//違約金填寫錯誤
	
	ELETRICP_IS_REQUIRED(400,"eletric_P is required!!"),//電費一度必填
//	ELETRICP_IS_ERRO(400,"eletric_P is error!!"),//電費一度填寫錯誤
	ELETRICP_IS_ERROR(422,"eletric_P is error!!"),//電費一度填寫錯誤
	
	WATERP_IS_REQUIRED(400,"water_P is required!!"),//水費必填
//	WATERP_IS_ERRO(400,"water_P is error!!"),//水費填寫錯誤
	WATERP_IS_ERROR(422,"water_P is error!!"),//水費填寫錯誤
	
	MANAGEP_IS_REQUIRED(400,"manage_P is required!!"),//管理費必填
//	MANAGEP_IS_ERRO(400,"manage_P is error!!"),//管理費填寫錯誤
	MANAGEP_IS_ERROR(422,"manage_P is error!!"),//管理費填寫錯誤
	
	ACREAGE_IS_REQUIRED(400,"acreage is required!!"),//面積必填
//	ACREAGE_IS_ERRO(400,"acreage is error!!"),//面積填寫錯誤
	ACREAGE_IS_ERROR(422,"acreage is error!!"),//面積填寫錯誤
	
	Parking_IS_REQUIRED(400,"Parking is required!!"),//是否有無停車場，必填
	
	TENANTIDENTITY_IS_REQUIRED(400,"Tenant identity is required!!"),//房客身分證必填
//	TENANTIDENTITY_ERROR(400,"Tenant identity error"),//身分證輸入錯誤
	TENANTIDENTITY_ERROR(422,"Tenant identity error"),//身分證輸入錯誤
	
//	TENANTIDENTITY_DUPLICATED_FILLIN(400,"Tenant identity duplocated fillin!"),//房客身分證重複填寫
	TENANTIDENTITY_DUPLICATED_FILLIN(409,"Tenant identity duplicated fillin!"),//房客身分證重複填寫
	
	TENANTIDENTITY_INFORMATION_ERROR(400,"Tenant identity information error"),//房客資料填寫錯誤
	
	TENANTNAME_IS_REQUIRED(400,"tenantName is required!!"),//房客名子必填
	TENANTPHONE_IS_REQUIRED(400,"tenantPhone is required!!"),//房客電話必填
//	TENANTPHONE_ERROR(400,"Tenant phone error"),//電話格式錯誤
	TENANTPHONE_ERROR(422,"Tenant phone error"),//電話格式錯誤
	
//	TENANTPHONE_DUPLICATED_FILLIN(400,"Tenant phone duplocated fillin!"),//房客電話重複填寫
	TENANTPHONE_DUPLICATED_FILLIN(409,"Tenant phone duplocated fillin!"),//房客電話重複填寫
	
	TENANTEMAIL_IS_REQUIRED(400,"tenantEmail is required!!"),//房客信箱必填
//	TENANTEMAIL_ERROR(400,"Tenant email format error"),//信箱輸入格是錯誤
	TENANTEMAIL_ERROR(422,"Tenant email error"),//信箱輸入格是錯誤
	
	STARTDATE_IS_REQUIRED(400,"startDate is required!!"),//承租日期必填
	STARTDATE_ERROR(400,"startDate error"),//開始時間錯誤
	ENDDATE_IS_REQUIRED(400,"endDate is required!!"),//結束日期必填
	ENDDATE_ERROR(400,"endDate error"),//結束時間錯誤
	CUTDATE_IS_REQUIRED(400,"cutDate is required!!"),//中止日期
//	CUTDATE_REPEAT_FILLIN(400,"cutDate repeat fillin"),//中止日期重複填寫
	CUTDATE_REPEAT_FILLIN(409,"cutDate repeat fillin"),//中止日期重複填寫
	
	CUTDATE_SET_ERROR(400,"cutDate set error"),//中止日期填寫錯誤
	CUTREASON_IS_REQUIRED(400,"cutReason is required!!"),//中止理由
	CUT_P_IS_REQUIRED(400,"cut_p is required"),//違約金必田
	
	ELETRIC_V_IS_REQUIRED(400,"eletric_V is required"),//當期用電量必填
	
//	MULTIPLE_DATA_EXIST(400,"Multiple data exist!!"),//同時多筆資料存在
	MULTIPLE_DATA_EXIST(409,"Multiple data exist!!"),//同時多筆資料存在
	
	PERIODSTART_ERROR(400,"Periodstart error"),//租約的開始日期可能有誤
	TENANTIDENTITY_CHECK_ERROR(400,"Tenantidentity Check Error"),//租約者的身分證可能有誤
	ADDRESS_CKECK_ERROR(400,"Address ckeck error"),//地址可能有誤
	BILLING_INFORMATION_MAY_ALREADY_EXIST(400,"Billing information may already exist"),//帳單資料已存在
	PERIODEND_IS_REQUIRED(400,"Periodend is required"),//帳單最後一期時間必填
//	MAYBE_NOT_THIS_BILLING(400,"Maybe not this billing"),//沒有找到這期帳單
	MAYBE_NOT_THIS_BILLING(404,"Maybe not this billing"),//沒有找到這期帳單
	
	PLEASE_FILLIN_ADDRESS_TENANTIDENTITY_PERIOD(400,"Please fillin address and  Tenant identity and period"),//請填寫地址、身分證、期間日期
	PERIODEND_ERROR(400,"Periodend error"),//期數的結束日期可能有誤
	
	
	TENANTHOMEADDRESS_IS_REQUIRED(400,"Tenanthomeaddress is required"),//租客戶籍地址需要
	TENANTCONTACTADDRESS_IS_REQUIRED(400,"Tenantcontactaddress is required"),//租客通訊地址需要
	OWNERHOMEADDRESS_IS_REQUIRED(400,"Ownerhomeaddress is required"),//房東戶籍地址需要
	OWNERCONTACTADDRESS_IS_REQUIRED(400,"Ownercontactaddress is required"),//房東通訊地址需要
	OWNERIDENTITY_IS_REQUIRED(400,"Owneridentity is required"),//房東身分證需要
	OWNERIDENTITY_IS_ERROR(400,"Owneridentity is error"),//房東身分證錯誤(重複填寫)
	TENANT_ALREADY_RENTING(400,"tenant already renting"),//此房客已有租借房子
//	TENANT_ALREADY_RENTING1(400,"tenant already renting 1"),//此房客已有租界房子
//	TENANT_ALREADY_RENTING2(400,"tenant already renting 2"),//此房客已有租界房子
//	TENANT_ALREADY_RENTING3(400,"tenant already renting 3"),//此房客已有租界房子
	
	PARAMETER_CHECK_ERROR(400,"Parameter check error"),//參數檢查錯誤
	END_DATE_BEFORE_START_DATE(400,"end date before start date"),//結束時間在開始時間之前
	
//	TENANT_MAYBR_NOT_EXIST(400,"tenant maybe not extist"),//房客可能不存在
	TENANT_MAYBR_NOT_EXIST(404,"tenant maybe not extist"),//房客可能不存在
	
	TENANT_INFORMATION_MAYBR_ERROR(400,"tenant information maybe error"), //房客資訊可能有誤
//	ROOM_MAYBE_NOT_THIS_ADDRESS(400,"room maybe not this address!!"),//這地址可能在房間中不存在
	ROOM_MAYBE_NOT_THIS_ADDRESS(404,"room maybe not this address!!"),//這地址可能在房間中不存在
	
	INVALID_VERIFICATION_CODE(400,"invalid verification code"),//驗證碼錯誤(無效驗證碼)
	EMAIL_NOT_VERIFIED(401,"email not verified"),//信箱位驗證，無法登入 
	INVALID_INPUT(400,"invalid input"),//無效資訊
	
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
