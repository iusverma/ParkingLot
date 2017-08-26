package com.gojek.parking.commands;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gojek.parking.util.CommandUtil;

public class CommandsTest {
	@Test
	public void testAllCommandsWithNullParameter() {
		String input = null;
		CommandType createParkingType = new CreateParkingLot(input);
		Assert.assertEquals(createParkingType.execute()
				.compareTo("Invalid parameter list."),0);
		
		CommandType park = new Park(input);
		Assert.assertEquals(park.execute()
				.compareTo("Invalid parameter list."),0);
		
		CommandType leave = new Leave(input);
		Assert.assertEquals(leave.execute()
				.compareTo("Invalid parameter list."),0);
		
		CommandType status = new Status(input);
		Assert.assertEquals(status.execute()
				.compareTo("Invalid parameter list."),0);
		
		CommandType invalidCmd = new InvalidCommand();
		Assert.assertNull(invalidCmd.execute());
	}

	@Test
	public void testCreateParkingLotCommand(){
		StringBuilder input = new StringBuilder("create_parking_lot");
		CommandType createParkingLotEmptySlots =
				new CreateParkingLot(input.toString());
		Assert.assertEquals(createParkingLotEmptySlots.execute()
				.compareTo("Invalid parameter list."),0);

		input.append(" 3");
		CommandType createParkingLot3Slots =
				new CreateParkingLot(input.toString());
		Assert.assertEquals(createParkingLot3Slots.execute()
				.compareTo("Created a parking lot with 3 slots"),0);
	}

	@Test
	public void testParkCommand(){
		String createParkingLotStr = "create_parking_lot 1";
		CommandType createParkingLot =
				new CreateParkingLot(createParkingLotStr);
		createParkingLot.execute();

		StringBuilder input = new StringBuilder("park");
		CommandType parkEmptyParam = new Park(input.toString());
		Assert.assertEquals(parkEmptyParam.execute()
				.compareTo("Invalid parameter list."),0);

		input.append(" KA-01-HH-2701");
		CommandType parkOneParam = new Park(input.toString());
		Assert.assertEquals(parkOneParam.execute()
				.compareTo("Invalid parameter list."),0);

		input.append(" Blue");
		CommandType park = new Park(input.toString());
		Assert.assertEquals(park.execute()
				.compareTo("Allocated slot number: 1"),0);
	}

	@Test
	public void testStatusAndLeaveCommands(){
		String createParkingLotStr = "create_parking_lot 1";
		CommandType createParkingLot =
				new CreateParkingLot(createParkingLotStr);
		createParkingLot.execute();

		String input = "park KA-01-HH-2701 Blue";
		CommandType park = new Park(input.toString());
		park.execute();

		String statusStr = "Status";
		CommandType status = CommandUtil.prepareCommand(statusStr);
		String response = status.execute();
		Assert.assertTrue(response.contains("No\tRegistration Slot No.\tColour"));
		Assert.assertTrue(response.contains("1\tKA-01-HH-2701\tBlue"));

		StringBuilder leaveStr = new StringBuilder("leave");
		CommandType leaveWithoutSlotNo = CommandUtil
				.prepareCommand(leaveStr.toString());
		Assert.assertEquals(leaveWithoutSlotNo.execute()
				.compareTo("Invalid parameter list."),0);

		leaveStr.append(" 1");
		CommandType leave = CommandUtil
				.prepareCommand(leaveStr.toString());
		response = leave.execute();
		Assert.assertEquals(response.compareTo("Slot number 1 is free"),0);

		response = status.execute();
		Assert.assertTrue(response.contains("No\tRegistration Slot No.\tColour"));
		Assert.assertFalse(response.contains("1\tKA-01-HH-2701\tBlue"));
	}
}
