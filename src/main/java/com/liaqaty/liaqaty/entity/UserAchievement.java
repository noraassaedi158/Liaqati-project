package com.liaqaty.liaqaty.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_achievements")
@IdClass(UserAchievementId.class)
public class UserAchievement {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "achievement_id")
    private Achievement achievement;

    @Column(name = "times_earned")
    private Integer timesEarned;

    @Column(name = "total_points")
    private Integer totalPoints;

    @Column(name = "first_earned_at")
    private LocalDateTime firstEarnedAt;

    @Column(name = "last_earned_at")
    private LocalDateTime lastEarnedAt;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Achievement getAchievement() {
		return achievement;
	}

	public void setAchievement(Achievement achievement) {
		this.achievement = achievement;
	}

	public Integer getTimesEarned() {
		return timesEarned;
	}

	public void setTimesEarned(Integer timesEarned) {
		this.timesEarned = timesEarned;
	}

	public Integer getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(Integer totalPoints) {
		this.totalPoints = totalPoints;
	}

	public LocalDateTime getFirstEarnedAt() {
		return firstEarnedAt;
	}

	public void setFirstEarnedAt(LocalDateTime firstEarnedAt) {
		this.firstEarnedAt = firstEarnedAt;
	}

	public LocalDateTime getLastEarnedAt() {
		return lastEarnedAt;
	}

	public void setLastEarnedAt(LocalDateTime lastEarnedAt) {
		this.lastEarnedAt = lastEarnedAt;
	}
    
}