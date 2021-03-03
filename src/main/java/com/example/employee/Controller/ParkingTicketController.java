package com.example.employee.Controller;

import com.example.employee.Model.ParkingTicket;
import com.example.employee.Service.ParkingTicket.IParkingTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/parkingticket")
public class ParkingTicketController {

    @Autowired
    private IParkingTicketService parkingTicketService;

    @GetMapping
    public ResponseEntity<Iterable<ParkingTicket>> getAllParkingTicket(){
        return new ResponseEntity<>(this.parkingTicketService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingTicket> getParkingTicketById(@PathVariable(name = "id") Long id){
        Optional<ParkingTicket> optionalParkingTicket = this.parkingTicketService.findById(id);
        return optionalParkingTicket.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ParkingTicket> addParkingTicket(@RequestBody ParkingTicket parkingTicket){
        return new ResponseEntity<>(this.parkingTicketService.save(parkingTicket), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ParkingTicket> deleteParkingTicketById(@PathVariable(name = "id") Long id){
        Optional<ParkingTicket> optionalParkingTicket = this.parkingTicketService.findById(id);
        if (optionalParkingTicket.isPresent()){
            this.parkingTicketService.delete(id);
            return new ResponseEntity<>( HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
