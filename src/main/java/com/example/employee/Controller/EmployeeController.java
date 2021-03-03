package com.example.employee.Controller;

import com.example.employee.Model.Employee;
import com.example.employee.Service.Employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping
    public ResponseEntity<Iterable<Employee>> getAllEmployee(){
        return new ResponseEntity<>(this.employeeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(name = "id") Long id){
        Optional<Employee> optionalEmployee = this.employeeService.findById(id);
        return optionalEmployee.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(this.employeeService.save(employee), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployeeById(@PathVariable(name = "id") Long id){
        Optional<Employee> optionalEmployee = this.employeeService.findById(id);
        if (optionalEmployee.isPresent()){
            this.employeeService.delete(id);
            return new ResponseEntity<>( HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
