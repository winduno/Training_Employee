package com.example.employee.Service.Building;

import com.example.employee.Model.Building;
import com.example.employee.Repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuildingService implements IBuildingService{

    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    public Iterable<Building> getAll() {
        return this.buildingRepository.findAll();
    }

    @Override
    public Building save(Building building) {
        return this.buildingRepository.save(building);
    }

    @Override
    public Optional<Building> findById(Long id) {
        return this.buildingRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        this.buildingRepository.deleteById(id);
    }
}
