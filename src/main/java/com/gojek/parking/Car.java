package com.gojek.parking;

/**
 * The basic car object for the parking lot system
 */
public class Car {
    /* Registration number for car */
    private String registrationNumber = null;

    /* Car colour */
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

    /**
     * Overridden toString method, this prints the registration number
     * and colour of car.
     */
    @Override
    public String toString() {
        return "Car [registrationNumber=" + registrationNumber + ", colour="+ colour + "]";
    }
}
