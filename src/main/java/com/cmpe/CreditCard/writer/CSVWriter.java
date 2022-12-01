package com.cmpe.CreditCard.writer;

import com.cmpe.CreditCard.main.OutputEntry;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter implements Writer {

    File outputFile;

    public CSVWriter() {
    }

    @Override
    public void writeToFile(List<OutputEntry> result, String outputFile) {
        FileWriter fileWriter = null;
        String File_header = "CardNumber,CardType";
        try {
            fileWriter = new FileWriter(outputFile);
            fileWriter.append(File_header.toString());
            fileWriter.append('\n');
            for (OutputEntry each : result) {
                fileWriter.append(each.getCardNumber());
                fileWriter.append(',');
                fileWriter.append(each.getType());
                fileWriter.append('\n');
                fileWriter.flush();

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }



//    public void writeToFile(List<OutputEntry> result, String outputFile) {
//        FileWriter fileWriter;
//        int resultSize = result.size();
//        int counter = 0;
//        try {
////            BufferedReader br = new BufferedReader(new FileReader(outputFile));
//            fileWriter = new FileWriter(outputFile);
////            if (br.readLine() == null) {
////                fileWriter.write("[");
////                //System.out.println("No errors, and file empty");
////            }
//            fileWriter.write("[");
//            for (OutputEntry each : result) {
//                fileWriter.write("\n");
//                fileWriter.write("{");
//                fileWriter.write('\n');
//                fileWriter.write("\"Card Number\": " + "\"" + each.getCardNumber() +  "\"" + ",");
//                fileWriter.write('\n');
//                fileWriter.write("\"Card Type\": " + "\"" + each.getType() + "\"");
//                fileWriter.write('\n');
//                fileWriter.write("}");
//                if (counter < resultSize - 1) {
//                    fileWriter.write(",");
//                }
//                counter++;
//            }
//
//            fileWriter.write("\n");
//            fileWriter.write("]");
//            fileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


}
