package com.example.rent.vo;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterReq {

	@NotBlank(message = "Accoint is required!!")
	@JsonProperty("owner_account")
	private String ownerAccount;

	@NotBlank(message = "PWD is required!!")
	@JsonProperty("owner_pwd")
	private String ownerPwd;

	
	@JsonProperty("owner_name")
	private String ownerName;

	
	@JsonProperty("owner_phone")
	private String ownerPhone;

	
	@JsonProperty("owner_email")
	private String ownerEmail;

	public RegisterReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegisterReq(@NotBlank(message = "Accoint is required!!") String ownerAccount,
			@NotBlank(message = "Accoint is required!!") String ownerPwd) {
		super();
		this.ownerAccount = ownerAccount;
		this.ownerPwd = ownerPwd;
	}

	public RegisterReq(String ownerAccount, String ownerPwd, String ownerName, String ownerPhone, String ownerEmail) {
		super();
		this.ownerAccount = ownerAccount;
		this.ownerPwd = ownerPwd;
		this.ownerName = ownerName;
		this.ownerPhone = ownerPhone;
		this.ownerEmail = ownerEmail;
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

}
