package com.gojek.parking.main;

import org.testng.annotations.Test;

public class FileBaseParkingHandlerTest {

    @Test
    public void testFileBasedParkingHandler() {
        System.out.println("###### FileBaseParkingHandlerTest.testFileBasedParkingHandler begins ######");
        FileBaseParkingHandler fileHandler = new FileBaseParkingHandler();
        String results = fileHandler.execute("file_inputs.txt");
        System.out.println(results);
        System.out.println("###### FileBaseParkingHandlerTest.testFileBasedParkingHandler ends ######");
    }
}
