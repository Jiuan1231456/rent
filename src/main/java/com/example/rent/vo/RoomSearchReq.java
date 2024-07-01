package com.example.rent.vo;

public class RoomSearchReq {

	private String address;

	private String roomId;

	public RoomSearchReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoomSearchReq(String address, String roomId) {
		super();
		this.address = address;
		this.roomId = roomId;
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

}
