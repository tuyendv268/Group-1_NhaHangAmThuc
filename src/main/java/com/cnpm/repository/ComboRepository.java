package com.cnpm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cnpm.entity.ComboEntity;

public interface ComboRepository extends JpaRepository<ComboEntity, Long>{

}
