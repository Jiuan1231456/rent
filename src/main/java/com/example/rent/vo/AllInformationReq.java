package com.example.rent.vo;

import javax.validation.constraints.NotBlank;

public class AllInformationReq {

	@NotBlank(message = "Accoint is required!!")
	private String ownerAccount;

	public AllInformationReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AllInformationReq(@NotBlank(message = "Accoint is required!!") String ownerAccount) {
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
