package com.example.employee.Repository;

import com.example.employee.Model.Building;
import com.example.employee.Model.LunchRegisterEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LunchRegisterEmployeeRepository extends JpaRepository<LunchRegisterEmployee, Long> {
}
