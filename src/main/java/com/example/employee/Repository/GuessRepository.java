package com.example.employee.Repository;

import com.example.employee.Model.Building;
import com.example.employee.Model.Guess;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuessRepository extends JpaRepository<Guess, Long> {
}
