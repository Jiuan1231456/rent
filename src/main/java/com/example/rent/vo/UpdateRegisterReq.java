package com.example.rent.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateRegisterReq {

	@NotBlank(message = "Account is required!!")
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

	@Pattern(regexp = "\\(([0-9]{3})\\)[0-9]{10}$", message = "account Bank error")
	@JsonProperty("account_bank")
	private String accountBank;

	public UpdateRegisterReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdateRegisterReq(@NotBlank(message = "Account is required!!") String ownerAccount, String ownerName,
			@Pattern(regexp = "[0-9]{10}", message = "Phone error!!") String ownerPhone,
			@Pattern(regexp = ".*@.*", message = "Email error!!") String ownerEmail,
			@Pattern(regexp = "\\(([0-9]{3})\\)[0-9]{10}$", message = "account Bank error") String accountBank) {
		super();
		this.ownerAccount = ownerAccount;
		this.ownerName = ownerName;
		this.ownerPhone = ownerPhone;
		this.ownerEmail = ownerEmail;
		this.accountBank = accountBank;
	}

	public String getOwnerAccount() {
		return ownerAccount;
	}

	public void setOwnerAccount(String ownerAccount) {
		this.ownerAccount = ownerAccount != null ? ownerAccount.trim() : null;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName!= null ? ownerName.trim() : null;
	}

	public String getOwnerPhone() {
		return ownerPhone;
	}

	public void setOwnerPhone(String ownerPhone) {
		this.ownerPhone = ownerPhone!= null ? ownerPhone.trim() : null;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail!= null ? ownerEmail.trim() : null;
	}

	public String getAccountBank() {
		return accountBank;
	}

	public void setAccountBank(String accountBank) {
		this.accountBank = accountBank!= null ? accountBank.trim() : null;
	}

}
