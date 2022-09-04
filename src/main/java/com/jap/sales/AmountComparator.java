package com.jap.sales;


import java.util.Comparator;

public class AmountComparator implements Comparator<SalesRecord> {
    @Override
    public int compare(SalesRecord s1, SalesRecord s2) {
        if(s1.getAmount()==s2.getAmount()){
            return 0;
        }if (s1.getAmount()>s2.getAmount()){
            return -1;
        }
        return 1;
    }
}
