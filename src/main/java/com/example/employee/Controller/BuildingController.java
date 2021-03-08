package com.example.employee.Controller;

import com.example.employee.Model.Building;
import com.example.employee.Model.DTO.BuildingObj;
import com.example.employee.Service.Building.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/building")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @GetMapping
    public ResponseEntity<List<BuildingObj>> getAllBuilding() {
        return new ResponseEntity<>(this.buildingService.getAllCustom(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuildingObj> getBuildingById(@PathVariable(name = "id") Long id) {
        Optional<BuildingObj> optionalBuildingObj = this.buildingService.getBuildingById(id);
        return optionalBuildingObj.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Building> addBuilding(@RequestBody Building building) {
        this.buildingService.save(building);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Building> deleteBuildingById(@PathVariable(name = "id") Long id) {
        Optional<Building> optionalBuilding = this.buildingService.findById(id);
        if (optionalBuilding.isPresent()) {
            this.buildingService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
