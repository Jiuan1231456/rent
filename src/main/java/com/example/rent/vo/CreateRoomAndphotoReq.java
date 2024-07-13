package com.example.rent.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateRoomAndphotoReq {

	@NotBlank(message = "Address is required!!")
	private String address;

	@NotBlank(message = "Accoint is required!!")
	private String account;

	@NotBlank(message = "Floor is required!!")
	private String floor;

	@NotBlank(message = "R_id is required!!")
	private String rId;

	private byte[] photo;

	@Min(value = 0, message = "Rent_p is error!!")
	@NotNull(message = "Rent_p is required!!")
	private Integer rentP;

	@Min(value = 0, message = "Deposit is error!!")
	@NotNull(message = "Deposit is required!!")
	private Integer deposit;

	@Min(value = 0, message = "cut_P is error!!")
	@NotNull(message = "cut_P is required!!")
	private Integer cutP;

	@Min(value = 0, message = "eletric_P is error!!")
	@NotNull(message = "eletric_P is required!!")
	private Integer eletricP;

	@Min(value = 0, message = "water_P is error!!")
	@NotNull(message = "water_P is required!!")
	private Integer waterP;

	@Min(value = 0, message = "manage_P is error!!")
	@NotNull(message = "manage_P is required!!")
	private Integer manageP;

	@Min(value = 0, message = "acreage is error!!")
	@NotNull(message = "acreage is required!!")
	private Integer acreage;

	@NotNull(message = "Parking is required!!")
	private Boolean parking;

	private String equip;

	private String rOther;

	public CreateRoomAndphotoReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreateRoomAndphotoReq(@NotBlank(message = "Address is required!!") String address,
			@NotBlank(message = "Accoint is required!!") String account,
			@NotBlank(message = "Floor is required!!") String floor,
			@NotBlank(message = "R_id is required!!") String rId, byte[] photo,
			@Min(value = 0, message = "Rent_p is error!!") @NotNull(message = "Rent_p is required!!") Integer rentP,
			@Min(value = 0, message = "Deposit is error!!") @NotNull(message = "Deposit is required!!") Integer deposit,
			@Min(value = 0, message = "cut_P is error!!") @NotNull(message = "cut_P is required!!") Integer cutP,
			@Min(value = 0, message = "eletric_P is error!!") @NotNull(message = "eletric_P is required!!") Integer eletricP,
			@Min(value = 0, message = "water_P is error!!") @NotNull(message = "water_P is required!!") Integer waterP,
			@Min(value = 0, message = "manage_P is error!!") @NotNull(message = "manage_P is required!!") Integer manageP,
			@Min(value = 0, message = "acreage is error!!") @NotNull(message = "acreage is required!!") Integer acreage,
			@NotNull(message = "Parking is required!!") Boolean parking, String equip, String rOther) {
		super();
		this.address = address;
		this.account = account;
		this.floor = floor;
		this.rId = rId;
		this.photo = photo;
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

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account!= null ? account.trim() : null;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor!= null ? floor.trim() : null;
	}

	public String getrId() {
		return rId;
	}

	public void setrId(String rId) {
		this.rId = rId!= null ? rId.trim() : null;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
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
