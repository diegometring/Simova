package com.example.Simova.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Table(name = "WorkoutExercise")
@Entity
public class WorkoutExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exerciseId", nullable = false)
    private Exercise exercise;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workoutId", nullable = false)
    private Workout workout;

    public WorkoutExercise(Integer id, Exercise exercise, Workout workout) {
        this.id = id;
        this.exercise = exercise;
        this.workout = workout;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        WorkoutExercise that = (WorkoutExercise) o;
        return Objects.equals(id, that.id) && Objects.equals(exercise, that.exercise) && Objects.equals(workout, that.workout);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, exercise, workout);
    }
}
