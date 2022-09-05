package com.jap.sales;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SalesDataAnalyzer {
    // Read the data from the file and store in a List
   public List<SalesRecord> readFile(String fileName) {
       List<SalesRecord> salesRecords= new ArrayList<>();
       try {
           FileReader fileReader=new FileReader(fileName);
           BufferedReader bufferedReader=new BufferedReader(fileReader);
           String line=bufferedReader.readLine();
           while ((line=bufferedReader.readLine())!=null){
               String[] split =line.split(",");
               String data = split[0];
               int customer_id = Integer.parseInt(split[1]);
               int product_category = Integer.parseInt(split[2]);
               String payment_method = split[3];
               double amount = Double.parseDouble(split[4]);
               double time_on_site = Double.parseDouble(split[5]);
               int clicks_in_site = Integer.parseInt(split[6]);

               salesRecords.add(new SalesRecord(data, customer_id, product_category, payment_method, amount, time_on_site, clicks_in_site));
           }
       }catch (FileNotFoundException e){
           e.printStackTrace();
       }catch (IOException e){
           e.printStackTrace();
       }
        return salesRecords;
    }

    // Sort the customers based on purchase amount
    public List<SalesRecord> getAllCustomersSortedByPurchaseAmount(List<SalesRecord> salesData, AmountComparator amountComparator){

       Collections.sort(salesData,amountComparator);

       return salesData;
    }

    // Find the top customer who spent the maximum time on the site
    public SalesRecord getTopCustomerWhoSpentMaxTimeOnSite(List<SalesRecord> salesData,TimeOnSiteComparator timeOnSiteComparator){
       Collections.sort(salesData,timeOnSiteComparator);

        return salesData.get(0);
    }

    public static void main(String[] args) {
        SalesDataAnalyzer salesDataAnalyzer=new SalesDataAnalyzer();
        String fileName="src/main/resources/purchase_details.csv";
        List<SalesRecord>salesRecords=salesDataAnalyzer.readFile(fileName);
        System.out.println(salesRecords);
        System.out.println("--------------------------------------------------------------");
        System.out.println();
        System.out.println( salesDataAnalyzer.getAllCustomersSortedByPurchaseAmount(salesRecords,new AmountComparator()));
        System.out.println("--------------------------------------------------------------");
        System.out.println();
        System.out.println( salesDataAnalyzer.getTopCustomerWhoSpentMaxTimeOnSite(salesRecords,new TimeOnSiteComparator()));

    }


}
