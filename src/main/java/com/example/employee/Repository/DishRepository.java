package com.example.employee.Repository;

import com.example.employee.Model.Building;
import com.example.employee.Model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Long> {

    @Query(value = "SELECT id, name, price FROM menu_dish md JOIN dish d on md.id_dish = d.id where md.id_menu = 4 ", nativeQuery = true)
    List<Dish> getDishByMenuId(Long id);
}
