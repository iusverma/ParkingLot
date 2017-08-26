package com.gojek.parking.commands;

import com.gojek.parking.enums.Command;

public class CreateParkingLot extends CommandType{
    
    public CreateParkingLot(String input){
        super.currentCommand = Command.CREATE_PARKING_LOT;
        super.parameter = input;
    }

    @Override
    public String execute() {
        System.out.println("Current command: "+currentCommand.toString());
        return "Current command: "+currentCommand.toString();
    }
}
