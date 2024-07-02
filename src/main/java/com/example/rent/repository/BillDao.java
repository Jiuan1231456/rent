package com.example.rent.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rent.entity.Bill;

@Repository
public interface BillDao extends JpaRepository<Bill,Integer> {

	public boolean existsByPeriodStart(LocalDate periodStart); //開始時間
	
	public boolean existsByAddress(String address); //地址
	
	public boolean existsByTenantIdentity(String tenantIdentity); //房客身分證
	
}
