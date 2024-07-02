package com.example.rent.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterReq {

	@NotBlank(message = "Accoint is required!!")
	@JsonProperty("owner_account")
	private String ownerAccount;

	@NotBlank(message = "PWD is required!!")
	@JsonProperty("owner_pwd")
	private String ownerPwd;

	@NotBlank(message = "Name is required!!")
	@JsonProperty("owner_name")
	private String ownerName;

	@Pattern(regexp = "^[A-Z][1-2][0-9]{8}$", message = "Owneridentity error")
	@JsonProperty("owner_identity")
	private String ownerIdentity;

	@NotBlank(message = "Phone is required!!")
	@JsonProperty("owner_phone")
	@Pattern(regexp = "[0-9]{10}", message = "Phone error!!")
	private String ownerPhone;

	@NotBlank(message = "Email is required!!")
	@JsonProperty("owner_email")
	@Pattern(regexp = ".*@.*", message = "Email error!!")
	private String ownerEmail;

	public RegisterReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegisterReq(@NotBlank(message = "Accoint is required!!") String ownerAccount,
			@NotBlank(message = "PWD is required!!") String ownerPwd,
			@NotBlank(message = "Name is required!!") String ownerName,
			@Pattern(regexp = "^[A-Z][1-2][0-9]{8}$", message = "Owneridentity error") String ownerIdentity,
			@NotBlank(message = "Phone is required!!") @Pattern(regexp = "[0-9]{10}", message = "Phone error!!") String ownerPhone,
			@NotBlank(message = "Email is required!!") @Pattern(regexp = ".*@.*", message = "Email error!!") String ownerEmail) {
		super();
		this.ownerAccount = ownerAccount;
		this.ownerPwd = ownerPwd;
		this.ownerName = ownerName;
		this.ownerIdentity = ownerIdentity;
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

}
