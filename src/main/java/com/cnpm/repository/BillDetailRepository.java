package com.cnpm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cnpm.entity.BillDetail;

public interface BillDetailRepository extends JpaRepository<BillDetail, Long>{

}
