package com.example.employee.Repository;

import com.example.employee.Model.Building;
import com.example.employee.Model.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipperRepository extends JpaRepository<Shipper, Long> {
}
