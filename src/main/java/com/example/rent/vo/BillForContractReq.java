package com.example.rent.vo;

import java.time.LocalDate;

public class BillForContractReq {

	private LocalDate startdate;

	private String ownerName;

	public BillForContractReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BillForContractReq(LocalDate startdate, String ownerName) {
		super();
		this.startdate = startdate;
		this.ownerName = ownerName;
	}

	public LocalDate getStartdate() {
		return startdate;
	}

	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

}
