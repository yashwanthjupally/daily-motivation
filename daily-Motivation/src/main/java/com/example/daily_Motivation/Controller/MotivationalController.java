package com.example.daily_Motivation.Controller;

import com.example.daily_Motivation.Entity.Motivational;
import com.example.daily_Motivation.Service.MotivationalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class MotivationalController {

    @Autowired
    private MotivationalService motivationalService;

    @GetMapping("/motivationals/daily")
    public ResponseEntity<?> getDaily() {
        Optional<Motivational> motivational = motivationalService.getDaily();
        Map<String, Object> response = new HashMap<>();
        if (motivational.isPresent()) {
            response.put("status", 200);
            response.put("data", motivational.get());
        } else {
            response.put("status", 404);
            response.put("data", null);
        }
        return ResponseEntity.ok(response);
    }
}
