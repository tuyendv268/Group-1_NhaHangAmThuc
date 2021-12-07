package com.cnpm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cnpm.entity.TableEntity;

public interface TableRepository extends CrudRepository<TableEntity, Long>{
	List<TableEntity> findAll();
}
