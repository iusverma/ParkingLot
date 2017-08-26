package com.gojek.parking;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ParkingTicketTest {

	@Test
	public void testParkingTicket() {
		Car car = new Car("SJW-5823U","White");
		ParkingTicket pt = new ParkingTicket(car, 1);
		Assert.assertEquals(1, pt.getSlotNumber());
		Assert.assertEquals(car, pt.getCar());

		Car otherCar = new Car("SGX-5994U","RED");
		pt.setCar(otherCar);
		
		pt.setSlotNumber(2);
		Assert.assertEquals(2, pt.getSlotNumber());
		Assert.assertEquals(otherCar, pt.getCar());
	}
}
