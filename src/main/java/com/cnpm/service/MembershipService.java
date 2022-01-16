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
	
	public List<MembershipEntity> findRealRanks(){
		List<MembershipEntity> realRanks =  membershipRepository.findAll();
		realRanks.remove(realRanks.size()-1);
		return realRanks;
	}
	
	
	public MembershipEntity editDiscountRate(Long id, int discountRate) {
		MembershipEntity rank = membershipRepository.findByMembershipId(id);
		if((discountRate >= 0)||(discountRate <= 100))
			rank.setDiscountRate(discountRate);
		else
			if(discountRate < 0)
				rank.setDiscountRate(0);
			if(discountRate > 100)
				rank.setDiscountRate(100);
		return membershipRepository.save(rank);
	}

	
}