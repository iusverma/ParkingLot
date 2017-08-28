package com.gojek.parking.util;

import com.gojek.parking.commands.CommandType;
import com.gojek.parking.commands.CreateParkingLot;
import com.gojek.parking.commands.InvalidCommand;
import com.gojek.parking.commands.Leave;
import com.gojek.parking.commands.Park;
import com.gojek.parking.commands.RegNumOfCarsWithColour;
import com.gojek.parking.commands.SlotForCar;
import com.gojek.parking.commands.SlotsForCarWithColour;
import com.gojek.parking.commands.Status;
import com.gojek.parking.enums.Command;
/**
 * CommandUtil for parsing a given command
 */
public class CommandUtil{

	/**
	 * Parses input string and returns a valid command
	 * @param input
	 * @return command
	 */
    public static CommandType prepareCommand(String input){
        CommandType command = null;
        if(input != null){
            if (input.toLowerCase().startsWith(Command.CREATE_PARKING_LOT.getKey())) {
                command = new CreateParkingLot(input);
            } else if (input.toLowerCase().startsWith(Command.PARK.getKey())) {
                command = new Park(input);
            } else if (input.toLowerCase().startsWith(Command.LEAVE.getKey())) {
                command = new Leave(input);
            } else if (input.toLowerCase().startsWith(Command.STATUS.getKey())) {
                command = new Status(input);
            } else if (input.toLowerCase().startsWith(Command.REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR.getKey())) {
                command = new RegNumOfCarsWithColour(input);
            } else if (input.toLowerCase().startsWith(Command.SLOT_NUMBERS_FOR_CARS_WITH_COLOUR.getKey())) {
                command = new SlotsForCarWithColour(input);
            } else if (input.toLowerCase().startsWith(Command.SLOT_NUMBERS_FOR_REGISTRATION_NUMBER.getKey())) {
                command = new SlotForCar(input);
            }else{
                /* If input is null return InvalidCommand
                 */
                command = new InvalidCommand();
            }
        }else{
            /* If input is null return InvalidCommand
             */
            command = new InvalidCommand();
        }
        return command;
    }
}
