package com.example.employee.Service.Shipper;

import com.example.employee.Model.Shipper;
import com.example.employee.Repository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipperService {

    @Autowired
    private ShipperRepository shipperRepository;

    public List<Shipper> getAll() {
        return this.shipperRepository.findAll();
    }

    public void save(Shipper shipper) {
        this.shipperRepository.save(shipper);
    }

    public Optional<Shipper> findById(Long id) {
        return this.shipperRepository.findById(id);
    }

    public void delete(Long id) {
        this.shipperRepository.deleteById(id);
    }


}
