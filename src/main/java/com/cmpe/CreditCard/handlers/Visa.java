
package com.cmpe.CreditCard.handlers;
import com.cmpe.CreditCard.main.CreditCardEntry;

public class Visa implements CreditCardHandler {
    CreditCardHandler nextHandler;

    public Visa() {
        nextHandler = new Amex();
    }

    @Override
    public String checkCreditCardType(CreditCardEntry creditCardEntry) {
        String a = creditCardEntry.getCardNumber();
        String number = a;
        String result = "";
        String fDigit = number.substring(0, 1);

        if (fDigit.equals("4") && (number.length() == 13 || number.length() == 16)) {
            result = "Visa Card";
        } else {
            return nextHandler.checkCreditCardType(creditCardEntry);
        }
        return result;
    }
}

