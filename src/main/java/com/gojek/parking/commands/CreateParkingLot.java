package com.gojek.parking.commands;

import com.gojek.parking.ParkingLot;
import com.gojek.parking.enums.Command;

public class CreateParkingLot extends CommandType{
    
    public CreateParkingLot(String input){
        super.currentCommand = Command.CREATE_PARKING_LOT;
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
        String slots = input[1];
        ParkingLot.createParkingSlots(Integer.parseInt(slots));

        StringBuilder message = new StringBuilder("Created a parking lot with ")
        .append(slots)
        .append(" slots");

        return message.toString();
    }
}
