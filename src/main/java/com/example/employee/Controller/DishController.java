package com.example.employee.Controller;

import com.example.employee.Model.Dish;
import com.example.employee.Service.Dish.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("api/dish")
public class DishController {

    @Autowired
    private IDishService dishService;

    @GetMapping
    public ResponseEntity<Iterable<Dish>> getAllDish(){
        return new ResponseEntity<>(this.dishService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dish> getDishById(@PathVariable(name = "id") Long id){
        Optional<Dish> optionalDish = this.dishService.findById(id);
        return optionalDish.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Dish> addDish(@RequestBody Dish dish){
        return new ResponseEntity<>(this.dishService.save(dish), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Dish> deleteDishById(@PathVariable(name = "id") Long id){
        Optional<Dish> optionalDish = this.dishService.findById(id);
        if (optionalDish.isPresent()){
            this.dishService.delete(id);
            return new ResponseEntity<>( HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
