package com.gojek.parking.commands;

public class InvalidCommand extends CommandType{
    
    public InvalidCommand(){
        super.currentCommand = null;
        super.parameter = null;
    }

    @Override
    public String execute() {
        System.out.println("User entered invalid command.");
        String result = null;
        return result;
    }

}
