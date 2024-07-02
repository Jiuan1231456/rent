package com.example.rent.vo;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdateContractReq {

	@NotNull(message = "ai is required")
	private Integer ai;// 編碼

	@NotBlank(message = "Address is required!!")
	private String address;// 地址

	@NotBlank(message = "R_id is required!!")
	private String roomId;// 房號

	private String tenantHomeAddress;

	private String tenantContactAddress;

	private String ownerHomeAddress;

	private String ownerContactAddress;

//	@NotNull(message = "cut_p is required")
	private Integer cutP;// 違約金

	@NotNull(message = "cutDate is required!!")
	private LocalDate cutDate;// 中止日期

	@NotBlank(message = "cutReason is required!!")
	private String cutReason;// 中止理由

	private String cOther;// 其他

	public UpdateContractReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdateContractReq(@NotNull(message = "ai is required") Integer ai,
			@NotBlank(message = "Address is required!!") String address,
			@NotBlank(message = "R_id is required!!") String roomId, String tenantHomeAddress,
			String tenantContactAddress, String ownerHomeAddress, String ownerContactAddress, Integer cutP,
			@NotNull(message = "cutDate is required!!") LocalDate cutDate,
			@NotBlank(message = "cutReason is required!!") String cutReason, String cOther) {
		super();
		this.ai = ai;
		this.address = address;
		this.roomId = roomId;
		this.tenantHomeAddress = tenantHomeAddress;
		this.tenantContactAddress = tenantContactAddress;
		this.ownerHomeAddress = ownerHomeAddress;
		this.ownerContactAddress = ownerContactAddress;
		this.cutP = cutP;
		this.cutDate = cutDate;
		this.cutReason = cutReason;
		this.cOther = cOther;
	}

	public Integer getAi() {
		return ai;
	}

	public void setAi(Integer ai) {
		this.ai = ai;
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
