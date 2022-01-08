package com.cnpm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cnpm.entity.BillEntity;

public interface BillRepository extends JpaRepository<BillEntity, Long>{
	BillEntity findByBillId(Long billId);
}
