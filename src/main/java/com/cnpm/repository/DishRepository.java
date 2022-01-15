package com.cnpm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cnpm.entity.ComboEntity;
import com.cnpm.entity.DishEntity;

public interface DishRepository extends JpaRepository<DishEntity, Long>{
	public DishEntity findByDishId(Long id);
	public DishEntity findByDishName(String dishName);
	@Query(value="SELECT dish.dish_name,dish.price,dish.url FROM bill_detail JOIN dish WHERE bill_detail.dish_id=dish.id AND bill_detail.dish_id IS NOT NULL AND dish.feature_dish IS TRUE AND dish.status IS TRUE AND YEAR(bill_detail.modify_time)= YEAR(NOW())  AND MONTH(bill_detail.modify_time)= MONTH(NOW()) AND DAY(bill_detail.modify_time)= DAY(NOW())-1 GROUP BY bill_detail.dish_id,dish.dish_name,dish.price,dish.url ORDER BY SUM(bill_detail.quatity) DESC LIMIT 3",nativeQuery=true)
	List<Object[]> findTopFeaturedDish();
}
