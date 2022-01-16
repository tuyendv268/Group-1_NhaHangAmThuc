package com.cnpm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cnpm.entity.ComboEntity;
import com.cnpm.entity.DishEntity;

public interface ComboRepository extends JpaRepository<ComboEntity, Long>{
	public List<ComboEntity> findByComboName(String comboName);
	public List<ComboEntity> findAllByStatus(Boolean status);
	public ComboEntity findByComboId(Long id);
}
