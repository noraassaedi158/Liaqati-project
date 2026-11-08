package com.liaqaty.liaqaty.entity;

import java.io.Serializable;
import java.util.Objects;

public class UserAchievementId implements Serializable {

    private Integer user;
    private Integer achievement;

    public UserAchievementId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAchievementId)) return false;
        UserAchievementId that = (UserAchievementId) o;
        return Objects.equals(user, that.user)
                && Objects.equals(achievement, that.achievement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, achievement);
    }
}