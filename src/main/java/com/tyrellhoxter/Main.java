package com.tyrellhoxter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by tyrellhoxter on 6/9/16.
 */
public class Main {

    public HashMap<String, String> onesPlaceMap = new HashMap<>();
    public HashMap<String, String> tensPlaceMap = new HashMap<>();
    public HashMap<String, String> hundredsPlaceMap = new HashMap<>();
    public HashMap<String, String> thousandsPlaceMap = new HashMap<>();
    public String convertedDollarAmount = "";
    public String thousand = "Thousand";
    public String million = "Million";
    public String billion = "Billion";

    /**
     * Fills the ones place map used for numbers positioned in the Respective "One" value location
     */
    public void fillOnesMap(){
        onesPlaceMap.put("0", " ");
        onesPlaceMap.put("1", "One");
        onesPlaceMap.put("2", "Two");
        onesPlaceMap.put("3", "Three");
        onesPlaceMap.put("4", "Four");
        onesPlaceMap.put("5", "Five");
        onesPlaceMap.put("6", "Six");
        onesPlaceMap.put("7", "Seven");
        onesPlaceMap.put("8", "Eight");
        onesPlaceMap.put("9", "Nine");
        onesPlaceMap.put("10", "Ten");
        onesPlaceMap.put("11", "Eleven");
        onesPlaceMap.put("12", "Twelve");
        onesPlaceMap.put("13", "Thirteen");
        onesPlaceMap.put("14", "Fourteen");
        onesPlaceMap.put("15", "Fifteen");
        onesPlaceMap.put("16", "Sixteen");
        onesPlaceMap.put("17", "Seventeen");
        onesPlaceMap.put("18", "Eighteen");
        onesPlaceMap.put("19", "Nineteen");
    }

    /**
     * Fills the map located for values located in the numbers 10's place
     */
    public void fillTensplaceMap(){
        tensPlaceMap.put("2", "Twenty");
        tensPlaceMap.put("3", "Thirty");
        tensPlaceMap.put("4", "Forty");
        tensPlaceMap.put("5", "Fifty");
        tensPlaceMap.put("6","Sixty");
        tensPlaceMap.put("7","Seventy");
        tensPlaceMap.put("8","Eighty");
        tensPlaceMap.put("9","Ninety");
    }

    /**
     * Fills the Hundred place map that will be used as value comparisons for everything in the respective
     * "hundreds" place
     */
    public void fillHundredsPlace(){
        hundredsPlaceMap.put("1","One-Hundred");
        hundredsPlaceMap.put("2","Two-Hundred");
        hundredsPlaceMap.put("3","Three-Hundred");
        hundredsPlaceMap.put("4","Four-Hundred");
        hundredsPlaceMap.put("5","Five-Hundred");
        hundredsPlaceMap.put("6","Six-Hundred");
        hundredsPlaceMap.put("7","Seven-Hundred");
        hundredsPlaceMap.put("8","Eight-Hundred");
        hundredsPlaceMap.put("9","Nine-Hundred");
    }

    /**
     * fills the respect thousands place map
     */
    public void fillThousandsPlace(){
        thousandsPlaceMap.put("1","One-Thousand");
        thousandsPlaceMap.put("2","Two-Thousand");
        thousandsPlaceMap.put("3","Three-Thousand");
        thousandsPlaceMap.put("4","Four-Thousand");
        thousandsPlaceMap.put("5","Five-Thousand");
        thousandsPlaceMap.put("6","Six-Thousand");
        thousandsPlaceMap.put("7","Seven-Thousand");
        thousandsPlaceMap.put("8","Eight-Thousand");
        thousandsPlaceMap.put("9","Nine-Thousand");
    }


    /**
     * splits the user input into a string array for later conversions with the above Map values
     * @param dollarAmountInput
     * @return
     */
    public String[] splitIntoStringArray(String dollarAmountInput){
        String[] amountArray = dollarAmountInput.split("");
        return amountArray;
    }

