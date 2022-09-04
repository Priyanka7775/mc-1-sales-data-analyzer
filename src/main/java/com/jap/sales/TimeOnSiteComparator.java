package com.jap.sales;


import java.util.Comparator;

public class TimeOnSiteComparator implements Comparator<SalesRecord> {
    @Override
    public int compare(SalesRecord s1, SalesRecord s2) {
        if(s1.getTime_on_site()==s2.getTime_on_site()){
            return 0;
        }if (s1.getTime_on_site()>s2.getTime_on_site()){
            return -1;
        }
        return 1;

    }
}
