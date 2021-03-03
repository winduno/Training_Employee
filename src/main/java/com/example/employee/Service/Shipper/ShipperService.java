package com.example.employee.Service.Shipper;

import com.example.employee.Model.Shipper;
import com.example.employee.Repository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShipperService implements IShipperService{

    @Autowired
    private ShipperRepository shipperRepository;

    @Override
    public Iterable<Shipper> getAll() {
        return this.shipperRepository.findAll();
    }

    @Override
    public Shipper save(Shipper shipper) {
        return this.shipperRepository.save(shipper);
    }

    @Override
    public Optional<Shipper> findById(Long id) {
        return this.shipperRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        this.shipperRepository.deleteById(id);
    }
}
