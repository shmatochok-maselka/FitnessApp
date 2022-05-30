package com.example.thirdfemalefitness;

public class DataWCategories {
    String workoutName;
    String workoutTime;
    String workoutLevel;
    int img;

    public DataWCategories() {

    }

    public DataWCategories(String workoutName, String workoutTime, String workoutLevel, int img) {
        this.workoutName = workoutName;
        this.workoutTime = workoutTime;
        this.workoutLevel = workoutLevel;
        this.img = img;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public String getWorkoutTime() {
        return workoutTime;
    }

    public void setWorkoutTime(String workoutTime) {
        this.workoutTime = workoutTime;
    }

    public String getWorkoutLevel() {
        return workoutLevel;
    }

    public void setWorkoutLevel(String workoutLevel) {
        this.workoutLevel = workoutLevel;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
