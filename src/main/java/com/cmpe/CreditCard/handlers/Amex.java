package com.cmpe.CreditCard.handlers;
import com.cmpe.CreditCard.main.CreditCardEntry;

public class Amex implements CreditCardHandler {
    CreditCardHandler nextHandler;

    public Amex() {
        nextHandler = new Discover();
    }

    @Override
    public String checkCreditCardType(CreditCardEntry creditCardEntry) {
        String result = "";
        String number = creditCardEntry.getCardNumber();
        String fDigit = number.substring(0, 1);
        int sDigit = Integer.parseInt(number.substring(1, 2));

        if (fDigit.equals("3") && number.length() == 15 && (sDigit == 4 || sDigit == 7)) {
            result = "American Express Card";
        } else {
            return nextHandler.checkCreditCardType(creditCardEntry);
        }
        return result;
    }

}
