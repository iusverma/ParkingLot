package com.gojek.parking.commands;

import com.gojek.parking.Car;
import com.gojek.parking.ParkingLot;
import com.gojek.parking.enums.Command;
/**
 * Parking slot for cars with given registration number
 */
public class SlotForCar extends CommandType{
    
    public SlotForCar(String input){
        super.currentCommand = Command.SLOT_NUMBERS_FOR_REGISTRATION_NUMBER;
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
        String input[] = getParameter().split(" ");
        /* Basic validation for command
         */
        if(input.length != 2){
            String message = "Invalid parameter list.";
            System.out.println(message);
            return message;
        }

        String regNum = input[1];
        StringBuilder message = new StringBuilder("");
        ParkingLot parkingLot = ParkingLot.getParkingLot();
        /* Begin searching for car
         */
        if (parkingLot != null) {
            Car[] cars = parkingLot.getParkingSlots();
            if (cars == null || cars.length <= 0) {
                /* If parking slot is empty no car is present
                 */
                message.append("No slot available with Registration Number : " + regNum);
            } else {
                /* Parking slot have cars, search for desired car
                 */
                int slotNumber = -1;
                for (int count = 0; count < cars.length; count++) {
                    Car tempCar = cars[count];
                    if (tempCar != null) {
                        if (tempCar.getRegistrationNumber().equalsIgnoreCase(regNum)) {
                            /* Car found store parking slot*/
                            slotNumber = count + 1;
                        }
                    }
                }
                /* Preparing Response
                 */
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
