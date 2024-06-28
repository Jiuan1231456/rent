package com.example.rent.service.ifs;

import com.example.rent.vo.BasicRes;
import com.example.rent.vo.CreateRoomReq;
import com.example.rent.vo.UpdateRoomReq;

public interface RoomService {

	
	public BasicRes creatRoom(CreateRoomReq req);
	
	public BasicRes updateRoom(UpdateRoomReq req);
	

}
