package com.example.rent.vo;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginReq {

	@NotBlank(message = "Accoint is required!!")
	@JsonProperty("owner_account")
	private String ownerAccount;

	@NotBlank(message = "PWD is required!!")
	@JsonProperty("owner_pwd")
	private String ownerPwd;

	public LoginReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginReq(@NotBlank(message = "Accoint is required!!") String ownerAccount,
			@NotBlank(message = "PWD is required!!") String ownerPwd) {
		super();
		this.ownerAccount = ownerAccount;
		this.ownerPwd = ownerPwd;
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

}
