package com.gojek.parking.commands;

import com.gojek.parking.ParkingLot;
import com.gojek.parking.enums.Command;

public class Leave extends CommandType{
    
    public Leave(String input){
        super.currentCommand = Command.LEAVE;
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
        if(input.length != 2){
            String message = "Invalid parameter list.";
            System.out.println(message);
            return message;
        }
        String slotNumber = input[1];
        ParkingLot parkingLot = ParkingLot.getParkingLot();
        if(parkingLot!=null){
            parkingLot.release(Integer.parseInt(slotNumber));
        }
        StringBuilder message = new StringBuilder("Slot number ");
        message.append(slotNumber);
        message.append(" is free");
        return message.toString();
    }

}
