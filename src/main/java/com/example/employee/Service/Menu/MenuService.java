package com.example.employee.Service.Menu;

import com.example.employee.Model.Menu;
import com.example.employee.Repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuService implements IMenuService{

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public Iterable<Menu> getAll() {
        return this.menuRepository.findAll();
    }

    @Override
    public Menu save(Menu menu) {
        return this.menuRepository.save(menu);
    }

    @Override
    public Optional<Menu> findById(Long id) {
        return this.menuRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        this.menuRepository.deleteById(id);
    }
}
