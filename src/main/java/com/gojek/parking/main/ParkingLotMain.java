package com.gojek.parking.main;

import com.gojek.parking.main.IParkingLotHandler;
/**
 * ParkingLotMain - entry point for the application
 */
public class ParkingLotMain {
    public static void main(String args[]){
        IParkingLotHandler parkingHandler = null;
        String inputFile = null;
        if(args == null || args.length < 1){
            /* If user has provided no input with command,
             * invoke interactive shell
             */
            parkingHandler = new InteractiveParkingHandler();
        }else{
            /* If user has given input file that,
             * invoke commands for file
             */
            parkingHandler = new FileBaseParkingHandler();
            inputFile = args[0];
        }
        String response = parkingHandler.execute(inputFile);
        if(response != null){
        	System.out.println(response);
        }
    }
}