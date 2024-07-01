package com.example.rent.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

public class updateRegisterReq {

	@NotBlank(message = "Accoint is required!!")
	@JsonProperty("owner_account")
	private String ownerAccount;

	@JsonProperty("owner_name")
	private String ownerName;

	@JsonProperty("owner_phone")
	@Pattern(regexp = "[0-9]{10}", message = "Phone error!!")
	private String ownerPhone;

	@JsonProperty("owner_email")
	@Pattern(regexp = ".*@.*", message = "Email error!!")
	private String ownerEmail;

	public updateRegisterReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public updateRegisterReq(@NotBlank(message = "Accoint is required!!") String ownerAccount, String ownerName,
			@Pattern(regexp = "[0-9]{10}", message = "Phone error!!") String ownerPhone,
			@Pattern(regexp = ".*@.*", message = "Email error!!") String ownerEmail) {
		super();
		this.ownerAccount = ownerAccount;
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
