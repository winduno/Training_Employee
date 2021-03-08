package com.example.employee.Service.Guess;

import com.example.employee.Model.Guess;
import com.example.employee.Repository.GuessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuessService {

    @Autowired
    private GuessRepository guessRepository;

    public List<Guess> getAll() {
        return this.guessRepository.findAll();
    }

    public void save(Guess guess) {
        this.guessRepository.save(guess);
    }

    public Optional<Guess> findById(Long id) {
        return this.guessRepository.findById(id);
    }

    public void delete(Long id) {
        this.guessRepository.deleteById(id);
    }
}
