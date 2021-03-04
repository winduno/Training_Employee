package com.example.employee.Controller;

import com.example.employee.Model.Cantin;
import com.example.employee.Service.Cantin.ICantinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/cantin")
public class CantinController {

    @Autowired
    private ICantinService cantinService;

    @GetMapping
    public ResponseEntity<Iterable<Cantin>> getAllCantin() {
        return new ResponseEntity<>(this.cantinService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cantin> getCantinById(@PathVariable(name = "id") Long id) {
        Optional<Cantin> optionalCantin = this.cantinService.findById(id);
        return optionalCantin.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Cantin> addCantin(@RequestBody Cantin cantin) {
        this.cantinService.save(cantin);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cantin> deleteCantinById(@PathVariable(name = "id") Long id) {
        Optional<Cantin> optionalCantin = this.cantinService.findById(id);
        if (optionalCantin.isPresent()) {
            this.cantinService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
