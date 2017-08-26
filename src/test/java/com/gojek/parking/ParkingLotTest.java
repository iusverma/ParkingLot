package com.gojek.parking;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ParkingLotTest {

	@Test
	public void testParkingLot() {
		ParkingLot plNotCreated = ParkingLot.getParkingLot();
		Assert.assertNull(plNotCreated);

		ParkingLot pl = ParkingLot.createParkingSlots(3);
		Assert.assertEquals(pl.getParkingSlots().length,3);

		Car car = new Car("SJW-5823U","White");
		ParkingTicket pt = pl.park(car);
		Assert.assertEquals(pt.getSlotNumber(), 1);
		
		ParkingLot plCreated = ParkingLot.getParkingLot();
		Assert.assertEquals(plCreated.release(1), 1);
	}
}
