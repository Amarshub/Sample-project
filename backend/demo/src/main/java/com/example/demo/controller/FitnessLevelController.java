package com.example.demo.controller;

import com.example.demo.model.FitnessLevel;
import com.example.demo.service.FitnessLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fitness-levels")
public class FitnessLevelController {

    @Autowired
    private FitnessLevelService service;

    @GetMapping
    public List<FitnessLevel> getAllFitnessLevels() {
        return service.getAllFitnessLevels();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FitnessLevel> getFitnessLevelById(@PathVariable Long id) {
        Optional<FitnessLevel> fitnessLevel = service.getFitnessLevelById(id);
        if (fitnessLevel.isPresent()) {
            return ResponseEntity.ok(fitnessLevel.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public FitnessLevel createFitnessLevel(@RequestBody FitnessLevel fitnessLevel) {
        return service.createFitnessLevel(fitnessLevel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FitnessLevel> updateFitnessLevel(@PathVariable Long id, @RequestBody FitnessLevel fitnessLevel) {
        try {
            FitnessLevel updatedFitnessLevel = service.updateFitnessLevel(id, fitnessLevel);
            return ResponseEntity.ok(updatedFitnessLevel);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFitnessLevel(@PathVariable Long id) {
        service.deleteFitnessLevel(id);
        return ResponseEntity.noContent().build();
    }
}
