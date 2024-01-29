package com.example.tasksgradesapp.model;

public class SubjectData {
    private String subjectName;
    private double averageGrade;
    private int count;

    public SubjectData(String subjectName, double averageGrade, int count) {
        this.subjectName = subjectName;
        this.averageGrade = averageGrade;
        this.count = count;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

