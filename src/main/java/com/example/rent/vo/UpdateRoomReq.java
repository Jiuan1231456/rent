package com.example.rent.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class UpdateRoomReq {

	// 大的Integer與Boolean vs 小的 int與boolean 的差異
	// 如果你是想要讓他空值(null)或檢測是否填寫等那就使用"大寫"
	// 小寫的是基本型態就算你不寫他也是一定會有值(預設值int=0;boolean=false...)

	@NotBlank(message = "Address is required!!")
	private String address;

	@Min(value = 0, message = "Rent_p is error!!")
	private Integer rentP;

	@Min(value = 0, message = "Deposit is error!!")
	private Integer deposit;

	@Min(value = 0, message = "cut_P is error!!")
	private Integer cutP;

	@Min(value = 0, message = "eletric_P is error!!")
	private Integer eletricP;

	@Min(value = 0, message = "water_P is error!!")
	private Integer waterP;

	@Min(value = 0, message = "manage_P is error!!")
	private Integer manageP;

	@Min(value = 0, message = "acreage is error!!")
	private Integer acreage;

	private Boolean parking;

	private String equip;

	private String rOther;

	public UpdateRoomReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdateRoomReq(@NotBlank(message = "Address is required!!") String address,
			@Min(value = 0, message = "Rent_p is error!!") Integer rentP,
			@Min(value = 0, message = "Deposit is error!!") Integer deposit,
			@Min(value = 0, message = "cut_P is error!!") Integer cutP,
			@Min(value = 0, message = "eletric_P is error!!") Integer eletricP,
			@Min(value = 0, message = "water_P is error!!") Integer waterP,
			@Min(value = 0, message = "manage_P is error!!") Integer manageP,
			@Min(value = 0, message = "acreage is error!!") Integer acreage, Boolean parking, String equip,
			String rOther) {
		super();
		this.address = address;
		this.rentP = rentP;
		this.deposit = deposit;
		this.cutP = cutP;
		this.eletricP = eletricP;
		this.waterP = waterP;
		this.manageP = manageP;
		this.acreage = acreage;
		this.parking = parking;
		this.equip = equip;
		this.rOther = rOther;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address!= null ? address.trim() : null;
	}

	public Integer getRentP() {
		return rentP;
	}

	public void setRentP(Integer rentP) {
		this.rentP = rentP;
	}

	public Integer getDeposit() {
		return deposit;
	}

	public void setDeposit(Integer deposit) {
		this.deposit = deposit;
	}

	public Integer getCutP() {
		return cutP;
	}

	public void setCutP(Integer cutP) {
		this.cutP = cutP;
	}

	public Integer getEletricP() {
		return eletricP;
	}

	public void setEletricP(Integer eletricP) {
		this.eletricP = eletricP;
	}

	public Integer getWaterP() {
		return waterP;
	}

	public void setWaterP(Integer waterP) {
		this.waterP = waterP;
	}

	public Integer getManageP() {
		return manageP;
	}

	public void setManageP(Integer manageP) {
		this.manageP = manageP;
	}

	public Integer getAcreage() {
		return acreage;
	}

	public void setAcreage(Integer acreage) {
		this.acreage = acreage;
	}

	public Boolean getParking() {
		return parking;
	}

	public void setParking(Boolean parking) {
		this.parking = parking;
	}

	public String getEquip() {
		return equip;
	}

	public void setEquip(String equip) {
		this.equip = equip!= null ? equip.trim() : null;
	}

	public String getrOther() {
		return rOther;
	}

	public void setrOther(String rOther) {
		this.rOther = rOther!= null ? rOther.trim() : null;
	}

}