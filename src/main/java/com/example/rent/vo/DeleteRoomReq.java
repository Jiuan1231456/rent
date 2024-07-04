package com.example.rent.vo;

import java.util.List;

public class DeleteRoomReq {

	private List<String> addressList;

	public DeleteRoomReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeleteRoomReq(List<String> addressList) {
		super();
		this.addressList = addressList;
	}

	public List<String> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<String> addressList) {
		this.addressList = addressList;
	}

}
