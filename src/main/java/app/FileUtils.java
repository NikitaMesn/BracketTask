package main.java.app;

import java.io.*;
import java.time.LocalDateTime;

public class FileUtils {

    public static String getTextFromFile(String fileName) throws FileNotFoundException {

        StringBuilder sb = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(
                new FileReader(fileName))){
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            writeExceptionToLog(e);
        }

        return sb.toString();
    }

    public static void writeToFile(String name, String answer) {
        String nm = new File(name).getName();

        String fileName = "files/answer_" + nm;
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(answer);
            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");

            writeExceptionToLog(e);
        }
    }

    public static void writeExceptionToLog(Exception e) {

        try (FileWriter writer = new FileWriter("exceptions.txt", true)) {
            writer.write(String.format("Error: %s " +
                            "\nDatetime: %s " +
                            "\n ********************************************************************\n",
                    e.getMessage(), LocalDateTime.now().toString().substring(0, 19)));
        } catch (IOException ioException) {
            throw new RuntimeException("Could not write Exception to file", ioException);
        }
    }
}
