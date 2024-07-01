package com.example.rent.vo;

import java.util.List;

import com.example.rent.entity.Room;

public class RoomSearchRes extends BasicRes {

	private List<Room> roomList;

	public RoomSearchRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoomSearchRes(int code, String message) {
		super(code, message);
		// TODO Auto-generated constructor stub
	}

	public RoomSearchRes(int code, String message,List<Room> roomList) {
		super(code, message);
		this.roomList = roomList;
	}

	public List<Room> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<Room> roomList) {
		this.roomList = roomList;
	}

}
