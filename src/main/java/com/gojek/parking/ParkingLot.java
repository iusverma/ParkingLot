package com.gojek.parking;

/**
 * Parking lot class to manage the parking lot
 */
public class ParkingLot {
    /**
     * Static reference for parking lot
     */
    private static ParkingLot parkingLot;

    /**
     * Array of cars which will hold car objects
     */
    private static Car[] parkingSlots;
    
    private ParkingLot(int numberOfSlots){
        parkingSlots = new Car[numberOfSlots];
        for (int i = 0; i < numberOfSlots; i++) {
            parkingSlots[i] = null;
        }
    }

    /**
     * createParkingSlots: This method will
     * 1. create new ParkingLot instance
     * 2. allocate memory for parkingSlots
     * 3. resize the memory, if parkingSlots is empty
     */
    public static ParkingLot createParkingSlots(int numberOfSlots){
        if(parkingLot == null){
            /* If parkingLot is not initialized
             * Initialize with given number
             */
            synchronized (ParkingLot.class) {
                parkingLot = new ParkingLot(numberOfSlots);
            }
        } else {
            /* If parkingLot is initialize,
             * Reinitialize only when it is empty
             */
            if(isEmpty()){
                parkingSlots = new Car[numberOfSlots];
            }
        }
        return parkingLot;
    }

    /**
     * Returns current parking lot object
     */
    public static ParkingLot getParkingLot(){
        return parkingLot;
    }

    /**
     * Assign a car to particular location in parkingSlots
     * @param car
     * @return ParkingTicket
     */
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

    /**
     * Frees the slot number passed
     * @param slot
     * @return slot
     */
    public int release(int slot){
        parkingSlots[slot-1] = null;
        return slot;
    }

    /**
     * Return existing parkingSlots
     * @return
     */
    public Car[] getParkingSlots() {
        return parkingSlots;
    }

    /**
     * Return true is parkingSlot is empty
     * @return
     */
    private static boolean isEmpty(){
        for(int i=0;i<parkingSlots.length;i++){
            if(parkingSlots[i] != null)
                return false;
        }
        return true;
    }
}
