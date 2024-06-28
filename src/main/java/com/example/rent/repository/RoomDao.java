package com.example.rent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rent.entity.Room;

@Repository
public interface RoomDao extends JpaRepository<Room, String>{

	public boolean existsByRoomId(String roomId);
	
}
