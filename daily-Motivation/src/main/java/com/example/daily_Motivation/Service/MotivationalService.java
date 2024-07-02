package com.example.daily_Motivation.Service;

import com.example.daily_Motivation.Entity.Motivational;
import com.example.daily_Motivation.Repository.MotivationalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class MotivationalService {

    @Autowired
    private MotivationalRepository motivationalRepository;

    public Optional<Motivational> getDaily() {
        List<Motivational> allMotives = motivationalRepository.findAll();
        if (allMotives.isEmpty()) {
            return Optional.empty();
        }
        Random random = new Random();
        int randomIndex = random.nextInt(allMotives.size());
        return Optional.of(allMotives.get(randomIndex));
    }

    public List<Motivational> getAllMotives() {
        return motivationalRepository.findAll();
    }

    public Motivational save(Motivational motivational) {
        return motivationalRepository.save(motivational);
    }
}
