package com.liaqaty.liaqaty.controller;

import com.liaqaty.liaqaty.entity.Workout;
import com.liaqaty.liaqaty.entity.WorkoutLog;
import com.liaqaty.liaqaty.service.WorkoutService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {

    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    // Get all workouts
    @GetMapping
    public List<Workout> getAllWorkouts() {
        return workoutService.getAllWorkouts();
    }

    // Get user's workout history
    @GetMapping("/history/{userId}")
    public List<WorkoutLog> getUserWorkoutHistory(
            @PathVariable Integer userId) {
        return workoutService.getUserWorkoutHistory(userId);
    }

    // Save a workout log
    @PostMapping("/diary")
    public WorkoutLog saveWorkoutLog(
            @RequestParam Integer userId,
            @RequestParam Integer workoutId,
            @RequestParam Integer durationMinutes) {

        return workoutService.saveWorkoutLog(
                userId, workoutId, durationMinutes);
    }
}