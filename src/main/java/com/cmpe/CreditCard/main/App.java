package com.cmpe.CreditCard.main;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.cmpe.CreditCard.handlers.CreditCardHandler;
import com.cmpe.CreditCard.handlers.MasterCard;
import com.cmpe.CreditCard.reader.*;
import com.cmpe.CreditCard.writer.*;


public class App {
    public static String getFileType(String inputFile) {
        String extension = "";
        int i = inputFile.lastIndexOf('.');
        if (i > 0) {
            extension = inputFile.substring(i + 1);
        }
        return extension;
    }

    public static void main(String[] args) {
        String outputFile, inputFile;
        String inputFileType = "";
        String outputFileType = "";
        Reader filereader;
        Writer filewriter = null;
        List<CreditCardEntry> creditCardEntries = new ArrayList<>();
        List<OutputEntry> finalEntries = new ArrayList<>();
        if (args.length < 2) {
            throw new IllegalArgumentException("Please enter correct arguments");
        }
        inputFile = args[0];
        outputFile = args[1];
        inputFileType = inputFile.substring(inputFile.indexOf("."));
        outputFileType = outputFile.substring(outputFile.indexOf("."));

        if (!inputFileType.equals(outputFileType)) {
            System.out.println("Input and Output extensions are not same");
            System.exit(0);
        } else {
            System.out.println("Input and output extensions " + inputFileType + " and " + outputFileType + " are same");
        }
        String fileType = getFileType(inputFile);
        if (fileType.equalsIgnoreCase("csv")) {
            filewriter = new CSVWriter();
            filereader = new CSVReader(new File(inputFile));
            creditCardEntries = filereader.readFile(inputFile);
        } else if (fileType.equalsIgnoreCase("json")) {
            filewriter = new JSONWriter();
            filereader = new JSONReader(new File(inputFile));
            creditCardEntries = filereader.readFile(inputFile);
        } else if (fileType.equalsIgnoreCase("xml")) {
            filewriter = new XMLWriter();
            filereader = new XMLReader(new File(inputFile));
            creditCardEntries = filereader.readFile(inputFile);
        }

        for (CreditCardEntry eachCreditCardEntry : creditCardEntries) {
            CreditCardHandler ccHandler = new MasterCard();
            String creditCardType = ccHandler.checkCreditCardType(eachCreditCardEntry);
            String ccNumber = eachCreditCardEntry.getCardNumber();
            finalEntries.add(new OutputEntry(ccNumber, creditCardType));
            filewriter.writeToFile(finalEntries, outputFile);
        }


    }

}
