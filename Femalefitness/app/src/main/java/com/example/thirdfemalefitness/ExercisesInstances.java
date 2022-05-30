package com.example.thirdfemalefitness;

public class ExercisesInstances {
    private String[] exerciseName;
    private int[] exercisesImages;

    public void setExerciseName(String ... exerciseName) {
        this.exerciseName = exerciseName;
    }

    public int[] getExercisesImages() {
        return exercisesImages;
    }

    public void setExercisesImages(int ... exercisesImages) {
        this.exercisesImages = exercisesImages;
    }

    public String[] getExercisesName() {
        return exerciseName;
    }
}
