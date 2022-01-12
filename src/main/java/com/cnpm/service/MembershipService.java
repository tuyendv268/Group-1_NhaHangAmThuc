package com.cnpm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnpm.entity.CustomerEntity;
import com.cnpm.entity.MembershipEntity;
import com.cnpm.repository.CustomerRepository;
import com.cnpm.repository.MembershipRepository;



@Service 
public class MembershipService {
@Autowired
//	private CustomerRepository customerRepository;
	private MembershipRepository membershipRepository;
	
	
	public List<MembershipEntity> findAll(){
		return membershipRepository.findAll();
	}
	
	
	public MembershipEntity findById(Long id) {
		return membershipRepository.findByMembershipId(id);
	}
	
	
	public MembershipEntity editMembership(Long id, int exp, int discountRate) {
		MembershipEntity membership = findById(id);
		membership.setExp(exp);
		membership.setDiscountRate(discountRate);
	
		return membershipRepository.save(membership);
	}

	
}