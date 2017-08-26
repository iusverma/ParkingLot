package com.gojek.parking.commands;

import com.gojek.parking.enums.Command;

public class Park extends CommandType{
    
    public Park(String input){
        super.currentCommand = Command.PARK;
        super.parameter = input;
    }

    @Override
    public String execute() {
        System.out.println("Current command: "+currentCommand.toString());
        return "Current command: "+currentCommand.toString();
    }

}
