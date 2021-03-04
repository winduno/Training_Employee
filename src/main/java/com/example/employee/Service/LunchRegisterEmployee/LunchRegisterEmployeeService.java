package com.example.employee.Service.LunchRegisterEmployee;

import com.example.employee.Model.LunchRegisterEmployee;
import com.example.employee.Repository.LunchRegisterEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LunchRegisterEmployeeService implements ILunchRegisterEmployeeService{

    @Autowired
    private LunchRegisterEmployeeRepository lunchRegisterEmployeeRepository;

    @Override
    public List<LunchRegisterEmployee> getAll() {
        return this.lunchRegisterEmployeeRepository.findAll();
    }

    @Override
    public void save(LunchRegisterEmployee lunchRegisterEmployee) {
        this.lunchRegisterEmployeeRepository.save(lunchRegisterEmployee);
    }

    @Override
    public Optional<LunchRegisterEmployee> findById(Long id) {
        return this.lunchRegisterEmployeeRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        this.lunchRegisterEmployeeRepository.deleteById(id);
    }
}
