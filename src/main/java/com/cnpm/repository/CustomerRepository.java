package com.cnpm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cnpm.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{

}
