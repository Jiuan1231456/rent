package com.example.rent.vo;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

public class UpdateBillReq {

//	@NotNull(message = "ai is required")
	private Integer ai;

//	@NotBlank(message = "R_id is required!!")
	private String roomId;// 房號

//	@NotBlank(message = "Address is required!!")
	private String address;// 地址

	private String floor;// 樓層

//	@NotBlank(message = "Tenant identity is required!!")
	private String tenantIdentity;// 租客身分證

	private String tenantName;// 租客名子

//	@NotNull(message = "startDate is required!!")
	private LocalDate periodStart;// 計算開始時間

//	@NotNull(message = "Periodend is required")
	private LocalDate periodEnd;// 計算結束時間

	private String ownerName;// 房東名子

	private int rentP;// 租金

	private int eletricP;// 一度電費用

	@NotNull(message = "eletric_V is required")
	private Integer eletricV;// 當期用電量(當期減上期)

	private int eletricOneP;// 電費費用為(間)

	private int waterOneP;// 水費為

	private int manageOneP;// 管理費為

	private int cutP;// 違約金

	private int totalOneP;// 總電費

	private LocalDate paymentDate;// 繳費日期

	public UpdateBillReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdateBillReq(Integer ai, String roomId, String address, String floor, String tenantIdentity,
			String tenantName, LocalDate periodStart, LocalDate periodEnd, String ownerName, int rentP, int eletricP,
			@NotNull(message = "eletric_V is required") Integer eletricV, int eletricOneP, int waterOneP,
			int manageOneP, int cutP, int totalOneP, LocalDate paymentDate) {
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

	public Integer getEletricV() {
		return eletricV;
	}

	public void setEletricV(Integer eletricV) {
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
