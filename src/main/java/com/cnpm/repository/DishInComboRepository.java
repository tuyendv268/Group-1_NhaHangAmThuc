package com.cnpm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cnpm.entity.ComboEntity;
import com.cnpm.entity.DishInComboEntity;


public interface DishInComboRepository extends JpaRepository<DishInComboEntity, Long> {
	@Query(value="SELECT dish.dish_name,dish_in_combo.quantity FROM dish_in_combo JOIN dish WHERE dish_in_combo.dish_id=dish.id AND combo_id=:comboid", nativeQuery = true)
	List<Object[]> findDishesInCombo(@Param("comboid") Long id);
	List<DishInComboEntity> findByCombo(ComboEntity combo);
}
