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

		CommandType slotForCar = new SlotForCar(input);
        Assert.assertEquals(slotForCar.execute()
                .compareTo("Invalid parameter list."), 0);

        CommandType slotForCarWithRegNum = new SlotForCar(input);
        Assert.assertEquals(slotForCarWithRegNum.execute()
                .compareTo("Invalid parameter list."), 0);

        CommandType slotForCarWithColour = new SlotForCar(input);
        Assert.assertEquals(slotForCarWithColour.execute()
                .compareTo("Invalid parameter list."), 0);

        CommandType invalidCmd = new InvalidCommand();
        Assert.assertNull(invalidCmd.execute());

        CommandType invalidCmdNull = CommandUtil.prepareCommand(input);
        Assert.assertNull(invalidCmdNull.execute());
	}

	@Test
	public void testCreateParkingLotCommand(){
		StringBuilder input = new StringBuilder("create_parking_lot");
		CommandType createParkingLotEmptySlots =
				CommandUtil.prepareCommand(input.toString());
		Assert.assertEquals(createParkingLotEmptySlots.execute()
				.compareTo("Invalid parameter list."),0);

		input.append(" 3");
		CommandType createParkingLot3Slots =
		        CommandUtil.prepareCommand(input.toString());
		Assert.assertEquals(createParkingLot3Slots.execute()
				.compareTo("Created a parking lot with 3 slots"),0);
	}

	@Test
	public void testParkCommand(){
		String createParkingLotStr = "create_parking_lot 1";
		CommandType createParkingLot =
		        CommandUtil.prepareCommand(createParkingLotStr);
		createParkingLot.execute();

		StringBuilder input = new StringBuilder("park");
		CommandType parkEmptyParam = CommandUtil.prepareCommand(input.toString());
		Assert.assertEquals(parkEmptyParam.execute()
				.compareTo("Invalid parameter list."),0);

		input.append(" KA-01-HH-2701");
		CommandType parkOneParam = CommandUtil.prepareCommand(input.toString());
		Assert.assertEquals(parkOneParam.execute()
				.compareTo("Invalid parameter list."),0);

		input.append(" Blue");
		CommandType park = CommandUtil.prepareCommand(input.toString());
		Assert.assertEquals(park.execute()
				.compareTo("Allocated slot number: 1"),0);

		//Vacating the parking lot
		vacateParkingLot(1);
	}

	@Test
	public void testStatusAndLeaveCommands(){
		String createParkingLotStr = "create_parking_lot 1";
		CommandType createParkingLot =
		        CommandUtil.prepareCommand(createParkingLotStr);
		createParkingLot.execute();

		String input = "park KA-01-HH-2701 Blue";
		CommandType park = CommandUtil.prepareCommand(input.toString());
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

   @Test
    public void testVariousSearchOptions() {
        String createParkingLotStr = "create_parking_lot 3";
        CommandType createParkingLot = CommandUtil.prepareCommand(createParkingLotStr);
        createParkingLot.execute();

        String input1 = "park KA-01-HH-2701 Blue";
        CommandType park1 = CommandUtil.prepareCommand(input1.toString());
        park1.execute();

        String input2 = "park DL-01-A-1111 Red";
        CommandType park2 = CommandUtil.prepareCommand(input2.toString());
        park2.execute();

        String input3 = "park SGX-9999C Blue";
        CommandType park3 = CommandUtil.prepareCommand(input3.toString());
        park3.execute();

        // Slot for car e.g. slot_number_for_registration_number SGX-9999C
        String response = "";
        StringBuilder slotForCarStr = new StringBuilder("slot_number_for_registration_number");
        CommandType slotForCarStrEmpty = CommandUtil.prepareCommand(slotForCarStr.toString());
        response = slotForCarStrEmpty.execute();
        Assert.assertEquals(response.compareTo("Invalid parameter list."), 0);

        slotForCarStr.append(" SGX-9999C");
        CommandType slotForCar = CommandUtil.prepareCommand(slotForCarStr.toString());
        response = slotForCar.execute();
        Assert.assertEquals(response.compareTo("3"), 0);

        // Slot for car with color e.g. slot_numbers_for_cars_with_colour blue
        StringBuilder slotForCarWidCol = new StringBuilder("slot_numbers_for_cars_with_colour");
        CommandType slotForCarWithColNoColGiven = CommandUtil.prepareCommand(slotForCarWidCol.toString());
        response = slotForCarWithColNoColGiven.execute();
        Assert.assertEquals(response.compareTo("Invalid parameter list."), 0);

        slotForCarWidCol.append(" blue");
        CommandType slotForCarWithCol = CommandUtil.prepareCommand(slotForCarWidCol.toString());
        response = slotForCarWithCol.execute();
        Assert.assertEquals(response.compareTo("1, 3"), 0);

        // Slot for car with color e.g.
        // registration_numbers_for_cars_with_colour BLUE
        StringBuilder regNumForCarWidCol = new StringBuilder("registration_numbers_for_cars_with_colour");
        CommandType regNumForCarWidColNoColGiven = CommandUtil.prepareCommand(regNumForCarWidCol.toString());
        response = regNumForCarWidColNoColGiven.execute();
        Assert.assertEquals(response.compareTo("Invalid parameter list."), 0);

        regNumForCarWidCol.append(" BLUE");
        CommandType regNumForCarWidColour = CommandUtil.prepareCommand(regNumForCarWidCol.toString());
        response = regNumForCarWidColour.execute();
        System.out.println(response);
        Assert.assertEquals(response.compareTo("KA-01-HH-2701, SGX-9999C"), 0);

        //Vacating the parking lot
        vacateParkingLot(3);
        CommandType status = new Status("status");
        System.out.println(status.execute());
   }

   private void vacateParkingLot(int size){
       String leaveStr = "leave X";
       for(int i=0;i<size;i++){
           int slot = i+1;
           String templeaveStr = leaveStr.replace("X", Integer.toString(slot));
           CommandType leave = CommandUtil.prepareCommand(templeaveStr);
           leave.execute();
       }
   }
}
