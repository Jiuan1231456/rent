package com.example.rent.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rent.entity.Contract;

@Repository
public interface ContractDao extends JpaRepository<Contract,Integer>{
	
	public List<Contract> findByAi(int ai);
	
	public boolean existsByEndDate(LocalDate now);

	public boolean existsByAddress(String address);
	
	public List<Contract> findByAddress(String address);
	
	public boolean existsByTenantPhone(String tenantPhone);
	
	public boolean existsByTenantIdentity(String tenantIdentity);

	public boolean existsByTenantPhoneAndAddressAndEndDateAfter(String tenantPhone,String address, LocalDate now);
	
	public boolean existsByTenantIdentityAndAddressAndEndDateAfter(String tenantIdentity,String address, LocalDate now);
	
	public boolean existsByAddressAndEndDateAfter(String address, LocalDate now);

	public boolean findTopByAddressOrderByEndDateDesc(String address);

	public boolean existsByTenantIdentityAndAddress(String tenantIdentity, String address);

	
}
