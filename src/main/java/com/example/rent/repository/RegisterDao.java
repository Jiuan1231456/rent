package com.example.rent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rent.entity.Register;

@Repository
public interface RegisterDao extends JpaRepository<Register, String>{

	public boolean existsByOwnerAccountAndOwnerPhone(String ownerAccount, String ownerPhone);
}
