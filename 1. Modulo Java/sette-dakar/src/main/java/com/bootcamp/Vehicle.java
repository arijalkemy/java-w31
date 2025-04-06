package com.bootcamp;

public abstract class Vehicle {
    private Double speed;
    private Double acceleration;
    private Double turningAngle;
    private String patent;
    private Double weight;
    private Integer wheels;

    public Vehicle(Double speed, Double acceleration, Double turningAngle, String patent, Double weight, Integer wheels) {
        this.speed = speed;
        this.acceleration = acceleration;
        this.turningAngle = turningAngle;
        this.patent = patent;
        this.weight = weight;
        this.wheels = wheels;
    }

    public Double getSpeed() {
        return speed;
    }

    public Double getAcceleration() {
        return acceleration;
    }

    public Double getTurningAngle() {
        return turningAngle;
    }

    public String getPatent() {
        return patent;
    }

    public Double getWeight() {
        return weight;
    }

    public Integer getWheels() {
        return wheels;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public void setAcceleration(Double acceleration) {
        this.acceleration = acceleration;
    }

    public void setTurningAngle(Double turningAngle) {
        this.turningAngle = turningAngle;
    }

    public void setPatent(String patent) {
        this.patent = patent;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setWheels(Integer wheels) {
        this.wheels = wheels;
    }

    @Override
    public String toString() {
        return "\n\tVehicle:" +
                "\n\t\tspeed=" + speed +
                "\n\t\tacceleration= " + acceleration +
                "\n\t\tturning Angle= " + turningAngle +
                "\n\t\tpatent= " + patent +
                "\n\t\tweight= " + weight +
                "\n\t\twheels= " + wheels;
    }
}
