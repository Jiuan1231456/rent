package com.example.rent.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class CreateRoomRes extends BasicRes{

	private String address;

	private String account;

	private String floor;

	private String rId;

	private byte[] photo;

	private int rentP;

	private int deposit;

	private int cutP;

	private int eletricP;

	private int waterP;

	private int manageP;

	private int acreage;

	private String parking;

	private String equip;

	public CreateRoomRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreateRoomRes(int code, String message) {
		super(code, message);
		// TODO Auto-generated constructor stub
	}

	public CreateRoomRes(int code, String message,String address, String account, String floor, String rId, byte[] photo, int rentP, int deposit,
			int cutP, int eletricP, int waterP, int manageP, int acreage, String parking, String equip) {
		super(code, message);
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
	}
	
	public CreateRoomRes(String address, String account, String floor, String rId, byte[] photo, int rentP, int deposit,
			int cutP, int eletricP, int waterP, int manageP, int acreage, String parking, String equip) {
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
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getrId() {
		return rId;
	}

	public void setrId(String rId) {
		this.rId = rId;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public int getRentP() {
		return rentP;
	}

	public void setRentP(int rentP) {
		this.rentP = rentP;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getCutP() {
		return cutP;
	}

	public void setCutP(int cutP) {
		this.cutP = cutP;
	}

	public int getEletricP() {
		return eletricP;
	}

	public void setEletricP(int eletricP) {
		this.eletricP = eletricP;
	}

	public int getWaterP() {
		return waterP;
	}

	public void setWaterP(int waterP) {
		this.waterP = waterP;
	}

	public int getManageP() {
		return manageP;
	}

	public void setManageP(int manageP) {
		this.manageP = manageP;
	}

	public int getAcreage() {
		return acreage;
	}

	public void setAcreage(int acreage) {
		this.acreage = acreage;
	}

	public String getParking() {
		return parking;
	}

	public void setParking(String parking) {
		this.parking = parking;
	}

	public String getEquip() {
		return equip;
	}

	public void setEquip(String equip) {
		this.equip = equip;
	}

	
	
}
