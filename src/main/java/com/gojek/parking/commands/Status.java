package com.gojek.parking.commands;

import com.gojek.parking.Car;
import com.gojek.parking.ParkingLot;
import com.gojek.parking.enums.Command;
/**
 * Status command
 */
public class Status extends CommandType{
    
    public Status(String input){
        super.currentCommand = Command.STATUS;
        super.parameter = input;
    }

    /*
     * @see com.gojek.parking.commands.CommandType#execute()
     */
    @Override
    public String execute() {
        if (getParameter() == null) {
            String message = "Invalid parameter list.";
            return message;
        }
        /* Basic validation for slots for car with colour command
         */
        String input[] = getParameter().split(" ");
        if(input.length != 1){
            String message = "Invalid parameter list.";
            System.out.println(message);
            return message;
        }

        StringBuilder message = new StringBuilder("");
        ParkingLot parkingLot = ParkingLot.getParkingLot();
        /* Traversing parking slots
         */
        if (parkingLot != null) {
            Car[] cars = parkingLot.getParkingSlots();
            if (cars == null || cars.length <= 0) {
                /* If parking slot is empty no car is present
                 */
                message.append("No Car Available in ParkingLot");
            } else {
                /* Cars are present, so need to prepare details for cars
                 */
                message.append("No").append("\t").append("Registration Slot No.").append("\t").append("Colour");
                message.append("\n");
                for (int count = 0; count < cars.length; count++) {
                    StringBuilder tempStr = new StringBuilder("");
                    if (cars[count] != null) {
                        tempStr.append(count + 1).append("\t").append(cars[count].getRegistrationNumber()).append("\t").append(cars[count].getColour());
                    }
                    /* Just a little workaround for making sure no empty line get added
                     * This will make sure, a line will only be added when there is a car
                     */
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
