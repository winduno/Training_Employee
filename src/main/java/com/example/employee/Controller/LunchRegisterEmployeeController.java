package com.example.employee.Controller;

import com.example.employee.Model.LunchRegisterEmployee;
import com.example.employee.Service.LunchRegisterEmployee.ILunchRegisterEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/lunchregisteremployee")
public class LunchRegisterEmployeeController {

    @Autowired
    private ILunchRegisterEmployeeService lunchRegisterEmployeeService;

    @GetMapping
    public ResponseEntity<Iterable<LunchRegisterEmployee>> getAllLunchRegisterEmployee() {
        return new ResponseEntity<>(this.lunchRegisterEmployeeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LunchRegisterEmployee> getLunchRegisterEmployeeById(@PathVariable(name = "id") Long id) {
        Optional<LunchRegisterEmployee> optionalLunchRegisterEmployee = this.lunchRegisterEmployeeService.findById(id);
        return optionalLunchRegisterEmployee.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<LunchRegisterEmployee> addLunchRegisterEmployee(@RequestBody LunchRegisterEmployee lunchRegisterEmployee) {
        this.lunchRegisterEmployeeService.save(lunchRegisterEmployee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LunchRegisterEmployee> deleteLunchRegisterEmployeeById(@PathVariable(name = "id") Long id) {
        Optional<LunchRegisterEmployee> optionalLunchRegisterEmployee = this.lunchRegisterEmployeeService.findById(id);
        if (optionalLunchRegisterEmployee.isPresent()) {
            this.lunchRegisterEmployeeService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
