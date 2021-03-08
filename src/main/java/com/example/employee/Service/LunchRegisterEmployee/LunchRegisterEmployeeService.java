package com.example.employee.Service.LunchRegisterEmployee;

import com.example.employee.Model.LunchRegisterEmployee;
import com.example.employee.Repository.LunchRegisterEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LunchRegisterEmployeeService {

    @Autowired
    private LunchRegisterEmployeeRepository lunchRegisterEmployeeRepository;

    public List<LunchRegisterEmployee> getAll() {
        return this.lunchRegisterEmployeeRepository.findAll();
    }

    public void save(LunchRegisterEmployee lunchRegisterEmployee) {
        this.lunchRegisterEmployeeRepository.save(lunchRegisterEmployee);
    }

    public Optional<LunchRegisterEmployee> findById(Long id) {
        return this.lunchRegisterEmployeeRepository.findById(id);
    }

    public void delete(Long id) {
        this.lunchRegisterEmployeeRepository.deleteById(id);
    }
}
