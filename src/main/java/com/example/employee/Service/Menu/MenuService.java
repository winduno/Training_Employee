package com.example.employee.Service.Menu;

import com.example.employee.Model.Dish;
import com.example.employee.Model.Menu;
import com.example.employee.Repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> getAll() {
        return this.menuRepository.getAll();
    }

    public void save(Menu menu) {
        if (menu.getDate() == null){
            menu.setDate(new Date());
        }
        this.menuRepository.save(menu);
    }

    public Optional<Menu> findById(Long id) {
        return this.menuRepository.findById(id);
    }

    public void delete(Long id) {
        this.menuRepository.deleteById(id);
    }

    public void updateMenuDate(Menu menu){
        Date date = menu.getDate();
        Long id = menu.getId();
        this.menuRepository.editDateOfMenu(id, date);
    }

    public void addDishInMenu(Long idMenu, List<Dish> dishes){
        for (Dish dish : dishes) {
            this.menuRepository.insertDishIntoMenu(idMenu, dish.getId());
        }
    }
}
