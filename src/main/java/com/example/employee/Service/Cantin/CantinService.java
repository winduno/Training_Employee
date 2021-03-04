package com.example.employee.Service.Cantin;

import com.example.employee.Model.Cantin;
import com.example.employee.Repository.CantinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CantinService implements ICantinService{

    @Autowired
    private CantinRepository cantinRepository;

    @Override
    public List<Cantin> getAll() {
        return this.cantinRepository.findAll();
    }

    @Override
    public void save(Cantin cantin) {
        this.cantinRepository.save(cantin);
    }

    @Override
    public Optional<Cantin> findById(Long id) {
        return this.cantinRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        this.cantinRepository.deleteById(id);
    }
}
