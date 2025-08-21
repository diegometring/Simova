package com.example.Simova.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Table(name = "Exercise")
@Entity
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String image;
    private String description;

    private Exercise(Long id, String name, String image, String description) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
    }

    @OneToMany(mappedBy = "Exercise", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkoutExercise> workoutExercises;

    private Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private String getImage() {
        return image;
    }

    private void setImage(String image) {
        this.image = image;
    }

    private String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Exercise exercise = (Exercise) o;
        return Objects.equals(id, exercise.id) && Objects.equals(name, exercise.name) && Objects.equals(image, exercise.image) && Objects.equals(description, exercise.description) && Objects.equals(workoutExercises, exercise.workoutExercises);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, image, description, workoutExercises);
    }
}
