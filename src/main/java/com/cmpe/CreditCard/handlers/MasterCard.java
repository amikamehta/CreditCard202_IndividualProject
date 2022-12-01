package com.cmpe.CreditCard.handlers;
import com.cmpe.CreditCard.main.CreditCardEntry;

public class MasterCard implements CreditCardHandler {
    CreditCardHandler nextHandler;

    public MasterCard() {
        nextHandler = new Visa();
    }

    @Override
    public String checkCreditCardType(CreditCardEntry creditCardEntry) {

        String a = creditCardEntry.getCardNumber();
        String result = "";
        if (a.length() == 0 || a.equals("")) {
            result = "Invalid: empty/null card number";
        } else {
            String number = a;
            if (number.length() <= 19 && number.length() > 0) {
                if (CreditCardHandler.isNumeric(a)) {
                    String fDigit = number.substring(0, 1);
                    int sDigit = Integer.parseInt(number.substring(1, 2));
                    if (fDigit.equals("5") && sDigit >= 1 && sDigit <= 5 && number.length() == 16) {
                        result = "Master Card";
                    } else {
                        return nextHandler.checkCreditCardType(creditCardEntry);
                    }

                } else {
                    result = "Invalid: non numeric characters";
                }
            } else {
                result = "Invalid: more than 19 digits";
            }
        }
        return result;
    }
}
