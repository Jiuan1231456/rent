package com.example.rent.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contract")
public class Contract {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "ai")
	private int ai;

	@Column(name = "tenant_identity")
	private String tenantIdentity;

	@Column(name = "tenant_name")
	private String tenantName;

	@Column(name = "tenant_phone")
	private String tenantPhone;

	@Column(name = "tenant_email")
	private String tenantEmail;

	@Column(name = "owner_name")
	private String ownerName;

	@Column(name = "r_id")
	private String roomId;

	@Column(name = "address")
	private String address;

	@Column(name = "floor")
	private String floor;

	@Column(name = "start_date")
	private LocalDate startDate;

	@Column(name = "end_date")
	private LocalDate endDate;

	@Column(name = "rent_p")
	private int rentP;

	@Column(name = "cut_date")
	private LocalDate cutDate;

	@Column(name = "cut_reason")
	private String cutReason;

	@Column(name = "cut_p")
	private int cutP;

	public Contract() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contract(int ai, String tenantIdentity, String tenantName, String tenantPhone, String tenantEmail,
			String ownerName, String roomId, String address, String floor, LocalDate startDate, LocalDate endDate,
			int rentP, LocalDate cutDate, String cutReason, int cutP) {
		super();
		this.ai = ai;
		this.tenantIdentity = tenantIdentity;
		this.tenantName = tenantName;
		this.tenantPhone = tenantPhone;
		this.tenantEmail = tenantEmail;
		this.ownerName = ownerName;
		this.roomId = roomId;
		this.address = address;
		this.floor = floor;
		this.startDate = startDate;
		this.endDate = endDate;
		this.rentP = rentP;
		this.cutDate = cutDate;
		this.cutReason = cutReason;
		this.cutP = cutP;
	}

	public int getAi() {
		return ai;
	}

	public void setAi(int ai) {
		this.ai = ai;
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

	public String getTenantPhone() {
		return tenantPhone;
	}

	public void setTenantPhone(String tenantPhone) {
		this.tenantPhone = tenantPhone;
	}

	public String getTenantEmail() {
		return tenantEmail;
	}

	public void setTenantEmail(String tenantEmail) {
		this.tenantEmail = tenantEmail;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
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

	public int getRentP() {
		return rentP;
	}

	public void setRentP(int rentP) {
		this.rentP = rentP;
	}

	public LocalDate getCutDate() {
		return cutDate;
	}

	public void setCutDate(LocalDate cutDate) {
		this.cutDate = cutDate;
	}

	public String getCutReason() {
		return cutReason;
	}

	public void setCutReason(String cutReason) {
		this.cutReason = cutReason;
	}

	public int getCutP() {
		return cutP;
	}

	public void setCutP(int cutP) {
		this.cutP = cutP;
	}

}
