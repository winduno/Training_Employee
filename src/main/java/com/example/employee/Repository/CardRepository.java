package com.example.employee.Repository;

import com.example.employee.Model.Building;
import com.example.employee.Model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
