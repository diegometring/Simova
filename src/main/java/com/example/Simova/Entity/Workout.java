package com.example.Simova.Entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;


@Table(name = "Workout")
@Entity
public class Workout implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private Integer reps;
    private Integer sets;
    private Integer weight;
    private Integer numWorkout;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "Workout", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkoutExercise> workoutExercise;

    public Workout(Integer id, Integer reps, Integer sets, Integer weight, Integer numWorkout, User user, List<WorkoutExercise> workoutExercise) {
        this.id = id;
        this.reps = reps;
        this.sets = sets;
        this.weight = weight;
        this.numWorkout = numWorkout;
        this.user = user;
        this.workoutExercise = workoutExercise;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReps() {
        return reps;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }

    public Integer getSets() {
        return sets;
    }

    public void setSets(Integer sets) {
        this.sets = sets;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getNumWorkout() {
        return numWorkout;
    }

    public void setNumWorkout(Integer numWorkout) {
        this.numWorkout = numWorkout;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<WorkoutExercise> getWorkoutExercise() {
        return workoutExercise;
    }

    public void setWorkoutExercise(List<WorkoutExercise> workoutExercise) {
        this.workoutExercise = workoutExercise;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Workout workout = (Workout) o;
        return Objects.equals(id, workout.id) && Objects.equals(reps, workout.reps) && Objects.equals(sets, workout.sets) && Objects.equals(weight, workout.weight) && Objects.equals(numWorkout, workout.numWorkout) && Objects.equals(user, workout.user) && Objects.equals(workoutExercise, workout.workoutExercise);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reps, sets, weight, numWorkout, user, workoutExercise);
    }
}

