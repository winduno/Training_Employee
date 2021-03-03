package com.example.employee.Service.Dish;

import com.example.employee.Model.Dish;
import com.example.employee.Repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DishService implements IDishService{

    @Autowired
    private DishRepository dishRepository;

    @Override
    public Iterable<Dish> getAll() {
        return this.dishRepository.findAll();
    }

    @Override
    public Dish save(Dish dish) {
        return this.dishRepository.save(dish);
    }

    @Override
    public Optional<Dish> findById(Long id) {
        return this.dishRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        this.dishRepository.deleteById(id);
    }
}
