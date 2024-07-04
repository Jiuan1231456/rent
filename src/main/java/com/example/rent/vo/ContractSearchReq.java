package com.example.rent.vo;

import java.time.LocalDate;

public class ContractSearchReq {

	private String address;

	private String tenantName;

	private LocalDate startDate;

	private LocalDate endDate;

	public ContractSearchReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContractSearchReq(String address, String tenantName, LocalDate startDate, LocalDate endDate) {
		super();
		this.address = address;
		this.tenantName = tenantName;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

}
