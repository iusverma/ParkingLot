package com.gojek.parking.commands;

import com.gojek.parking.ParkingLot;
import com.gojek.parking.enums.Command;
/**
 * Create parking lot command
 */
public class CreateParkingLot extends CommandType{
    
    public CreateParkingLot(String input){
        super.currentCommand = Command.CREATE_PARKING_LOT;
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
        /* Basic validation for create parking lot command
         */
        if(input.length != 2){
            String message = "Invalid parameter list.";
            System.out.println(message);
            return message;
        }
        String slots = input[1];
        /* Creating parking lot
         */
        ParkingLot.createParkingSlots(Integer.parseInt(slots));

        /* Preparing Response
         */
        StringBuilder message = new StringBuilder("Created a parking lot with ")
        .append(slots)
        .append(" slots");

        return message.toString();
    }
}
