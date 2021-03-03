package com.example.employee.Controller;

import com.example.employee.Model.Building;
import com.example.employee.Service.Building.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/building")
public class BuildingController {

    @Autowired
    private IBuildingService buildingService;

    @GetMapping
    public ResponseEntity<Iterable<Building>> getAllBuilding(){
        return new ResponseEntity<>(this.buildingService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Building> getBuildingById(@PathVariable(name = "id") Long id){
        Optional<Building> optionalBuilding = this.buildingService.findById(id);
        return optionalBuilding.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Building> addBuilding(@RequestBody Building building){
        return new ResponseEntity<>(this.buildingService.save(building), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Building> deleteBuildingById(@PathVariable(name = "id") Long id){
        Optional<Building> optionalBuilding = this.buildingService.findById(id);
        if (optionalBuilding.isPresent()){
            this.buildingService.delete(id);
            return new ResponseEntity<>( HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
