package com.example.tasksgradesapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataGenerator {

    private static String generateLoremIpsum(Random random) {
        String loremIpsumBase = "Lorem ipsum dolor sit amet";
        String loremIpsumExtended = ", consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";

        int endIndex = random.nextInt(loremIpsumExtended.length());
        return loremIpsumBase + loremIpsumExtended.substring(0, endIndex);
    }

    public static List<ExerciseList> generateData() {
        List<ExerciseList> exerciseLists = new ArrayList<>();
        String[] subjects = {"Mathematics", "PUM", "Physics", "Electronics", "Algorithms"};
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            int numExercises = random.nextInt(10) + 1;
            List<Exercise> exercises = new ArrayList<>();
            for (int j = 0; j < numExercises; j++) {
                exercises.add(new Exercise(generateLoremIpsum(random), random.nextInt(10) + 1));
            }

            Subject subject = new Subject(subjects[random.nextInt(subjects.length)]);
            double grade = 3.0 + (random.nextInt(5) * 0.5);

            exerciseLists.add(new ExerciseList(exercises, subject, grade));
        }

        return exerciseLists;
    }
}
