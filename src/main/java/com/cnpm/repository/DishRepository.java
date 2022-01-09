package com.cnpm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cnpm.entity.ComboEntity;
import com.cnpm.entity.DishEntity;

public interface DishRepository extends JpaRepository<DishEntity, Long>{
	public DishEntity findByDishId(Long id);
	public DishEntity findByDishName(String dishName);

}
