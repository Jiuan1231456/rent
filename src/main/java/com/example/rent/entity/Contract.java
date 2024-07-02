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

	@Column(name = "tenant_home_address")
	private String tenantHomeAddress;

	@Column(name = "tenant_contact_address")
	private String tenantContactAddress;

	@Column(name = "tenant_phone")
	private String tenantPhone;

	@Column(name = "tenant_email")
	private String tenantEmail;

	@Column(name = "owner_name")
	private String ownerName;

	@Column(name = "owner_identity")
	private String ownerIdentity;

	@Column(name = "owner_home_address")
	private String ownerHomeAddress;

	@Column(name = "owner_contact_address")
	private String ownerContactAddress;

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

	@Column(name = "c_other")
	private String cOther;

	public Contract() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contract(int ai, String tenantIdentity, String tenantName, String tenantHomeAddress,
			String tenantContactAddress, String tenantPhone, String tenantEmail, String ownerName, String ownerIdentity,
			String ownerHomeAddress, String ownerContactAddress, String roomId, String address, String floor,
			LocalDate startDate, LocalDate endDate, int rentP, LocalDate cutDate, String cutReason, int cutP,
			String cOther) {
		super();
		this.ai = ai;
		this.tenantIdentity = tenantIdentity;
		this.tenantName = tenantName;
		this.tenantHomeAddress = tenantHomeAddress;
		this.tenantContactAddress = tenantContactAddress;
		this.tenantPhone = tenantPhone;
		this.tenantEmail = tenantEmail;
		this.ownerName = ownerName;
		this.ownerIdentity = ownerIdentity;
		this.ownerHomeAddress = ownerHomeAddress;
		this.ownerContactAddress = ownerContactAddress;
		this.roomId = roomId;
		this.address = address;
		this.floor = floor;
		this.startDate = startDate;
		this.endDate = endDate;
		this.rentP = rentP;
		this.cutDate = cutDate;
		this.cutReason = cutReason;
		this.cutP = cutP;
		this.cOther = cOther;
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

	public String getTenantHomeAddress() {
		return tenantHomeAddress;
	}

	public void setTenantHomeAddress(String tenantHomeAddress) {
		this.tenantHomeAddress = tenantHomeAddress;
	}

	public String getTenantContactAddress() {
		return tenantContactAddress;
	}

	public void setTenantContactAddress(String tenantContactAddress) {
		this.tenantContactAddress = tenantContactAddress;
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

	public String getOwnerIdentity() {
		return ownerIdentity;
	}

	public void setOwnerIdentity(String ownerIdentity) {
		this.ownerIdentity = ownerIdentity;
	}

	public String getOwnerHomeAddress() {
		return ownerHomeAddress;
	}

	public void setOwnerHomeAddress(String ownerHomeAddress) {
		this.ownerHomeAddress = ownerHomeAddress;
	}

	public String getOwnerContactAddress() {
		return ownerContactAddress;
	}

	public void setOwnerContactAddress(String ownerContactAddress) {
		this.ownerContactAddress = ownerContactAddress;
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

	public String getcOther() {
		return cOther;
	}

	public void setcOther(String cOther) {
		this.cOther = cOther;
	}

}
