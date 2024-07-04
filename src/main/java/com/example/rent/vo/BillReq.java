package com.example.rent.vo;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BillReq {

//	@NotBlank(message = "R_id is required!!")
	private String roomId;// 房號

//	@NotBlank(message = "Address is required!!")
	private String address;// 地址

	private String floor;// 樓層

//	@NotBlank(message = "Tenant identity is required!!")
	private String tenantIdentity;// 租客身分證

	private String tenantName;// 租客名子

	@NotNull(message = "startDate is required!!")
	private LocalDate periodStart;// 計算開始時間

	private LocalDate periodEnd;// 計算結束時間

	private String ownerName;// 房東名子

	private Integer rentP;// 租金

	private Integer eletricP;// 一度電費用

//	@NotNull(message = "eletric_V is required")
	private int eletricV;// 當期用電量(當期減上期)

	private Integer eletricOneP;// 電費費用為(間)

	private Integer waterOneP;// 水費為

	private Integer manageOneP;// 管理費為

	private Integer cutP;// 違約金

	private int totalOneP;// 總電費

	private LocalDate paymentDate;// 繳費日期

	public BillReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BillReq(String roomId, @NotBlank(message = "Address is required!!") String address, String floor,
			@NotBlank(message = "Tenant identity is required!!") String tenantIdentity, String tenantName,
			@NotNull(message = "startDate is required!!") LocalDate periodStart, LocalDate periodEnd, String ownerName,
			Integer rentP, Integer eletricP, Integer eletricV, Integer eletricOneP, Integer waterOneP,
			Integer manageOneP, Integer cutP, int totalOneP, LocalDate paymentDate) {
		super();
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

	public Integer getRentP() {
		return rentP;
	}

	public void setRentP(Integer rentP) {
		this.rentP = rentP;
	}

	public Integer getEletricP() {
		return eletricP;
	}

	public void setEletricP(Integer eletricP) {
		this.eletricP = eletricP;
	}

	public Integer getEletricV() {
		return eletricV;
	}

	public void setEletricV(Integer eletricV) {
		this.eletricV = eletricV;
	}

	public Integer getEletricOneP() {
		return eletricOneP;
	}

	public void setEletricOneP(Integer eletricOneP) {
		this.eletricOneP = eletricOneP;
	}

	public Integer getWaterOneP() {
		return waterOneP;
	}

	public void setWaterOneP(Integer waterOneP) {
		this.waterOneP = waterOneP;
	}

	public Integer getManageOneP() {
		return manageOneP;
	}

	public void setManageOneP(Integer manageOneP) {
		this.manageOneP = manageOneP;
	}

	public Integer getCutP() {
		return cutP;
	}

	public void setCutP(Integer cutP) {
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
