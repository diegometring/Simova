package com.example.Simova.Repository;

import com.example.Simova.Entity.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<Workout, Integer> {

}
