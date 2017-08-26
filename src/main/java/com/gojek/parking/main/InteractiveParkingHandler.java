package com.gojek.parking.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.gojek.parking.commands.CommandType;
import com.gojek.parking.util.CommandUtil;

public class InteractiveParkingHandler implements IParkingLotHandler{

    public String execute(String input) {
    	String result = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = null;
            try {
                line = reader.readLine();
                if (line == null || line.trim().equals("")) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Unable to read command from console" +e);
            }
            CommandType command = CommandUtil.prepareCommand(line);
            result = command.execute();
            if(result != null){
                System.out.println(result);
            }
        }
        try {
            reader.close();
        } catch (Exception e) {
            System.out.println("Exception while closing reader stream" + e);
        }
        return result;
    }
}
