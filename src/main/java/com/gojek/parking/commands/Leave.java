package com.gojek.parking.commands;

import com.gojek.parking.ParkingLot;
import com.gojek.parking.enums.Command;
/**
 * Leave command for freeing parking slot
 */

public class Leave extends CommandType{
    
    public Leave(String input){
        super.currentCommand = Command.LEAVE;
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
        /* Basic validation for leave command
         */
        if(input.length != 2){
            String message = "Invalid parameter list.";
            System.out.println(message);
            return message;
        }
        String slotNumber = input[1];
        /* Freeing parking space
         */
        ParkingLot parkingLot = ParkingLot.getParkingLot();
        if(parkingLot!=null){
            parkingLot.release(Integer.parseInt(slotNumber));
        }
        /* Preparing Response
         */
        StringBuilder message = new StringBuilder("Slot number ");
        message.append(slotNumber);
        message.append(" is free");
        return message.toString();
    }

}
