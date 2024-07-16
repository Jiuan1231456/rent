package com.example.rent.vo;

public class RegisterRes extends BasicRes {

	private String ownerAccount;

	private String ownerOldPwd;

	private String ownerName;

	private String ownerIdentity;

	private String ownerPhone;

	private String ownerEmail;

	private String accountBank;

	public RegisterRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegisterRes(int code, String message) {
		super(code, message);
		// TODO Auto-generated constructor stub
	}

	public RegisterRes(int code, String message,String ownerAccount, String ownerOldPwd, String ownerName, String ownerIdentity,
			String ownerPhone, String ownerEmail, String accountBank) {
		super(code, message);
		this.ownerAccount = ownerAccount;
		this.ownerOldPwd = ownerOldPwd;
		this.ownerName = ownerName;
		this.ownerIdentity = ownerIdentity;
		this.ownerPhone = ownerPhone;
		this.ownerEmail = ownerEmail;
		this.accountBank = accountBank;
	}

	public String getOwnerAccount() {
		return ownerAccount;
	}

	public void setOwnerAccount(String ownerAccount) {
		this.ownerAccount = ownerAccount;
	}

	public String getOwnerOldPwd() {
		return ownerOldPwd;
	}

	public void setOwnerOldPwd(String ownerOldPwd) {
		this.ownerOldPwd = ownerOldPwd;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerIdentity() {
		return ownerIdentity;
	}

	public void setOwnerIdentity(String ownerIdentity) {
		this.ownerIdentity = ownerIdentity;
	}

	public String getOwnerPhone() {
		return ownerPhone;
	}

	public void setOwnerPhone(String ownerPhone) {
		this.ownerPhone = ownerPhone;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public String getAccountBank() {
		return accountBank;
	}

	public void setAccountBank(String accountBank) {
		this.accountBank = accountBank;
	}

}
