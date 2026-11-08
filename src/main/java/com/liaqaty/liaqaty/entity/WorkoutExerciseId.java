package com.liaqaty.liaqaty.entity;

import java.io.Serializable;
import java.util.Objects;

public class WorkoutExerciseId implements Serializable {

    private Integer workout;
    private Integer exercise;

    public WorkoutExerciseId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkoutExerciseId)) return false;
        WorkoutExerciseId that = (WorkoutExerciseId) o;
        return Objects.equals(workout, that.workout)
                && Objects.equals(exercise, that.exercise);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workout, exercise);
    }
}