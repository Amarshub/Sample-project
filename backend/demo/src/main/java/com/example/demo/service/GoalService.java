package com.example.demo.service;

import com.example.demo.model.Goal;
import com.example.demo.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoalService {

    @Autowired
    private GoalRepository goalRepository;

    public List<Goal> getAllGoals() {
        return goalRepository.findAll();
    }

    public Optional<Goal> getGoalById(Long id) {
        return goalRepository.findById(id);
    }

    public Goal createGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    public Goal updateGoal(Long id, Goal goalDetails) {
        return goalRepository.findById(id)
                .map(goal -> {
                    goal.setDescription(goalDetails.getDescription());
                    goal.setTargetDate(goalDetails.getTargetDate());
                    return goalRepository.save(goal);
                })
                .orElseThrow(() -> new RuntimeException("Goal not found with id " + id));
    }

    public void deleteGoal(Long id) {
        goalRepository.deleteById(id);
    }
}
