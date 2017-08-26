package com.gojek.parking.commands;

import com.gojek.parking.Car;
import com.gojek.parking.ParkingLot;
import com.gojek.parking.enums.Command;

public class SlotForCar extends CommandType{
    
    public SlotForCar(String input){
        super.currentCommand = Command.SLOT_NUMBERS_FOR_REGISTRATION_NUMBER;
        super.parameter = input;
    }

    @Override
    public String execute() {
        if (getParameter() == null) {
            String message = "Invalid parameter list.";
            return message;
        }
        String input[] = getParameter().split(" ");
        System.out.println("Current command: "+currentCommand.toString());
        if(input.length != 2){
            String message = "Invalid parameter list.";
            System.out.println(message);
            return message;
        }

        String regNum = input[1];
        StringBuilder message = new StringBuilder("");
        ParkingLot parkingLot = ParkingLot.getParkingLot();
        if (parkingLot != null) {
            Car[] cars = parkingLot.getParkingSlots();
            if (cars == null || cars.length <= 0) {
                message.append("No slot available with Registration Number : " + regNum);
            } else {
                int slotNumber = -1;
                for (int count = 0; count < cars.length; count++) {
                    Car tempCar = cars[count];
                    if (tempCar != null) {
                        if (tempCar.getRegistrationNumber().equalsIgnoreCase(regNum)) {
                            slotNumber = count + 1;
                        }
                    }
                }
                if (slotNumber == -1) {
                    message.append("Not Found");
                } else {
                    message.append(slotNumber);
                }
            }
        }
        return message.toString();
    }

}
