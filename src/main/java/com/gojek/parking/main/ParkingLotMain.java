package com.gojek.parking.main;

public class ParkingLotMain {
    public static void main(String args[]){
        IParkingLotHandler parkingHandler = null;
        String input = null;
        if(args == null || args.length < 1){
            parkingHandler = new InteractiveParkingHandler();
        }else{
            // write logic for file based handler
        }
        String response = parkingHandler.execute(input);
        if(response != null){
        	System.out.println(response);
        }
    }
}