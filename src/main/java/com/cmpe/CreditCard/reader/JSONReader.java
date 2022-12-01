package com.cmpe.CreditCard.reader;

import com.cmpe.CreditCard.main.CreditCardEntry;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;

public class JSONReader implements Reader {
    File file;

    public JSONReader() {
    }

    public JSONReader(File file) {
        this.file = file;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Long cNumber = Long.parseLong(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    @Override
    public List<CreditCardEntry> readFile(String inputFile) {
        FileReader fr;
        List<CreditCardEntry> result = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        List<String> cardDetails;
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date expDate = new Date();
        try {
            fr = new FileReader(file);
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(fr);

            //JSONObject jsonObject = (JSONObject) obj;
            JSONArray cards = (JSONArray) obj;


            for (int i = 0; i < cards.size(); i++) {

                cardDetails = new ArrayList<>();
                String entries = cards.get(i).toString();
                String[] eachCardEntry = entries.split(",");
                for (String each : eachCardEntry) {
                    String[] split1 = each.split(":");
                    String replace1 = split1[1].replaceAll("}", "");
                    String replace2 = replace1.replaceAll("\\\\", "");
                    cardDetails.add(replace2);
                }
//                System.out.println(cardDetails.get(0));
//                System.out.println(cardDetails.get(1));
//                System.out.println(cardDetails.get(2));
                String cardHolderName = cardDetails.get(0);
                String cardNumber = cardDetails.get(1).replaceAll("\"", "");
                String expirationDate = cardDetails.get(2).replaceAll("\"", "");
                //if (isNumeric(cardNumber)) {

                //Long cNumber = Long.parseLong(cardNumber);

//                DateTimeFormatter df = DateTimeFormatter.ofPattern("M/dd/yyyy");
//                LocalDate eDate = LocalDate.parse(expirationDate, df);

                DateTimeFormatter df = new DateTimeFormatterBuilder()
                        .parseCaseInsensitive()
                        .append(DateTimeFormatter.ofPattern("M/uu"))
                        .toFormatter(Locale.ENGLISH);

                LocalDate eDate = YearMonth.parse(expirationDate, df).atDay(1);

                result.add(new CreditCardEntry(cardNumber, eDate, cardHolderName));
                //} else {

                //}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
