package com.example.employee.Service.ParkingTicket;

import com.example.employee.Model.ParkingTicket;
import com.example.employee.Repository.ParkingTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingTicketService {

    @Autowired
    private ParkingTicketRepository parkingTicketRepository;

    public List<ParkingTicket> getAll() {
        return this.parkingTicketRepository.findAll();
    }

    public void save(ParkingTicket parkingTicket) {
        this.parkingTicketRepository.save(parkingTicket);
    }

    public Optional<ParkingTicket> findById(Long id) {
        return this.parkingTicketRepository.findById(id);
    }

    public void delete(Long id) {
        this.parkingTicketRepository.deleteById(id);
    }
}
