package com.gojek.parking.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.gojek.parking.commands.CommandType;
import com.gojek.parking.util.CommandUtil;

/**
 * Interactive command handler for parking system
 */
public class InteractiveParkingHandler implements IParkingLotHandler{

	/*
	 * Overrides execute method in IParkingLotHandler and provided interactive execution
	 * @see com.gojek.parking.main.IParkingLotHandler#execute(java.lang.String)
	 */
    public String execute(String input) {
    	String result = null;
        /*
         * Initializing input stream from shell
         */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = null;
            try {
                /*
                 * Reading line till a blank line appears
                 */
                line = reader.readLine();
                if (line == null || line.trim().equals("")) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Unable to read command from console" +e);
            }
            /*
             * Parsing command from input
             */
            CommandType command = CommandUtil.prepareCommand(line);
            result = command.execute();
            if(result != null){
                System.out.println(result);
            }
        }
        try {
            /*
             * Closing input stream
             */
            reader.close();
        } catch (Exception e) {
            System.out.println("Exception while closing reader stream" + e);
        }
        return result;
    }
}
