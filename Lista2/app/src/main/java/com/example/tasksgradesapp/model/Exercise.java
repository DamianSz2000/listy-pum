package com.example.tasksgradesapp.model;

public class Exercise {
    private String content;
    private int points;

    public Exercise(String content, int points) {
        this.content = content;
        this.points = points;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}

