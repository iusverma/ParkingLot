package com.gojek.parking.commands;

import com.gojek.parking.Car;
import com.gojek.parking.ParkingLot;
import com.gojek.parking.enums.Command;

public class Status extends CommandType{
    
    public Status(String input){
        super.currentCommand = Command.STATUS;
        super.parameter = input;
    }

    @Override
    public String execute() {
        if (getParameter() == null) {
            String message = "Invalid parameter list.";
            return message;
        }
        System.out.println("Current command: "+currentCommand.toString());
        String input[] = getParameter().split(" ");
        if(input.length != 1){
            String message = "Invalid parameter list.";
            System.out.println(message);
            return message;
        }

        StringBuilder message = new StringBuilder("");
        ParkingLot parkingLot = ParkingLot.getParkingLot();
        if (parkingLot != null) {
            Car[] cars = parkingLot.getParkingSlots();
            if (cars == null || cars.length <= 0) {
                message.append("No Car Available in ParkingLot");
            } else {
                message.append("No").append("\t").append("Registration Slot No.").append("\t").append("Colour");
                message.append("\n");
                for (int count = 0; count < cars.length; count++) {
                    StringBuilder tempStr = new StringBuilder("");
                    if (cars[count] != null) {
                        tempStr.append(count + 1).append("\t").append(cars[count].getRegistrationNumber()).append("\t").append(cars[count].getColour());
                    }
                    if(tempStr.length()>=10){
                        message.append(tempStr);
                        message.append("\n");
                    }
                }
            }
        }
        return message.toString();
    }
}
