package com.cmpe.CreditCard.main;

import java.time.LocalDate;
import java.util.Date;


public class CreditCardEntry {

    String cardNumber;
    LocalDate expirationDate;
    String nameOfCardholder;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getNameOfCardholder() {
        return nameOfCardholder;
    }

    public void setNameOfCardholder(String nameOfCardholder) {
        this.nameOfCardholder = nameOfCardholder;
    }



    public CreditCardEntry(String cardNumber, LocalDate expirationDate, String nameOfCardholder) {
        // TODO Auto-generated constructor stub
        this.cardNumber = cardNumber;
        this.expirationDate =  expirationDate;
        this.nameOfCardholder = nameOfCardholder;
    }
    public CreditCardEntry(long cardNumber, LocalDate parse, String nameOfCardholder){

    }


}
