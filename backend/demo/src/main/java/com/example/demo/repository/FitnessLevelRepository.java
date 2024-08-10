package com.example.demo.repository;

import com.example.demo.model.FitnessLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FitnessLevelRepository extends JpaRepository<FitnessLevel, Long> {
}
