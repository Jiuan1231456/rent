package com.example.rent.vo;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdateCutDateReq {

	@NotBlank(message = "Address is required!!")
	private String address;// 地址

//	private String floor;// 樓層

	@NotBlank(message = "Tenant identity is required!!")
	private String tenantIdentity;// 租客身分證

//	private String tenantName;// 租客名子

	@NotNull(message = "startDate is required!!")
	private LocalDate periodStart;// 計算開始時間

	@NotNull(message = "Periodend is required")
	private LocalDate periodEnd;// 計算結束時間

	public UpdateCutDateReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdateCutDateReq(@NotBlank(message = "Address is required!!") String address,
			@NotBlank(message = "Tenant identity is required!!") String tenantIdentity,
			@NotNull(message = "startDate is required!!") LocalDate periodStart,
			@NotNull(message = "Periodend is required") LocalDate periodEnd) {
		super();
		this.address = address;
		this.tenantIdentity = tenantIdentity;
		this.periodStart = periodStart;
		this.periodEnd = periodEnd;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTenantIdentity() {
		return tenantIdentity;
	}

	public void setTenantIdentity(String tenantIdentity) {
		this.tenantIdentity = tenantIdentity;
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

}
