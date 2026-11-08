
package com.liaqaty.liaqaty.repository;

import com.liaqaty.liaqaty.entity.WorkoutExercise;
import com.liaqaty.liaqaty.entity.WorkoutExerciseId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutExerciseRepository extends JpaRepository<WorkoutExercise, WorkoutExerciseId> {
}
