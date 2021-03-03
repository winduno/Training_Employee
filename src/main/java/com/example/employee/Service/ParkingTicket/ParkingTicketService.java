package com.example.employee.Service.ParkingTicket;

import com.example.employee.Model.ParkingTicket;
import com.example.employee.Repository.ParkingTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParkingTicketService implements IParkingTicketService{

    @Autowired
    private ParkingTicketRepository parkingTicketRepository;

    @Override
    public Iterable<ParkingTicket> getAll() {
        return this.parkingTicketRepository.findAll();
    }

    @Override
    public ParkingTicket save(ParkingTicket parkingTicket) {
        return this.parkingTicketRepository.save(parkingTicket);
    }

    @Override
    public Optional<ParkingTicket> findById(Long id) {
        return this.parkingTicketRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        this.parkingTicketRepository.deleteById(id);
    }
}
