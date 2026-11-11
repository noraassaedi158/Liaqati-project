package com.liaqaty.liaqaty.service;

import com.liaqaty.liaqaty.entity.Workout;
import com.liaqaty.liaqaty.entity.WorkoutLog;
import com.liaqaty.liaqaty.repository.WorkoutRepository;
import com.liaqaty.liaqaty.repository.WorkoutLogRepository;
import com.liaqaty.liaqaty.entity.User;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import java.util.List;
/*Service tells Spring that it should manage this  Service, MEANING when we call it in Workout controller, Spring would make
an object of it on its own, and inject the dependencies */
@Service
public class WorkoutService {
    private final WorkoutRepository workoutRepository;
    private final WorkoutLogRepository workoutLogRepository;
    public WorkoutService(WorkoutRepository workoutRepository,
                          WorkoutLogRepository workoutLogRepository) {
        this.workoutRepository = workoutRepository;
        this.workoutLogRepository = workoutLogRepository;
    }

    // Get all available workouts
    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    // Get user's workout history
    public List<WorkoutLog> getUserWorkoutHistory(Integer userId) {
        return workoutLogRepository
            .findByUser_UserIdOrderByCompletionDateDesc(userId);
    }
 // Save a new workout log
    public WorkoutLog saveWorkoutLog(Integer userId,
                                     Integer workoutId,
                                     Integer durationMinutes) {

        User user = new User();
        user.setUserId(userId);

        Workout workout = workoutRepository.findById(workoutId)
                .orElseThrow(() -> new RuntimeException("Workout not found"));

        WorkoutLog log = new WorkoutLog();
        log.setUser(user);
        log.setWorkout(workout);
        log.setCompletionDate(LocalDateTime.now());
        log.setDurationMinutes(durationMinutes);

        return workoutLogRepository.save(log);
    }
}
