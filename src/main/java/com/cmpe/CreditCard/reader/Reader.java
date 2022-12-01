package com.cmpe.CreditCard.reader;


import com.cmpe.CreditCard.main.CreditCardEntry;

import java.util.List;

public interface Reader {

    List<CreditCardEntry> readFile(String inputFile);
    // TODO Auto-generated method stub

}
