

package com.liaqaty.liaqaty.service;
import com.liaqaty.liaqaty.DTO.ProgressDTO;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.liaqaty.liaqaty.entity.WorkoutLog;
import com.liaqaty.liaqaty.repository.WorkoutLogRepository;

@Service
public class ProgressService {

    private final WorkoutLogRepository workoutLogRepository;

    public ProgressService(WorkoutLogRepository workoutLogRepository) {
        this.workoutLogRepository = workoutLogRepository;
    }

    // Get all workout logs belonging to a user
    public List<WorkoutLog> getUserLogs(Integer userId) {
        return workoutLogRepository
                .findByUser_UserIdOrderByCompletionDateDesc(userId);
    }

    // Calculate the total workout minutes
    public int getTotalMinutes(Integer userId) {

        List<WorkoutLog> logs = getUserLogs(userId);

        int totalMinutes = 0;

        for (WorkoutLog log : logs) {
            totalMinutes += log.getDurationMinutes();
        }

        return totalMinutes;
    }

    // Calculate the minutes remaining until the next milestone
    public int getRemainingMinutes(Integer userId) {

        int totalMinutes = getTotalMinutes(userId);

        return 40 - (totalMinutes % 40);
    }

    // Calculate progress toward the next 40-minute milestone
    public int getMilestoneProgress(Integer userId) {

        int totalMinutes = getTotalMinutes(userId);

        return (totalMinutes % 40) * 100 / 40;
    }

    // Calculate the current consecutive workout-day streak
    public int getCurrentStreak(Integer userId) {

        List<WorkoutLog> logs = getUserLogs(userId);

        Set<LocalDate> workoutDays = new HashSet<>();

        for (WorkoutLog log : logs) {
            workoutDays.add(log.getCompletionDate().toLocalDate());
        }

        if (workoutDays.isEmpty()) {
            return 0;
        }

        LocalDate latestDay = workoutDays.stream()
                .max(LocalDate::compareTo)
                .get();

        LocalDate today = LocalDate.now();

        // A streak is still current if the latest workout was today or yesterday
        if (latestDay.isBefore(today.minusDays(1))) {
            return 0;
        }

        int streak = 0;
        LocalDate checkDay = latestDay;

        while (workoutDays.contains(checkDay)) {
            streak++;
            checkDay = checkDay.minusDays(1);
        }

        return streak;
    }
    public ProgressDTO getUserProgress(Integer userId) {

        int totalMinutes = getTotalMinutes(userId);
        int remainingMinutes = getRemainingMinutes(userId);
        double milestoneProgress = getMilestoneProgress(userId);
        int currentStreak = getCurrentStreak(userId);

        // Temporary values until badge implementation is integrated
        int totalPoints = 0;
        int earnedBadges = 0;

        return new ProgressDTO(
                totalMinutes,
                remainingMinutes,
                milestoneProgress,
                currentStreak,
                totalPoints,
                earnedBadges
        );
    }}
