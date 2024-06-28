package com.example.rent.vo;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdatePwdReq {

	@NotBlank(message = "Accoint is required!!")
	@JsonProperty("owner_account")
	private String ownerAccount;

	@NotBlank(message = "Old PWD is required!!")
	private String ownerOldPwd;

	@NotBlank(message = "New PWD is required!!")
	private String ownerNewPwd;

	public UpdatePwdReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdatePwdReq(@NotBlank(message = "Accoint is required!!") String ownerAccount,
			@NotBlank(message = "PWD is required!!") String ownerOldPwd,
			@NotBlank(message = "PWD is required!!") String ownerNewPwd) {
		super();
		this.ownerAccount = ownerAccount;
		this.ownerOldPwd = ownerOldPwd;
		this.ownerNewPwd = ownerNewPwd;
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

	public String getOwnerNewPwd() {
		return ownerNewPwd;
	}

	public void setOwnerNewPwd(String ownerNewPwd) {
		this.ownerNewPwd = ownerNewPwd;
	}

}
