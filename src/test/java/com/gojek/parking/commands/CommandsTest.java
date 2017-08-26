package com.gojek.parking.commands;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CommandsTest {
	@Test
	public void testCommands() {
		String input = null;
		CommandType createParkingType = new CreateParkingLot(input);
		Assert.assertTrue(createParkingType.execute().equals("Current command: create_parking_lot"));
		
		CommandType park = new Park(input);
		Assert.assertTrue(park.execute().equals("Current command: park"));
		
		CommandType leave = new Leave(input);
		Assert.assertTrue(leave.execute().equals("Current command: leave"));
		
		CommandType status = new Status(input);
		Assert.assertTrue(status.execute().equals("Current command: status"));
		
		CommandType invalidCmd = new InvalidCommand();
		Assert.assertNull(invalidCmd.execute());
	}
}
