package com.example.rent.vo;

import java.time.LocalDate;

public class BillSearchReq {

	private String address;

	private String roomId;

	private String tenantName;

	private LocalDate periodStart;

	private LocalDate periodEnd;

	private LocalDate StartDate;

	private LocalDate endDate;

	public BillSearchReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BillSearchReq(String address, String roomId, String tenantName, LocalDate periodStart, LocalDate periodEnd,
			LocalDate startDate, LocalDate endDate) {
		super();
		this.address = address;
		this.roomId = roomId;
		this.tenantName = tenantName;
		this.periodStart = periodStart;
		this.periodEnd = periodEnd;
		StartDate = startDate;
		this.endDate = endDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public LocalDate getPeriodStart() {
		return periodStart;
	}

	public void setPeriodStart(LocalDate periodStart) {
		this.periodStart = periodStart;
	}

	public LocalDate getPeriodEnd() {
		return periodEnd;
	}

	public void setPeriodEnd(LocalDate periodEnd) {
		this.periodEnd = periodEnd;
	}

	public LocalDate getStartDate() {
		return StartDate;
	}

	public void setStartDate(LocalDate startDate) {
		StartDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

}
