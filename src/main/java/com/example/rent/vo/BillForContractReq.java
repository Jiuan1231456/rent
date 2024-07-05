package com.example.rent.vo;

import java.time.LocalDate;

public class BillForContractReq {

	private LocalDate startdate;

	private String ownerAccount;

	public BillForContractReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BillForContractReq(LocalDate startdate, String ownerAccount) {
		super();
		this.startdate = startdate;
		this.ownerAccount = ownerAccount;
	}

	public LocalDate getStartdate() {
		return startdate;
	}

	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}

	public String getOwnerAccount() {
		return ownerAccount;
	}

	public void setOwnerAccount(String ownerAccount) {
		this.ownerAccount = ownerAccount;
	}

}
