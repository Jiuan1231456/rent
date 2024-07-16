package com.example.rent.vo;

public class VerifyEmailReq {

	private String ownerAccount;

	private String verificationCode;

	public VerifyEmailReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VerifyEmailReq(String ownerAccount, String verificationCode) {
		super();
		this.ownerAccount = ownerAccount;
		this.verificationCode = verificationCode;
	}

	public String getOwnerAccount() {
		return ownerAccount;
	}

	public void setOwnerAccount(String ownerAccount) {
		this.ownerAccount = ownerAccount;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

}
