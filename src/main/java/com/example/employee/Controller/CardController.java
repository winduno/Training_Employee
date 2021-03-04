package com.example.employee.Controller;

import com.example.employee.Model.Card;
import com.example.employee.Service.Card.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/card")
public class CardController {

    @Autowired
    private ICardService cardService;

    @GetMapping
    public ResponseEntity<Iterable<Card>> getAllCard() {
        return new ResponseEntity<>(this.cardService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable(name = "id") Long id) {
        Optional<Card> optionalCard = this.cardService.findById(id);
        return optionalCard.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Card> addCard(@RequestBody Card card) {
        this.cardService.save(card);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Card> deleteCardById(@PathVariable(name = "id") Long id) {
        Optional<Card> optionalCard = this.cardService.findById(id);
        if (optionalCard.isPresent()) {
            this.cardService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
