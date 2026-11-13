
package com.liaqaty.liaqaty.DTO;

public class ProgressDTO {

    private int totalMinutes;
    private int remainingMinutes;
    private double milestoneProgress;
    private int currentStreak;

    private int totalPoints;
    private int earnedBadges;

   
    public ProgressDTO(
            int totalMinutes,
            int remainingMinutes,
            double milestoneProgress,
            int currentStreak,
            int totalPoints,
            int earnedBadges) {

        this.totalMinutes = totalMinutes;
        this.remainingMinutes = remainingMinutes;
        this.milestoneProgress = milestoneProgress;
        this.currentStreak = currentStreak;
        this.totalPoints = totalPoints;
        this.earnedBadges = earnedBadges;
    }
    
    
    public int getTotalMinutes() {
        return totalMinutes;
    }

    public int getRemainingMinutes() {
        return remainingMinutes;
    }

    public double getMilestoneProgress() {
        return milestoneProgress;
    }

    public int getCurrentStreak() {
        return currentStreak;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public int getEarnedBadges() {
        return earnedBadges;
    }
    
}
