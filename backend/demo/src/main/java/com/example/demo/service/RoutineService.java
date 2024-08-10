package com.example.demo.service;

import com.example.demo.model.Routine;
import com.example.demo.repository.RoutineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoutineService {

    @Autowired
    private RoutineRepository routineRepository;

    public List<Routine> getAllRoutines() {
        return routineRepository.findAll();
    }

    public Optional<Routine> getRoutineById(Long id) {
        return routineRepository.findById(id);
    }

    public Routine createRoutine(Routine routine) {
        return routineRepository.save(routine);
    }

    public Routine updateRoutine(Long id, Routine routineDetails) {
        return routineRepository.findById(id)
                .map(routine -> {
                    routine.setName(routineDetails.getName());
                    routine.setDescription(routineDetails.getDescription());
                    return routineRepository.save(routine);
                })
                .orElseThrow(() -> new RuntimeException("Routine not found with id " + id));
    }

    public void deleteRoutine(Long id) {
        routineRepository.deleteById(id);
    }
}
