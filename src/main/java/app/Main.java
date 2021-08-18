package main.java.app;


import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String fileName = input.nextLine();

        String bracketSeq;

        try {

            bracketSeq = FileUtils.getTextFromFile(fileName);
            Boolean answer = BracketsChecker.isCorrectBracketSeq(bracketSeq);
            FileUtils.writeToFile(fileName, answer + "");

            System.out.println(answer);

        } catch (FileNotFoundException e) {
            FileUtils.writeExceptionToLog(e);
            System.out.println("Нет такого файла");
        }




    }
}
