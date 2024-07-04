package com.example.rent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rent.entity.Room;

@Repository
public interface RoomDao extends JpaRepository<Room, String>{

	public boolean existsByAccountAndRoomId(String account,String roomId);
	
	public boolean existsByAddress(String address);
	
	public boolean existsByAccount(String account);
	
	public List<Room> findByAddressContainingAndRoomIdContaining(String address,String roomId);
	
	public List<Room> findByAccountEquals(String account);
	
	public List<Room> findByAddressEquals(String address);
	
	public Room findByAddress(String address);

}
