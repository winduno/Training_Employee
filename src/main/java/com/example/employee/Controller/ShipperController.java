package com.example.employee.Controller;

import com.example.employee.Model.Shipper;
import com.example.employee.Service.Shipper.IShipperService;
import com.example.employee.Service.Shipper.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/shipper")
public class ShipperController {

    @Autowired
    private ShipperService shipperService;

    @GetMapping
    public ResponseEntity<Iterable<Shipper>> getAllShipper() {
        return new ResponseEntity<>(this.shipperService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shipper> getShipperById(@PathVariable(name = "id") Long id) {
        Optional<Shipper> optionalShipper = this.shipperService.findById(id);
        return optionalShipper.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Shipper> addShipper(@RequestBody Shipper shipper) {
        this.shipperService.save(shipper);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Shipper> deleteShipperById(@PathVariable(name = "id") Long id) {
        Optional<Shipper> optionalShipper = this.shipperService.findById(id);
        if (optionalShipper.isPresent()) {
            this.shipperService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
