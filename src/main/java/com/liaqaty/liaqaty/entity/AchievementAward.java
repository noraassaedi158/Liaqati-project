
package com.liaqaty.liaqaty.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "achievement_awards")
public class AchievementAward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "award_id")
    private Integer awardId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "achievement_id")
    private Achievement achievement;

    @Column(name = "milestone_value")
    private Integer milestoneValue;

    @Column(name = "event_key")
    private String eventKey;

    @Column(name = "earned_at")
    private LocalDateTime earnedAt;

	public Integer getAwardId() {
		return awardId;
	}

	public void setAwardId(Integer awardId) {
		this.awardId = awardId;
	}

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

	public Integer getMilestoneValue() {
		return milestoneValue;
	}

	public void setMilestoneValue(Integer milestoneValue) {
		this.milestoneValue = milestoneValue;
	}

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public LocalDateTime getEarnedAt() {
		return earnedAt;
	}

	public void setEarnedAt(LocalDateTime earnedAt) {
		this.earnedAt = earnedAt;
	}
    
}
