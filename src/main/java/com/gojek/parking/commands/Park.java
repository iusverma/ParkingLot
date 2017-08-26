package com.gojek.parking.commands;

import com.gojek.parking.Car;
import com.gojek.parking.ParkingLot;
import com.gojek.parking.ParkingTicket;
import com.gojek.parking.enums.Command;

public class Park extends CommandType{
    
    public Park(String input){
        super.currentCommand = Command.PARK;
        super.parameter = input;
    }

    @Override
    public String execute() {
        if (getParameter() == null) {
            String message = "Invalid parameter list.";
            return message;
        }
        String input[] = getParameter().split(" ");
        System.out.println("Current command: "+currentCommand.toString());
        if(input.length != 3){
            String message = "Invalid parameter list.";
            System.out.println(message);
            return message;
        }

        ParkingLot parkingLot = ParkingLot.getParkingLot();
        ParkingTicket parkingTicket = null;

        String carRegNum = input[1];
        String carColour = input[2];
        if (parkingLot != null) {
            parkingTicket = parkingLot.park(new Car(carRegNum,carColour));
        }

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
