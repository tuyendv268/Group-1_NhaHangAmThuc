package com.cnpm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cnpm.entity.DishEntity;

public interface DishRepository extends JpaRepository<DishEntity, Long>{

}
