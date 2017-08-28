package com.gojek.parking.commands;

import com.gojek.parking.Car;
import com.gojek.parking.ParkingLot;
import com.gojek.parking.ParkingTicket;
import com.gojek.parking.enums.Command;
/**
 * Park command
 */
public class Park extends CommandType{
    
    public Park(String input){
        super.currentCommand = Command.PARK;
        super.parameter = input;
    }

    /*
     * @see com.gojek.parking.commands.CommandType#execute()
     */
    @Override
    public String execute() {
        if (getParameter() == null) {
            String message = "Invalid parameter list.";
            return message;
        }
        String input[] = getParameter().split(" ");
        /* Basic validation for park command
         */
        if(input.length != 3){
            String message = "Invalid parameter list.";
            System.out.println(message);
            return message;
        }

        /* Creating parking lot instance
         */
        ParkingLot parkingLot = ParkingLot.getParkingLot();
        ParkingTicket parkingTicket = null;
        String carRegNum = input[1];
        String carColour = input[2];
        /* Allocating parking
         */
        if (parkingLot != null) {
            parkingTicket = parkingLot.park(new Car(carRegNum,carColour));
        }

        /* Preparing Response
         */
        StringBuilder message = new StringBuilder("");
        if (parkingTicket != null) {
            message.append("Allocated slot number: ")
            .append(parkingTicket.getSlotNumber());
        } else {
            message.append("Sorry, parking lot is full");
        }
        return message.toString();
    }

}
