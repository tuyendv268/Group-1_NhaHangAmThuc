package com.cnpm.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cnpm.entity.BillDetail;
import com.cnpm.entity.BillEntity;
import com.cnpm.entity.ComboEntity;
import com.cnpm.entity.DishEntity;
import com.cnpm.repository.BillDetailRepository;
import com.cnpm.repository.BillRepository;
import com.cnpm.repository.ComboRepository;
import com.cnpm.repository.DishRepository;



@Service 
public class BillService {
	@Autowired
	private BillRepository billRepository;
@Autowired
	private DishRepository dishRepositoty;
@Autowired
	private BillDetailRepository billdetailRepository;  
@Autowired
	private ComboRepository comboRepository;
	public boolean save(BillEntity bill) {
		BillEntity bill1 = billRepository.save(bill);
		if(bill1 == null) {
			return false;
		}
		return true;
	}
	public Page<BillEntity> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.billRepository.findAll(pageable);
	}
	public List<BillEntity> findAll(){
		return billRepository.findAll();
		
	}
	public List<BillEntity> findUnpaidBill(){
		return billRepository.findByStatusPayment(false);
	}
	public List<BillEntity> findPaidBill(){
		return billRepository.findByStatusPayment(true);
	}
	public BillEntity updateInfoByID(long id, BillEntity bill) {
		BillEntity preBill = billRepository.getById(id);
		if(preBill != null && bill != null) {
			preBill.setCustomer(bill.getCustomer());
			preBill.setTables(bill.getTables());
			preBill.setEvent(bill.getEvent());
			billRepository.delete(bill);
			return billRepository.save(preBill);
		}
		return null;		
	}
	public boolean addDish(long billID, long dishID, int quantity) {
		BillEntity bill = billRepository.getById(billID);
		DishEntity dish = dishRepositoty.getById(dishID);
		if(dish != null && quantity > 0) {
			BillDetail billdetail = new BillDetail();
			billdetail.setDish(dish);
			billdetail.setQuantity(quantity);
			billdetail.setTotal(quantity*dish.getPrice());
			billdetail.setBill(bill);
			int total =  billdetail.getDish().getPrice()*quantity;
			billdetail.setTotal(total);
			billdetailRepository.save(billdetail);
			billRepository.save(bill);	
			return true;
		}
		return false;		
	}
	public boolean addCombo(long billID, long comboID, int quantity) {
		BillEntity bill = billRepository.getById(billID);
		ComboEntity combo = comboRepository.getById(comboID);
		if(combo != null && quantity > 0) {
			BillDetail billdetail = new BillDetail();
			billdetail.setCombo(combo);
			billdetail.setQuantity(quantity);
			billdetail.setTotal(quantity*combo.getPrice());
			billdetail.setBill(bill);
			int total =  billdetail.getCombo().getPrice()*quantity;
			billdetail.setTotal(total);
			billdetailRepository.save(billdetail);
			billRepository.save(bill);	
			return true;
		}
		return false;		
	}

	
	public boolean updateDish(long billID, long dishID, int quantity) {
		BillEntity bill = billRepository.getById(billID);
		DishEntity dish = dishRepositoty.getById(dishID);
		if(bill != null && dish != null && quantity >=0) {
			List<BillDetail> list = bill.getBillDetails();
			for(BillDetail billdetail : list) {
				
				if(dish == billdetail.getDish()) {
					if(quantity == 0) {
						list.remove(billdetail);
						billdetailRepository.delete(billdetail);
						billRepository.save(bill);
						return true;
					}
					if(quantity > 0) {
						billdetail.setQuantity(quantity);
						billdetailRepository.save(billdetail);
						billRepository.save(bill);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public BillEntity findBillById(Long id) {
		return billRepository.findByBillId(id);
	}
	
	public Long updateTotal(BillEntity bill) {
		Long Total = (long) 0;
		List<BillDetail> billdetails = bill.getBillDetails();
		if(billdetails == null) {
			bill.setFinalTotal(Total);
			billRepository.save(bill);
			return(Total);
		}
		for(BillDetail billdetail : billdetails) {
			Total = Total + billdetail.getTotal();
		}
		if(bill.getEvent() != null)
		Total = Total*(100 -bill.getEvent().getDiscountRate() -bill.getCustomer().getMembership().getDiscountRate())/100;
		else Total = Total*(100 -bill.getCustomer().getMembership().getDiscountRate())/100;
		bill.setFinalTotal(Total);
		billRepository.save(bill);
		return Total;
	}
	public boolean deleteById(Long id) {
		BillEntity bill = billRepository.getById(id);
		if(bill != null) {
			billRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public List<BillEntity> findAllPaidBills()
	{
		ArrayList<BillEntity> paidBills = (ArrayList<BillEntity>) billRepository.findAllByOrderByTimePaymentDesc();
		for(int i = paidBills.size() - 1; i>=0; i--)
		{
			if(!paidBills.get(i).isStatusPayment())
				paidBills.remove(i);
		}
		return paidBills;
	}
	public ArrayList<Object[]> findRevenueDueYear(int start, int end) {
		ArrayList<Object[]> cursor = (ArrayList<Object[]>) billRepository.findRevenueDueYear(start, end);
		return cursor;
	}
	
	public ArrayList<Object[]> findRevenueDueMonth(int year,int start, int end) {
		ArrayList<Object[]> cursor = (ArrayList<Object[]>) billRepository.findRevenueDueMonth(year,start, end);
		return cursor;
	}
}
