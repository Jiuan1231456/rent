package com.example.rent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rent.entity.Register;

@Repository
public interface RegisterDao extends JpaRepository<Register, String>{
	
	public boolean existsByOwnerAccount(String ownerAccount);
	
	public boolean existsByOwnerPwd(String ownerPwd);
	
	public boolean existsByOwnerIdentity(String ownerIdentity);
	
	public boolean existsByOwnerPhone(String ownerPhone);
	
	public boolean existsByOwnerName(String ownerName);
	
	public boolean existsByOwnerEmail(String ownerEmail);
	
	public boolean existsByAccountBank(String accountBank);
	
	public Register findByOwnerAccount(String ownerAccount);
	
	public List<Register> findByOwnerAccountEquals(String ownerAccount);
	
	public List<Register> findByOwnerName(String ownerName);
}
