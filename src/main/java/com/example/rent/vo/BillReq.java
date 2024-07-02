package com.example.rent.vo;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BillReq {

	@NotNull(message = "ai is required")
	private Integer ai;

//	@NotBlank(message = "R_id is required!!")
	private String roomId;// 房號

	@NotBlank(message = "Address is required!!")
	private String address;// 地址

	private String floor;// 樓層

	@NotBlank(message = "Tenant identity is required!!")
	private String tenantIdentity;// 租客身分證

	private String tenantName;// 租客名子

	@NotNull(message = "startDate is required!!")
	private LocalDate periodStart;// 計算開始時間

	private LocalDate periodEnd;// 計算結束時間

	private String ownerName;// 房東名子

	private int rentP;// 租金

	private int eletricP;// 一度電費用

//	@NotNull(message = "eletric_V is required")
	private int eletricV;// 當期用電量(當期減上期)

	private int eletricOneP;// 電費費用為(間)

	private int waterOneP;// 水費為

	private int manageOneP;// 管理費為

	private int cutP;// 違約金

	private int totalOneP;// 總電費

	private LocalDate paymentDate;// 繳費日期

	public BillReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BillReq(@NotNull(message = "ai is required") Integer ai, String roomId,
			@NotBlank(message = "Address is required!!") String address, String floor,
			@NotBlank(message = "Tenant identity is required!!") String tenantIdentity, String tenantName,
			@NotNull(message = "startDate is required!!") LocalDate periodStart, LocalDate periodEnd, String ownerName,
			int rentP, int eletricP, int eletricV, int eletricOneP, int waterOneP, int manageOneP, int cutP,
			int totalOneP, LocalDate paymentDate) {
		super();
		this.ai = ai;
		this.roomId = roomId;
		this.address = address;
		this.floor = floor;
		this.tenantIdentity = tenantIdentity;
		this.tenantName = tenantName;
		this.periodStart = periodStart;
		this.periodEnd = periodEnd;
		this.ownerName = ownerName;
		this.rentP = rentP;
		this.eletricP = eletricP;
		this.eletricV = eletricV;
		this.eletricOneP = eletricOneP;
		this.waterOneP = waterOneP;
		this.manageOneP = manageOneP;
		this.cutP = cutP;
		this.totalOneP = totalOneP;
		this.paymentDate = paymentDate;
	}

	public Integer getAi() {
		return ai;
	}

	public void setAi(Integer ai) {
		this.ai = ai;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getTenantIdentity() {
		return tenantIdentity;
	}

	public void setTenantIdentity(String tenantIdentity) {
		this.tenantIdentity = tenantIdentity;
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

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getRentP() {
		return rentP;
	}

	public void setRentP(int rentP) {
		this.rentP = rentP;
	}

	public int getEletricP() {
		return eletricP;
	}

	public void setEletricP(int eletricP) {
		this.eletricP = eletricP;
	}

	public int getEletricV() {
		return eletricV;
	}

	public void setEletricV(int eletricV) {
		this.eletricV = eletricV;
	}

	public int getEletricOneP() {
		return eletricOneP;
	}

	public void setEletricOneP(int eletricOneP) {
		this.eletricOneP = eletricOneP;
	}

	public int getWaterOneP() {
		return waterOneP;
	}

	public void setWaterOneP(int waterOneP) {
		this.waterOneP = waterOneP;
	}

	public int getManageOneP() {
		return manageOneP;
	}

	public void setManageOneP(int manageOneP) {
		this.manageOneP = manageOneP;
	}

	public int getCutP() {
		return cutP;
	}

	public void setCutP(int cutP) {
		this.cutP = cutP;
	}

	public int getTotalOneP() {
		return totalOneP;
	}

	public void setTotalOneP(int totalOneP) {
		this.totalOneP = totalOneP;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

}
