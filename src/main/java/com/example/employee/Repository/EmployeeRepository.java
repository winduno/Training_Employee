package com.example.employee.Repository;

import com.example.employee.Model.Building;
import com.example.employee.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
