package com.example.tasksgradesapp.controller;

import androidx.lifecycle.ViewModel;

import com.example.tasksgradesapp.model.ExerciseList;

import java.util.List;

public class SharedViewModel extends ViewModel {
    private List<ExerciseList> exerciseLists;

    public List<ExerciseList> getExerciseLists() {
        return exerciseLists;
    }

    public void setExerciseLists(List<ExerciseList> exerciseLists) {
        this.exerciseLists = exerciseLists;
    }
}

