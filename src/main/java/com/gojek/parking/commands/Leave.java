package com.gojek.parking.commands;

import com.gojek.parking.enums.Command;

public class Leave extends CommandType{
    
    public Leave(String input){
        super.currentCommand = Command.LEAVE;
        super.parameter = input;
    }

    @Override
    public String execute() {
        System.out.println("Current command: "+currentCommand.toString());
        return "Current command: "+currentCommand.toString();
    }

}
