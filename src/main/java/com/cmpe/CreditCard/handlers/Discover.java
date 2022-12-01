package com.cmpe.CreditCard.handlers;
import com.cmpe.CreditCard.main.CreditCardEntry;

public class Discover implements CreditCardHandler {
    CreditCardHandler nextHandler;

    public Discover() {
    }

    @Override
    public String checkCreditCardType(CreditCardEntry creditCardEntry) {

//        Long a = creditCardEntry.getCardNumber();
        String number = creditCardEntry.getCardNumber();
        String result = "";
        String fourDigit = number.substring(0, 4);
        int sDigit = Integer.parseInt(number.substring(1, 2));

        if (fourDigit.equals("6011") && number.length() == 16) {
            result = "Discover Card";
        } else {
            result = "Invalid: Not a possible card number";
        }
        return result;
    }
}
