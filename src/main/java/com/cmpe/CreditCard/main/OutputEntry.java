package com.cmpe.CreditCard.main;

public class OutputEntry {
    String cardNumber;
    String type;

    public OutputEntry() {
    }

    public OutputEntry(String cardNumber, String type) {
        this.cardNumber = cardNumber;
        this.type = type;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
