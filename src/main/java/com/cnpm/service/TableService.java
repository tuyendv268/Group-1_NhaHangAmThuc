package com.cnpm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnpm.entity.TableEntity;
import com.cnpm.repository.TableRepository;

@Service
public class TableService {
	@Autowired
	private TableRepository tableRepository;
	
	public List<TableEntity> findAll(){
		return tableRepository.findAll();
	}
}
