package com.cnpm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cnpm.entity.CustomerEntity;
import com.cnpm.entity.TableEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{
	List<CustomerEntity> findAll();
	CustomerEntity findByCustomerId(Long customerId);
	List<CustomerEntity> findByTelephone(String telephone);
	List<CustomerEntity> findByCustomerName(String custormerName);
}
