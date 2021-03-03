package com.example.employee.Controller;

import com.example.employee.Model.Menu;
import com.example.employee.Model.Menu;
import com.example.employee.Service.Menu.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @GetMapping
    public ResponseEntity<Iterable<Menu>> getAllMenu(){
        return new ResponseEntity<>(this.menuService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> getMenuById(@PathVariable(name = "id") Long id){
        Optional<Menu> optionalMenu = this.menuService.findById(id);
        return optionalMenu.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Menu> addMenu(@RequestBody Menu menu){
        return new ResponseEntity<>(this.menuService.save(menu), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Menu> deleteMenuById(@PathVariable(name = "id") Long id){
        Optional<Menu> optionalMenu = this.menuService.findById(id);
        if (optionalMenu.isPresent()){
            this.menuService.delete(id);
            return new ResponseEntity<>( HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
