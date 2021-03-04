package com.example.employee.Service.Building;

import com.example.employee.Model.Building;
import com.example.employee.Repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BuildingService implements IBuildingService{

    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    public List<Building> getAll() {
        try{
            return this.buildingRepository.getAll();
        } catch (Exception e){
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public void save(Building building) {
        this.buildingRepository.save(building.getAddress(), building.getName());
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
