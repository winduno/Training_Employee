package com.example.employee.Service.Building;

import com.example.employee.Model.Building;
import com.example.employee.Model.DTO.BuildingObj;
import com.example.employee.Repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    public List<Building> getAll() {
        try{
            return this.buildingRepository.getAll();
        } catch (Exception e){
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    public List<BuildingObj> getAllCustom() {
        return this.buildingRepository.getAllCustom();
    }

    public Optional<BuildingObj> getBuildingById(Long id){
        return this.buildingRepository.findBuildingById(id);
    }

    public void save(Building building) {
        this.buildingRepository.save(building.getAddress(), building.getName());
    }

    public Optional<Building> findById(Long id) {
        return this.buildingRepository.findById(id);
    }

    public void delete(Long id) {
        this.buildingRepository.deleteById(id);
    }
}
