package com.example.employee.Service.Card;

import com.example.employee.Model.Card;
import com.example.employee.Repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public List<Card> getAll() {
        return this.cardRepository.findAll();
    }

    public void save(Card card) {
        this.cardRepository.save(card);
    }

    public Optional<Card> findById(Long id) {
        return this.cardRepository.findById(id);
    }

    public void delete(Long id) {
        this.cardRepository.deleteById(id);
    }
}
