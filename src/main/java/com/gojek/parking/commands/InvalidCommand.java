package com.gojek.parking.commands;

/**
 * Invalid command when user enter invalid or no string
 */
public class InvalidCommand extends CommandType{
    
    public InvalidCommand(){
        super.currentCommand = null;
        super.parameter = null;
    }

    /*
     * @see com.gojek.parking.commands.CommandType#execute()
     */
    @Override
    public String execute() {
        System.out.println("User entered invalid command.");
        String result = null;
        return result;
    }

}
