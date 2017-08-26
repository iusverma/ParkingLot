package com.gojek.parking.main;

import java.util.ArrayList;
import java.util.List;

import com.gojek.parking.commands.CommandType;
import com.gojek.parking.util.CommandUtil;

public class FileBaseParkingHandler implements IParkingLotHandler{
    
    public String execute(String input) {
        StringBuilder output = new StringBuilder("");
        List<String> fileContents = null;
        try {
             fileContents = com.gojek.parking.util.InputFileReader.readFile(input);
        } catch (Exception e) {
            System.out.println("Exception while reading file. "+e);
        }

        List<CommandType> commandRequestList = new ArrayList<CommandType>();

        if (fileContents != null && fileContents.size() > 0) {
            for (String command : fileContents) {
                try {
                    commandRequestList.add(CommandUtil.prepareCommand(command));
                } catch (Exception e) {
                    System.out.println("Exception while converting command."+e);
                }
            }
        }
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
