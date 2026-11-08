package com.liaqaty.liaqaty.repository;

import com.liaqaty.liaqaty.entity.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<Workout, Integer> {
}
