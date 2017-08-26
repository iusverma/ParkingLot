package com.gojek.parking.commands;

import com.gojek.parking.enums.Command;

public class Status extends CommandType{
    
    public Status(String input){
        super.currentCommand = Command.STATUS;
        super.parameter = input;
    }

    @Override
    public String execute() {
        System.out.println("Current command: "+currentCommand.toString());
        return "Current command: "+currentCommand.toString();
    }
}
