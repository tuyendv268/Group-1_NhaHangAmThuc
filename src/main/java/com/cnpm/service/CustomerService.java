package com.cnpm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
		customer.setPoint(Long.valueOf(0));
		customer.setMembership(membershipRepository.findAll(Sort.by(Sort.Direction.ASC, "exp")).get(0));
		return customerRepository.save(customer);
	}
	
	public List<CustomerEntity> findAll(){
		return customerRepository.findAll();
	}
	
	
	public CustomerEntity findById(Long id) {
		return customerRepository.findByCustomerId(id);
	}
	
	public List<CustomerEntity> findByName (String customerName) {
		return customerRepository.findByCustomerName(customerName);
	}
	
	public CustomerEntity editCustomerInfo(Long id, String customerName, String telephone) {
		
		CustomerEntity customer = findById(id);
		customer.setCustomerName(customerName);
		customer.setTelephone(telephone);
		System.out.print("editing");
		return customerRepository.save(customer);
	}
	
	
	public boolean deleteCustomer(Long id) {
		CustomerEntity customer = customerRepository.getById(id);
		if(customer != null) {
			customerRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public CustomerEntity addPoint(Long id, Long billPrice) {
		
		CustomerEntity customer = findById(id);
		//TODO: Sửa công thức tính điểm tại đây
		Long point = billPrice/10000;
		
		customer.setPoint(point + customer.getPoint());
		
		//Update Membership Rank
		if(customer.getPoint() < 0)
		{
			customer.setPoint(Long.valueOf(0));
			customer.setMembership(membershipRepository.findAll(Sort.by(Sort.Direction.ASC, "exp")).get(0));
		}
		else
		{
			List<MembershipEntity> ranks = membershipRepository.findAll(Sort.by(Sort.Direction.ASC, "exp"));
			int i;
			for(i=0; i<ranks.size(); i++)
				if(customer.getPoint() < ranks.get(i).getExp())
					break;
			customer.setMembership(ranks.get(i-1));
		}

		return customerRepository.save(customer);
	}
	
	public void updateRankAllCustomers() {
		
		ArrayList<CustomerEntity> customers = (ArrayList<CustomerEntity>) customerRepository.findAll();
		
		//Update Membership Rank
		for(int i=0; i<customers.size(); i++)
		{
			if(customers.get(i).getPoint() < 0)
			{
				customers.get(i).setPoint(Long.valueOf(0));
				customers.get(i).setMembership(membershipRepository.findAll(Sort.by(Sort.Direction.ASC, "exp")).get(0));
			}
			else
			{
				List<MembershipEntity> ranks = membershipRepository.findAll(Sort.by(Sort.Direction.ASC, "exp"));
				int j;
				for(j=0; j<ranks.size(); j++)
					if(customers.get(i).getPoint() < ranks.get(j).getExp())
						break;
				customers.get(i).setMembership(ranks.get(j-1));
				customerRepository.save(customers.get(i));
			}
		}
	}
	public CustomerEntity newCustomer(String customerName, String phone, Long membershipId) {
		CustomerEntity customer = new CustomerEntity();
		customer.setCustomerName(customerName);
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
