package com.example.rent.vo;

public class AllInformationReq {

//	@NotBlank(message = "Accoint is required!!")
	private String ownerAccount;

	public AllInformationReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AllInformationReq(String ownerAccount) {
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
