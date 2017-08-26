package com.gojek.parking;

public class ParkingLot {
    private static ParkingLot parkingLot;
    private static Car[] parkingSlots;
    
    private ParkingLot(int numberOfSlots){
        parkingSlots = new Car[numberOfSlots];
        for (int i = 0; i < numberOfSlots; i++) {
            parkingSlots[i] = null;
        }
    }

    public static ParkingLot createParkingSlots(int numberOfSlots){
        if(parkingLot == null){
            synchronized (ParkingLot.class) {
                parkingLot = new ParkingLot(numberOfSlots);
            }
        }        
        return parkingLot;
    }
    
    public static ParkingLot getParkingLot(){
        return parkingLot;
    }
    
    public ParkingTicket park(Car car){
        ParkingTicket ticket = null;
        for (int i = 0; i < parkingSlots.length; i++) {
            if(parkingSlots[i] == null){
                ticket = new ParkingTicket(car, i+1);
                parkingSlots[i] = car;
                break;
            }
        }
        return ticket;
    }
    
    public int release(int slot){
        parkingSlots[slot-1] = null;
        return slot;
    }
    
    public Car[] getParkingSlots() {
        return parkingSlots;
    }
}
