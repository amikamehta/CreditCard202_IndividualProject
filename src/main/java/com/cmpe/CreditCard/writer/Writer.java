
package com.cmpe.CreditCard.writer;


import com.cmpe.CreditCard.main.OutputEntry;

import java.util.List;

public interface Writer {

    public void writeToFile(List<OutputEntry> result, String outputFile);
}

