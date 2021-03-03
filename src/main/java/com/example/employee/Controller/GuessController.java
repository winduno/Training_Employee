package com.example.employee.Controller;


import com.example.employee.Model.Guess;
import com.example.employee.Service.Guess.IGuessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/guess")
public class GuessController {

    @Autowired
    private IGuessService guessService;

    @GetMapping
    public ResponseEntity<Iterable<Guess>> getAllGuess(){
        return new ResponseEntity<>(this.guessService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guess> getGuessById(@PathVariable(name = "id") Long id){
        Optional<Guess> optionalGuess = this.guessService.findById(id);
        return optionalGuess.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Guess> addGuess(@RequestBody Guess guess){
        return new ResponseEntity<>(this.guessService.save(guess), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Guess> deleteGuessById(@PathVariable(name = "id") Long id){
        Optional<Guess> optionalGuess = this.guessService.findById(id);
        if (optionalGuess.isPresent()){
            this.guessService.delete(id);
            return new ResponseEntity<>( HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
