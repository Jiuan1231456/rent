package com.example.rent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "register")這邊是要連接SQL中的register的表
@Table(name = "register")
public class Register {

	@Id
	@Column(name = "owner_account")
	private String ownerAccount;

	@Column(name = "owner_pwd")
	private String ownerPwd;

	@Column(name = "owner_name")
	private String ownerName;

	@Column(name = "owner_identity")
	private String ownerIdentity;

	@Column(name = "owner_phone")
	private String ownerPhone;

	@Column(name = "owner_email")
	private String ownerEmail;

	@Column(name = "account_bank")
	private String accountBank;
	
	@Column(name = "email_verification_code")
    private String emailVerificationCode; //驗證碼

    @Column(name = "is_email_verified")
    private Boolean isEmailVerified = false;//檢查是否以驗證成功

	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Register(String ownerAccount, String ownerPwd, String ownerName, String ownerIdentity, String ownerPhone,
			String ownerEmail, String accountBank, String emailVerificationCode, Boolean isEmailVerified) {
		super();
		this.ownerAccount = ownerAccount;
		this.ownerPwd = ownerPwd;
		this.ownerName = ownerName;
		this.ownerIdentity = ownerIdentity;
		this.ownerPhone = ownerPhone;
		this.ownerEmail = ownerEmail;
		this.accountBank = accountBank;
		this.emailVerificationCode = emailVerificationCode;
		this.isEmailVerified = isEmailVerified;
	}

	public String getOwnerAccount() {
		return ownerAccount;
	}

	public void setOwnerAccount(String ownerAccount) {
		this.ownerAccount = ownerAccount;
	}

	public String getOwnerPwd() {
		return ownerPwd;
	}

	public void setOwnerPwd(String ownerPwd) {
		this.ownerPwd = ownerPwd;
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

	public String getEmailVerificationCode() {
		return emailVerificationCode;
	}

	public void setEmailVerificationCode(String emailVerificationCode) {
		this.emailVerificationCode = emailVerificationCode;
	}

	public Boolean getIsEmailVerified() {
		return isEmailVerified;
	}

	public void setIsEmailVerified(Boolean isEmailVerified) {
		this.isEmailVerified = isEmailVerified;
	}

	
}
