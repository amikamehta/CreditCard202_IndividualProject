package com.cmpe.CreditCard.handlers;
import com.cmpe.CreditCard.main.CreditCardEntry;

public interface CreditCardHandler {
    public String checkCreditCardType(CreditCardEntry creditCardEntry);

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
}
