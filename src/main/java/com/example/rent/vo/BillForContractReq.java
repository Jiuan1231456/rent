package com.example.rent.vo;

import java.time.LocalDate;

public class BillForContractReq {

	private LocalDate startdate;

	private String account;

	public BillForContractReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BillForContractReq(LocalDate startdate, String account) {
		super();
		this.startdate = startdate;
		this.account = account;
	}

	public BillForContractReq(LocalDate startdate) {
		super();
		this.startdate = startdate;
	}

	public LocalDate getStartdate() {
		return startdate;
	}

	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

}
