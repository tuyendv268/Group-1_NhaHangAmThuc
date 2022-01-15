package com.cnpm.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cnpm.entity.BillEntity;

public interface BillRepository extends JpaRepository<BillEntity, Long>{
	BillEntity findByBillId(Long billId);
	List<BillEntity> findByStatusPayment(boolean status);

	ArrayList<BillEntity> findAllByOrderByTimePaymentDesc();
	
	@Query(value="SELECT YEAR(date),SUM(total) FROM bill WHERE YEAR(date) BETWEEN :start AND :end GROUP BY YEAR(date) ORDER BY YEAR(date)", nativeQuery = true)
	List<Object[]> findRevenueDueYear(@Param("start") int start, @Param("end") int end);
	
	@Query(value="SELECT MONTH(date),SUM(total) FROM bill WHERE YEAR(date)=:year AND MONTH(date) BETWEEN :start AND :end GROUP BY MONTH(date) ORDER BY MONTH(date)", nativeQuery = true)
	List<Object[]> findRevenueDueMonth(@Param("year") int year, @Param("start") int start, @Param("end") int end);
}
