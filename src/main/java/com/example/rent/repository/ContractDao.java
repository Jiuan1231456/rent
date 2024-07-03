package com.example.rent.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rent.entity.Bill;
import com.example.rent.entity.Contract;

@Repository
public interface ContractDao extends JpaRepository<Contract,Integer>{
	
	public List<Contract> findByAi(int ai);
	
	public boolean existsByEndDate(LocalDate now);

	public boolean existsByAddress(String address);
	
	public boolean existsByTenantIdentityAndTenantPhoneAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            
            String tenantIdentity,
            String tenantPhone,
            LocalDate endDate,
            LocalDate startDate
    );
	
	
public boolean existsByTenantPhoneAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            
            String tenantPhone,
            LocalDate endDate,
            LocalDate startDate
    );

	public List<Contract> findByAddressEqualsAndTenantIdentityEqualsAndEndDateLessThanEqual(String address,String tenantIdentity,LocalDate endDate);
	
	public List<Contract> findByTenantIdentity(String tenantIdentity);
	
	public List<Contract> findByTenantIdentityAndStartDateAfter(String tenantIdentity,LocalDate startDate);
	
	public List<Contract> findByAddress(String address);
	
	public boolean existsByTenantPhone(String tenantPhone);
	
	public boolean existsByTenantIdentity(String tenantIdentity);
	
	public boolean existsByTenantPhoneAndEndDateBetween(String tenantPhone,LocalDate startDate,LocalDate endDate);
	
	public boolean existsByTenantIdentityAndEndDateAfter(String tenantIdentity,LocalDate endDate);
	
	public boolean existsByTenantIdentityAndEndDateBetween(String tenantIdentity,LocalDate startDate,LocalDate endDate);

	public boolean existsByTenantPhoneAndAddressAndEndDateAfter(String tenantPhone,String address, LocalDate now);
	
	public boolean existsByTenantIdentityAndAddressAndEndDateAfter(String tenantIdentity,String address, LocalDate now);
	
	public boolean existsByAddressAndEndDateAfter(String address, LocalDate now);

	public boolean findTopByAddressOrderByEndDateDesc(String address);

	public boolean existsByTenantIdentityAndAddress(String tenantIdentity, String address);

	public boolean existsByOwnerIdentity(String ownerIdentity);
	
	public List<Contract> findByAddressEqualsAndTenantIdentityEqualsAndStartDateGreaterThanEqualAndEndDateLessThanEqual(String address,String tenantIdentity,LocalDate startDate,LocalDate endDate);

	
}
