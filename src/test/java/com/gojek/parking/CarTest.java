package com.gojek.parking;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CarTest {

	@Test
	public void testCar() {
		Car car = new Car("SJW-5823U","White");
		Assert.assertNotNull(car);
		Assert.assertEquals(car.getRegistrationNumber(),"SJW-5823U");
		Assert.assertEquals(car.getColour(), "White");

		String expectedCarString = "Car [registrationNumber=SJW-5823U, colour=White]";
		Assert.assertEquals(expectedCarString, car.toString());

		car.setColour("RED");
		car.setRegistrationNumber("SGX-5994U");
		Assert.assertEquals(car.getColour(), "RED");
		Assert.assertEquals(car.getRegistrationNumber(),"SGX-5994U");

		expectedCarString = "Car [registrationNumber=SGX-5994U, colour=RED]";
		Assert.assertEquals(expectedCarString, car.toString());
	}
}
