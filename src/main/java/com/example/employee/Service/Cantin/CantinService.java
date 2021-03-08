package com.example.employee.Service.Cantin;

import com.example.employee.Model.Cantin;
import com.example.employee.Model.DTO.CantinObj;
import com.example.employee.Repository.CantinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CantinService {

    @Autowired
    private CantinRepository cantinRepository;

    public List<CantinObj> getAll() {
        return this.cantinRepository.getAllCantinCustom();
    }

    public void save(Cantin cantin) {
        this.cantinRepository.save(cantin.getChefs(), cantin.getIncome(), cantin.getOutcome(), cantin.getBuilding().getId());
    }

    public Optional<Cantin> findById(Long id) {
        return this.cantinRepository.findById(id);
    }

    public void delete(Long id) {
        this.cantinRepository.deleteById(id);
    }
}
