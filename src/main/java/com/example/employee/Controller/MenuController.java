package com.example.employee.Controller;

import com.example.employee.Model.Building;
import com.example.employee.Model.Dish;
import com.example.employee.Model.Menu;
import com.example.employee.Repository.MenuRepository;
import com.example.employee.Service.Dish.DishService;
import com.example.employee.Service.Menu.IMenuService;
import com.example.employee.Service.Menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.SimpleFormatter;

@Controller
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private DishService dishService;

    @GetMapping
    public ResponseEntity<Iterable<Menu>> getAllMenu() {
        return new ResponseEntity<>(this.menuService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> getMenuById(@PathVariable(name = "id") Long id) {
        Optional<Menu> optionalMenu = this.menuService.findById(id);
        if (optionalMenu.isPresent()){
            Menu returnMenu = optionalMenu.get();
            returnMenu.setDish(this.dishService.getDishesByMenuId(returnMenu.getId()));
            return new ResponseEntity<>(returnMenu, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Menu> getBuildingById(@PathVariable(name = "id") Long id) {
//        Optional<Menu> optionalMenu = this.menuService.findById(id);
//        return optionalMenu.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }

    @PostMapping
    public ResponseEntity<Menu> addMenu(@RequestBody Menu menu) {
        this.menuService.save(menu);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Menu> deleteMenuById(@PathVariable(name = "id") Long id) {
        Optional<Menu> optionalMenu = this.menuService.findById(id);
        if (optionalMenu.isPresent()) {
            this.menuService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @PostMapping("/{id}")
//    public ResponseEntity<Menu> addDishIntoMenu(@PathVariable(name = "id") Long id, @RequestBody List<Dish> dishes){
//        this.menuService.addDishInMenu(id, dishes);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @PostMapping("/{id}")
    public ResponseEntity<Menu> updateMenuDate(@PathVariable(name = "id") Long id, @RequestBody Menu menu){
        Optional<Menu> optionalMenu = this.menuService.findById(id);
        if (optionalMenu.isPresent()){
            Menu saveMenu = optionalMenu.get();
            saveMenu.setDate(menu.getDate());
            this.menuService.updateMenuDate(saveMenu);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
