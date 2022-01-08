package com.cnpm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cnpm.entity.BillEntity;

public interface BillRepository extends JpaRepository<BillEntity, Long>{
}
