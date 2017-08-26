package com.gojek.parking;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.gojek.parking.util.ParkingUtil;

public class ParkingLotTest {

    @Test
    public void testParkingLot() {
        ParkingUtil.vacateParkingLot();
        ParkingLot pl = ParkingLot.createParkingSlots(3);
        Assert.assertEquals(pl.getParkingSlots().length, 3);

        Car car = new Car("SJW-5823U", "White");
        ParkingTicket pt = pl.park(car);
        Assert.assertEquals(pt.getSlotNumber(), 1);

        ParkingLot plCreated = ParkingLot.getParkingLot();
        Assert.assertEquals(plCreated.release(1), 1);
    }

    @AfterTest
    private void cleanup() {
        ParkingUtil.vacateParkingLot();
    }
}
