package com.gojek.parking.commands;

import com.gojek.parking.Car;
import com.gojek.parking.ParkingLot;
import com.gojek.parking.enums.Command;
/**
 * Registration number for cars with specific colour
 */
public class RegNumOfCarsWithColour extends CommandType{
    
    public RegNumOfCarsWithColour(String input){
        super.currentCommand = Command.REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR;
        super.parameter = input;
    }

    /*
     * @see com.gojek.parking.commands.CommandType#execute()
     */
    @Override
    public String execute() {
        String input[] = getParameter().split(" ");
        /* Basic validation for command
         */
        if(input.length != 2){
            String message = "Invalid parameter list.";
            System.out.println(message);
            return message;
        }

        /* Search for cars with specific colour
         */
        String colour = input[1];
        StringBuilder message = new StringBuilder("");
        ParkingLot parkingLot = ParkingLot.getParkingLot();
        if (parkingLot != null) {
            Car[] cars = parkingLot.getParkingSlots();
            if (cars == null || cars.length <= 0) {
                /* If parking slot is free, no car is present
                 */
                message.append("No car is present with colour: " + colour);
            } else {
                /* Parking slots have cars, search for desired colour
                 */
                int slotNumber = -1;
                for (int count = 0; count < cars.length; count++) {
                    Car tempCar = cars[count];
                    if (tempCar != null) {
                        if (tempCar.getColour().equalsIgnoreCase(colour)) {
                            /* Car with matching colour found,
                             * add details to result
                             */
                            if(message.length()!=0){
                                message.append(", ");
                            }
                            message.append(tempCar.getRegistrationNumber());
                        }
                    }
                }
                /* Preparing Response
                 */
                if (slotNumber == -1) {
                    if(message.length()==0){
                        message.append("Not Found");
                    }
                } else {
                    message.append(slotNumber);
                }
            }
        }
        return message.toString();
    }

}
