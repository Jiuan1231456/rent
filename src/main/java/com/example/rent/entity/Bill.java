package com.example.rent.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bill")
public class Bill {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "ai")
	private int ai;

	@Column(name = "r_id")
	private String roomId;// 房號

	@Column(name = "address")
	private String address;// 地址

	@Column(name = "floor")
	private String floor;// 樓層

	@Column(name = "tenant_identity")
	private String tenantIdentity;// 租客身分證

	@Column(name = "tenant_name")
	private String tenantName;// 租客名子

	@Column(name = "period_start")
	private LocalDate periodStart;// 計算開始時間

	@Column(name = "period_end")
	private LocalDate periodEnd;// 計算結束時間

	@Column(name = "owner_name")
	private String ownerName;// 房東名子

	@Column(name = "rent_p")
	private int rentP;// 租金

	@Column(name = "eletric_v")
	private int eletricV;// 當期用電量

	@Column(name = "eletric_one_p")
	private int eletricOneP;// 電費費用為(間)

	@Column(name = "water_one_p")
	private int waterOneP;// 水費為

	@Column(name = "manage_one_p")
	private int manageOneP;// 管理費為

	@Column(name = "cut_p")
	private int cutP;// 違約金

	@Column(name = "total_one_p")
	private int totalOneP;// 總電費

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bill(int ai, String roomId, String address, String floor, String tenantIdentity, String tenantName,
			LocalDate periodStart, LocalDate periodEnd, String ownerName, int rentP, int eletricV, int eletricOneP,
			int waterOneP, int manageOneP, int cutP, int totalOneP) {
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
		this.eletricV = eletricV;
		this.eletricOneP = eletricOneP;
		this.waterOneP = waterOneP;
		this.manageOneP = manageOneP;
		this.cutP = cutP;
		this.totalOneP = totalOneP;
	}

	public int getAi() {
		return ai;
	}

	public void setAi(int ai) {
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


}
