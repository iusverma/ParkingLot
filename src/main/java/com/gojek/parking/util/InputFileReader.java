package com.gojek.parking.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
/**
 * InputFileReader for reading file based commands
 */
public class InputFileReader {

	/**
	 * readFile
	 * @param input file
	 * @return list of strings from file
	 */
    public static List<String> readFile(String inputFile) {

        System.out.println("inputFile: "+inputFile);
        /*
         * Input file validations
         */
        if (inputFile == null || inputFile.isEmpty()) {
            System.out.println("InputFile Path is Empty or Null.");
        }

        /* list of strings from input file */
        List<String> commandsList = new ArrayList<String>();
        
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;

        try {
            /*
             * Opening reader streams for reading file
             */
            String path = Paths.get(".").toAbsolutePath().normalize().toString();
            File params = new File(path, inputFile);
            fileReader = new FileReader(params);
            bufferedReader = new BufferedReader(fileReader);

            String sCurrentLine;

            while ((sCurrentLine = bufferedReader.readLine()) != null) {
                if (sCurrentLine != null && !sCurrentLine.isEmpty()) {
                    /* Instrumenting input line to commands lists */
                    commandsList.add(sCurrentLine);
                }
            }
        } catch (IOException e) {
            System.out.println("Unable to read file"+e);
        } finally {
            try {
                /*
                 * Closing reader streams
                 */
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