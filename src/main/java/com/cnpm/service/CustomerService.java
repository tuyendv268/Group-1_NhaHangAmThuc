package com.cnpm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnpm.entity.CustomerEntity;
import com.cnpm.entity.MembershipEntity;
import com.cnpm.repository.CustomerRepository;
import com.cnpm.repository.MembershipRepository;


@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired 
	private MembershipRepository membershipRepository;
	
	public CustomerEntity addCustomer(CustomerEntity customer) {
		return customerRepository.save(customer);
	}
	public CustomerEntity newCustomer(String customerName, String phone, Long membershipId) {
		CustomerEntity customer = new CustomerEntity();
		customer.setCustormerName(customerName);
		customer.setTelephone(phone);
		MembershipEntity membership = membershipRepository.getById(membershipId);
		customer.setMembership(membership);
		return customer;
	}
	public CustomerEntity getById(Long id) {
		CustomerEntity customer = customerRepository.getById(id);
		return customer;
	}
}
