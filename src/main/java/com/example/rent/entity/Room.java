package com.example.rent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room {

	@Id
	@Column(name = "address")
	private String address;

	@Column(name = "account")
	private String account;

	@Column(name = "floor")
	private String floor;

	@Column(name = "r_id")
	private String roomId;

//	@Lob
//	@Column(name = "photo", columnDefinition = "LONGBLOB")
//	private byte[] photo;

	@Column(name = "rent_p")
	private int rentP;

	@Column(name = "deposit")
	private int deposit;

	@Column(name = "cut_p")
	private int cutP;

	@Column(name = "eletric_p")
	private int eletricP;//一度費用

	@Column(name = "water_p")
	private int waterP;//水費

	@Column(name = "manage_p")
	private int manageP;//管理費

	@Column(name = "acreage")
	private int acreage;

	@Column(name = "parking")
	private boolean parking;

	@Column(name = "equip")
	private String equip;
	
	@Column(name = "r_other")
	private String rOther;

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Room(String address, String account, String floor, String roomId, int rentP, int deposit, int cutP,
			int eletricP, int waterP, int manageP, int acreage, boolean parking, String equip, String rOther) {
		super();
		this.address = address;
		this.account = account;
		this.floor = floor;
		this.roomId = roomId;
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

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
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

	public boolean isParking() {
		return parking;
	}

	public void setParking(boolean parking) {
		this.parking = parking;
	}

	public String getEquip() {
		return equip;
	}

	public void setEquip(String equip) {
		this.equip = equip;
	}

	public String getrOther() {
		return rOther;
	}

	public void setrOther(String rOther) {
		this.rOther = rOther;
	}

}