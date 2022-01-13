package com.cnpm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cnpm.entity.CustomerEntity;
import com.cnpm.entity.MembershipEntity;

public interface MembershipRepository extends JpaRepository<MembershipEntity, Long>{
	List<MembershipEntity> findAll();
	MembershipEntity findByMembershipId(Long id);
}
