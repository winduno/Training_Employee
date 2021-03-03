package com.example.employee.Repository;

import com.example.employee.Model.Building;
import com.example.employee.Model.ParkingTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingTicketRepository extends JpaRepository<ParkingTicket, Long> {
}
