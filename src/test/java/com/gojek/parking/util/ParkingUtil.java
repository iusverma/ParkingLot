package com.gojek.parking.util;

import com.gojek.parking.Car;
import com.gojek.parking.ParkingLot;
import com.gojek.parking.commands.CommandType;

public class ParkingUtil {
    public static void vacateParkingLot() {
        String leaveStr = "leave X";

        Car[] parkingSlots = ParkingLot.getParkingLot().getParkingSlots();
        for (int i = 0; i < parkingSlots.length; i++) {
            if (parkingSlots[i] != null) {
                int slot = i + 1;
                String templeaveStr = leaveStr.replace("X", Integer.toString(slot));
                CommandType leave = CommandUtil.prepareCommand(templeaveStr);
                leave.execute();
            }
        }
    }
}
