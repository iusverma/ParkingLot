package com.gojek.parking;

public class Car {
    private String registrationNumber = null;

    private String colour = null;

    public Car(String regNum, String colour){
        this.registrationNumber = regNum;
        this.colour = colour;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Car [registrationNumber=" + registrationNumber + ", colour="+ colour + "]";
    }
}
