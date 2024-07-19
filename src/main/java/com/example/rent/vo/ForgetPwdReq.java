package com.example.rent.vo;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ForgetPwdReq {

	@NotBlank(message = "Account is required!!")
	@JsonProperty("owner_account")
	private String ownerAccount;

	public ForgetPwdReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ForgetPwdReq(@NotBlank(message = "Account is required!!") String ownerAccount) {
		super();
		this.ownerAccount = ownerAccount;
	}

	public String getOwnerAccount() {
		return ownerAccount;
	}

	public void setOwnerAccount(String ownerAccount) {
		this.ownerAccount = ownerAccount;
	}

}
