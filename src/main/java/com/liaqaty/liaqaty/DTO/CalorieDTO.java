
package com.liaqaty.liaqaty.DTO;

public class CalorieDTO {

    private int age;
    private String gender;
    private double weight;
    private double height;
    private double activityLevel;
    private double estimatedCalories;

    public CalorieDTO() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(double activityLevel) {
        this.activityLevel = activityLevel;
    }

    public double getEstimatedCalories() {
        return estimatedCalories;
    }

    public void setEstimatedCalories(double estimatedCalories) {
        this.estimatedCalories = estimatedCalories;
    }
}
