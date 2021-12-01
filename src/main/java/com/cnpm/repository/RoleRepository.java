package com.cnpm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cnpm.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
	
}
