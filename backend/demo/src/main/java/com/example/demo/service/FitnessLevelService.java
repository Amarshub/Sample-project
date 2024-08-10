package com.example.demo.service;

import com.example.demo.model.FitnessLevel;
import com.example.demo.repository.FitnessLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FitnessLevelService {

    @Autowired
    private FitnessLevelRepository repository;

    public List<FitnessLevel> getAllFitnessLevels() {
        return repository.findAll();
    }

    public Optional<FitnessLevel> getFitnessLevelById(Long id) {
        return repository.findById(id);
    }

    public FitnessLevel createFitnessLevel(FitnessLevel fitnessLevel) {
        return repository.save(fitnessLevel);
    }

    public FitnessLevel updateFitnessLevel(Long id, FitnessLevel fitnessLevel) {
        Optional<FitnessLevel> existingFitnessLevel = repository.findById(id);
        if (existingFitnessLevel.isPresent()) {
            FitnessLevel updatedFitnessLevel = existingFitnessLevel.get();
            updatedFitnessLevel.setName(fitnessLevel.getName());
            updatedFitnessLevel.setDescription(fitnessLevel.getDescription());
            return repository.save(updatedFitnessLevel);
        } else {
            throw new RuntimeException("Fitness Level not found");
        }
    }

    public void deleteFitnessLevel(Long id) {
        repository.deleteById(id);
    }
}
