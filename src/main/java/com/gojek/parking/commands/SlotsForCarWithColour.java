package com.gojek.parking.commands;

import com.gojek.parking.Car;
import com.gojek.parking.ParkingLot;
import com.gojek.parking.enums.Command;
/**
 * Slots for car with specific colour command
 */
public class SlotsForCarWithColour extends CommandType{
    
    public SlotsForCarWithColour(String input){
        super.currentCommand = Command.SLOT_NUMBERS_FOR_CARS_WITH_COLOUR;
        super.parameter = input;
    }

    /*
     * @see com.gojek.parking.commands.CommandType#execute()
     */
    public String execute() {
        String input[] = getParameter().split(" ");
        /* Basic validation for slots for car with colour command
         */
        if(input.length != 2){
            String message = "Invalid parameter list.";
            System.out.println(message);
            return message;
        }

        String colour = input[1];
        StringBuilder message = new StringBuilder("");
        ParkingLot parkingLot = ParkingLot.getParkingLot();
        /* Begin searching for car
         */
        if (parkingLot != null) {
            Car[] cars = parkingLot.getParkingSlots();
            if (cars == null || cars.length <= 0) {
                /* If parking slot is empty no car is present
                 */
                message.append("No car is present with colour: " + colour);
            } else {
                /* Parking slot have cars, search for desired car
                 */
                int slotNumber = -1;
                for (int count = 0; count < cars.length; count++) {
                    Car tempCar = cars[count];
                    if (tempCar != null) {
                        if (tempCar.getColour().equalsIgnoreCase(colour)) {
                            if(message.length()!=0){
                                /* Car found with specified colour, add details*/
                                message.append(", ");
                            }
                            message.append(count+1);
                        }
                    }
                }
                /* Preparing Response
                 */
                if (slotNumber == -1 ) {
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
