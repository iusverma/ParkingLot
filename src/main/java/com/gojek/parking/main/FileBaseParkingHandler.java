package com.gojek.parking.main;

import java.util.ArrayList;
import java.util.List;

import com.gojek.parking.commands.CommandType;
import com.gojek.parking.util.CommandUtil;
/**
 * Parking lot handler for input file
 */
public class FileBaseParkingHandler implements IParkingLotHandler{

	/*
	 * Overrides execute method in IParkingLotHandler and provided interactive execution
	 * @see com.gojek.parking.main.IParkingLotHandler#execute(java.lang.String)
	 */
    public String execute(String input) {
        StringBuilder output = new StringBuilder("");
        List<String> fileContents = null;
        try {
            /* Reading file content and populating input strings
             */
            fileContents = com.gojek.parking.util.InputFileReader.readFile(input);
        } catch (Exception e) {
            System.out.println("Exception while reading file. "+e);
        }

        List<CommandType> commandRequestList = new ArrayList<CommandType>();

        /* Parsing input stings to command and preparing commands list
         */
        if (fileContents != null && fileContents.size() > 0) {
            for (String command : fileContents) {
                try {
                    commandRequestList.add(CommandUtil.prepareCommand(command));
                } catch (Exception e) {
                    System.out.println("Exception while converting command."+e);
                }
            }
        }
        /* Executing commands
         */
        if (commandRequestList != null && !commandRequestList.isEmpty()) {
            for (CommandType command : commandRequestList) {
                String result = command.execute();
                if (!result.isEmpty()) {
                    output.append(result);
                    output.append("\n");
                }
            }   
        }
        return output.toString();
    }
}
