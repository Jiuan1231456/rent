package com.example.rent.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.rent.entity.Bill;

@Repository
public interface BillDao extends JpaRepository<Bill,Integer> {

	public boolean existsByPeriodStart(LocalDate periodStart); //開始時間
	
//	public boolean existsByPeriodStart(LocalDate periodStart); //開始時間
	
	public boolean existsByAddress(String address); //地址
	
	public boolean existsByTenantIdentity(String tenantIdentity); //房客身分證
	
	public List<Bill> findByAddressEqualsAndTenantIdentityEqualsAndPeriodStartGreaterThanEqualAndPeriodEndLessThanEqual(String address,String tenantIdentity,LocalDate periodStart,LocalDate periodEnd);

//	@Modifying
//	@Query("DELETE FROM Bill b WHERE b.address = :address AND b.tenantIdentity = :tenantIdentity AND b.periodStart >= :periodStart AND b.periodEnd <= :periodEnd")
//	public void deleteByAddressAndTenantIdentityAndPeriodStartGreaterThanEqualAndPeriodEndLessThanEqual(
//			@Param("address")String address,@Param("tenantIdentity") String tenantIdentity,@Param("periodStart") LocalDate periodStart,@Param("periodEnd") LocalDate periodEnd);
}

