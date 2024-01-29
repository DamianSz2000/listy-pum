package com.example.tasksgradesapp.model;

import java.io.Serializable;
import java.util.List;

public class ExerciseList implements Serializable {
    private List<Exercise> exercises;
    private Subject subject;
    private double grade;

    public ExerciseList(List<Exercise> exercises, Subject subject, double grade) {
        this.exercises = exercises;
        this.subject = subject;
        this.grade = grade;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "ExerciseList{" +
                "exercises=" + exercises +
                ", subject=" + subject +
                ", grade=" + grade +
                '}';
    }

}

