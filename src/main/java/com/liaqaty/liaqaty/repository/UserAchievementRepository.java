
package com.liaqaty.liaqaty.repository;

import com.liaqaty.liaqaty.entity.UserAchievement;
import com.liaqaty.liaqaty.entity.UserAchievementId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAchievementRepository extends JpaRepository<UserAchievement, UserAchievementId> {
}
