package com.example.employee.Repository;

import com.example.employee.Model.Building;
import com.example.employee.Model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {
}
