package com.example.rent.vo;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CreateContractReq {

	@NotBlank(message = "Tenant identity is required!!")
	@Pattern(regexp = "^[A-Z][1-2][0-9]{8}$", message = "Tenant identity error")
	private String tenantIdentity;

	@NotBlank(message = "tenantName is required!!")
	private String tenantName;

	@NotBlank(message = "Tenanthomeaddress is required")
	private String tenantHomeAddress;

	@NotBlank(message = "Tenantcontactaddress is required")
	private String tenantContactAddress;

	@NotBlank(message = "tenantPhone is required!!")
	@Pattern(regexp = "[0-9]{10}", message = "Tenant phone error")
	private String tenantPhone;

	@NotBlank(message = "tenantEmail is required!!")
	@Pattern(regexp = ".*@.*", message = "Tenant email error")
	private String tenantEmail;

	@NotBlank(message = "Name is required!!")
	private String ownerName;

	@Pattern(regexp = "^[A-Z][1-2][0-9]{8}$", message = "Owneridentity  error")
	@NotBlank(message = "Owneridentity is required")
	private String ownerIdentity;

	@NotBlank(message = "Ownerhomeaddress is required")
	private String ownerHomeAddress;

	@NotBlank(message = "Ownercontactaddress is required")
	private String ownerContactAddress;

	@NotBlank(message = "R_id is required!!")
	private String roomId;

	@NotBlank(message = "Address is required!!")
	private String address;

	@NotBlank(message = "Floor is required!!")
	private String floor;

	@NotNull(message = "startDate is required!!")
	// FutureOrPresent:未來時間(大於等於現在時間) ，所以當小於等於現在時間的話就會返回錯誤
	@FutureOrPresent(message = "Param start Date error!!")
	private LocalDate startDate;

	@NotNull(message = "endDate is required!!")
	@FutureOrPresent(message = "Param end Date error!!")
	private LocalDate endDate;

	@NotNull(message = "Rent_p is required!!")
	private Integer rentP;

	private Integer cutP;// 違約金

	private LocalDate cutDate;// 中止日期

	private String cutReason;// 中止理由

	private String cOther;// 其他

	public CreateContractReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreateContractReq(
			@NotBlank(message = "Tenant identity is required!!") @Pattern(regexp = "^[A-Z][1-2][0-9]{8}$", message = "Tenant identity error") String tenantIdentity,
			@NotBlank(message = "tenantName is required!!") String tenantName,
			@NotBlank(message = "Tenanthomeaddress is required") String tenantHomeAddress,
			@NotBlank(message = "Tenantcontactaddress is required") String tenantContactAddress,
			@NotBlank(message = "tenantPhone is required!!") @Pattern(regexp = "[0-9]{10}", message = "Tenant phone error") String tenantPhone,
			@NotBlank(message = "tenantEmail is required!!") @Pattern(regexp = ".*@.*", message = "Tenant email error") String tenantEmail,
			@NotBlank(message = "Name is required!!") String ownerName,
			@Pattern(regexp = "^[A-Z][1-2][0-9]{8}$", message = "Owneridentity  error") @NotBlank(message = "Owneridentity is required") String ownerIdentity,
			@NotBlank(message = "Ownerhomeaddress is required") String ownerHomeAddress,
			@NotBlank(message = "Ownercontactaddress is required") String ownerContactAddress,
			@NotBlank(message = "R_id is required!!") String roomId,
			@NotBlank(message = "Address is required!!") String address,
			@NotBlank(message = "Floor is required!!") String floor,
			@NotNull(message = "startDate is required!!") @FutureOrPresent(message = "Param start Date error!!") LocalDate startDate,
			@NotNull(message = "endDate is required!!") @FutureOrPresent(message = "Param end Date error!!") LocalDate endDate,
			@NotNull(message = "Rent_p is required!!") Integer rentP, Integer cutP, LocalDate cutDate, String cutReason,
			String cOther) {
		super();
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
		this.cutP = cutP;
		this.cutDate = cutDate;
		this.cutReason = cutReason;
		this.cOther = cOther;
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

	public Integer getRentP() {
		return rentP;
	}

	public void setRentP(Integer rentP) {
		this.rentP = rentP;
	}

	public Integer getCutP() {
		return cutP;
	}

	public void setCutP(Integer cutP) {
		this.cutP = cutP;
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

	public String getcOther() {
		return cOther;
	}

	public void setcOther(String cOther) {
		this.cOther = cOther;
	}

}