    /**
     * Converter Method that handles all of the number conversion methods.  Uses index locations
     * marked out by the string splitter method above and compares them to hashmap keys to pull out specific
     * values from keys that matched
     * @param theAmountGiven
     * @return
     */
    public String convertDollarAmount(String[] theAmountGiven){
        if(theAmountGiven.length == 1 ){
            convertedDollarAmount = onesPlaceMap.get(theAmountGiven[0]);
        } else if(theAmountGiven.length == 2 && theAmountGiven[0].equals("1")){
            String theStringAmountGiven = theAmountGiven[0].toString();
            theStringAmountGiven += theAmountGiven[1].toString();
            convertedDollarAmount = onesPlaceMap.get(theStringAmountGiven);
        } else if(theAmountGiven.length == 3){
            convertedDollarAmount = hundredsPlaceMap.get(theAmountGiven[0]);
            convertedDollarAmount += " " + tensPlaceMap.get(theAmountGiven[1]);
            convertedDollarAmount += " " + onesPlaceMap.get(theAmountGiven[2]);
        } else if(theAmountGiven.length == 4){
            convertedDollarAmount = thousandsPlaceMap.get(theAmountGiven[0]);
            convertedDollarAmount += " " + hundredsPlaceMap.get(theAmountGiven[1]);
            convertedDollarAmount += " " + tensPlaceMap.get(theAmountGiven[2]);
            convertedDollarAmount += " " + onesPlaceMap.get(theAmountGiven[3]);
        } else if(theAmountGiven.length == 5){
            convertedDollarAmount = onesPlaceMap.get(theAmountGiven) + " " + thousand;
            convertedDollarAmount += " " + hundredsPlaceMap.get(theAmountGiven[2]);
            convertedDollarAmount += " " + tensPlaceMap.get(theAmountGiven[3]);
            convertedDollarAmount += " " + onesPlaceMap.get(theAmountGiven[4]);
        } else if(theAmountGiven.length == 6){
            convertedDollarAmount = hundredsPlaceMap.get(theAmountGiven[0]);
            convertedDollarAmount += " " + tensPlaceMap.get(theAmountGiven[1]);
            convertedDollarAmount += " " + onesPlaceMap.get(theAmountGiven[2]) + " " + thousand;
            convertedDollarAmount += " " + hundredsPlaceMap.get(theAmountGiven[3]);
            convertedDollarAmount += " " + tensPlaceMap.get(theAmountGiven[4]);
            convertedDollarAmount += " " + onesPlaceMap.get(theAmountGiven[5]);
        } else if(theAmountGiven.length == 7){
            convertedDollarAmount = onesPlaceMap.get(theAmountGiven[0]) + " " + million;
            convertedDollarAmount += " " + hundredsPlaceMap.get(theAmountGiven[1]);
            convertedDollarAmount += " " + tensPlaceMap.get(theAmountGiven[2]);
            convertedDollarAmount += " " + onesPlaceMap.get(theAmountGiven[3]) + " " + thousand;
            convertedDollarAmount += " " + hundredsPlaceMap.get(theAmountGiven[4]);
            convertedDollarAmount += " " + tensPlaceMap.get(theAmountGiven[5]);
            convertedDollarAmount += " " + onesPlaceMap.get(theAmountGiven[6]);
        } else if(theAmountGiven.length == 8){
            convertedDollarAmount = tensPlaceMap.get(theAmountGiven[0]);
            convertedDollarAmount += onesPlaceMap.get(theAmountGiven[1]) + " " + million;
            convertedDollarAmount += " " + hundredsPlaceMap.get(theAmountGiven[2]);
            convertedDollarAmount += " " + tensPlaceMap.get(theAmountGiven[3]);
            convertedDollarAmount += " " + onesPlaceMap.get(theAmountGiven[4]) + " " + thousand;
            convertedDollarAmount += " " + hundredsPlaceMap.get(theAmountGiven[5]);
            convertedDollarAmount += " " + tensPlaceMap.get(theAmountGiven[6]);
            convertedDollarAmount += " " + onesPlaceMap.get(theAmountGiven[7]);
        } else if(theAmountGiven.length == 9){
            convertedDollarAmount = hundredsPlaceMap.get(theAmountGiven[0]);
            convertedDollarAmount += " " + tensPlaceMap.get(theAmountGiven[1]);
            convertedDollarAmount += " " + onesPlaceMap.get(theAmountGiven[2]) + " " + million;
            convertedDollarAmount += " " + hundredsPlaceMap.get(theAmountGiven[3]);
            convertedDollarAmount += " " + tensPlaceMap.get(theAmountGiven[4]);
            convertedDollarAmount += " " + onesPlaceMap.get(theAmountGiven[5]) + " " + thousand;
            convertedDollarAmount += " " + hundredsPlaceMap.get(theAmountGiven[6]);
            convertedDollarAmount += " " + tensPlaceMap.get(theAmountGiven[7]);
            convertedDollarAmount += " " + onesPlaceMap.get(theAmountGiven[8]);
        } else if(theAmountGiven.length == 10){
            convertedDollarAmount = onesPlaceMap.get(theAmountGiven[0]) + " " + billion;
            convertedDollarAmount += " " + hundredsPlaceMap.get(theAmountGiven[1]);
            convertedDollarAmount += " " + tensPlaceMap.get(theAmountGiven[2]);
            convertedDollarAmount += " " + onesPlaceMap.get(theAmountGiven[3]) + " " + million;
            convertedDollarAmount += " " + hundredsPlaceMap.get(theAmountGiven[4]);
            convertedDollarAmount += " " + tensPlaceMap.get(theAmountGiven[5]);
            convertedDollarAmount += " " + onesPlaceMap.get(theAmountGiven[6]) + " " + thousand;
            convertedDollarAmount += " " + hundredsPlaceMap.get(theAmountGiven[7]);
            convertedDollarAmount += " " + tensPlaceMap.get(theAmountGiven[8]);
            convertedDollarAmount += " " + onesPlaceMap.get(theAmountGiven[9]);
        }
        System.out.println(convertedDollarAmount + " " + "Dollars");
        return convertedDollarAmount;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Main main = new Main();
        main.fillOnesMap();
        main.fillTensplaceMap();
        main.fillHundredsPlace();
        main.fillThousandsPlace();
        String s;
        while ((s = in.readLine()) != null) {
           String[] theNew = main.splitIntoStringArray(s);
           main.convertDollarAmount(theNew);
        }
    }
}

