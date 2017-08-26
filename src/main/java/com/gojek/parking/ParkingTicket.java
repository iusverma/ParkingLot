package com.gojek.parking;

public class ParkingTicket {
    private Car car;
    private int slotNumber;
    
    public ParkingTicket(Car car, int slot){
        this.car = car;
        this.slotNumber = slot;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }
}
