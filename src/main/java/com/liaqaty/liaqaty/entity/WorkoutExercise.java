package com.liaqaty.liaqaty.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "workout_exercises")
@IdClass(WorkoutExerciseId.class)
public class WorkoutExercise {

    @Id
    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;

    @Id
    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

	public Workout getWorkout() {
		return workout;
	}

	public void setWorkout(Workout workout) {
		this.workout = workout;
	}

	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}
    
}