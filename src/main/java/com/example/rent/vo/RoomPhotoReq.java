package com.example.rent.vo;

public class RoomPhotoReq {

	private String address;

	private byte[] photo;

	public RoomPhotoReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoomPhotoReq(String address, byte[] photo) {
		super();
		this.address = address;
		this.photo = photo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

}
