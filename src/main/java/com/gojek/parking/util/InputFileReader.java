package com.gojek.parking.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputFileReader {

    public static List<String> readFile(String inputFile) {
        
        if (inputFile == null || inputFile.isEmpty()) {
            System.out.println("InputFile Path is Empty or Null.");
        }
        
        List<String> commandsList = new ArrayList<String>();
        
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(inputFile);
            bufferedReader = new BufferedReader(fileReader);

            String sCurrentLine;

            while ((sCurrentLine = bufferedReader.readLine()) != null) {
                if (sCurrentLine != null && !sCurrentLine.isEmpty()) {
                    commandsList.add(sCurrentLine);
                }
            }
        } catch (IOException e) {
            System.out.println("Unable to read file"+e);
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException ex) {
                System.out.println("Unable to read file" +ex);
            }
        }
        return commandsList;
    }
}