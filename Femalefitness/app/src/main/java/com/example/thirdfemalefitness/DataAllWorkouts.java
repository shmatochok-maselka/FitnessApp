package com.example.thirdfemalefitness;

public class DataAllWorkouts {
    String workoutName;
    String time;
    int img;

    public DataAllWorkouts() {

    }

    public DataAllWorkouts(String workoutName, String time, int img) {
        this.workoutName = workoutName;
        this.time = time;
        this.img = img;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public String getTime() {
        return time + " min";
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
