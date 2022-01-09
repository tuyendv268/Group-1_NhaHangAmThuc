package com.cnpm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cnpm.entity.DishInComboEntity;


public interface DishInComboRepository extends JpaRepository<DishInComboEntity, Long> {

}
