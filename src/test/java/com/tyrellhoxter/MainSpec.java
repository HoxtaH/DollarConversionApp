package com.tyrellhoxter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by tyrellhoxter on 6/9/16.
 */
public class MainSpec {

    @Test
    public void fillOnesMapTest(){
        Main convertNumbers = new Main();
        convertNumbers.fillOnesMap();
        String expected = "Zero";
        String actual = convertNumbers.onesPlaceMap.get("0");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldContainKeyTest(){
        Main convertNumbers = new Main();
        convertNumbers.fillOnesMap();
        boolean contains = convertNumbers.onesPlaceMap.containsKey("0");
        Assert.assertTrue(contains);
    }

    @Test
    public void splitIntoStringArrayTest(){
        Main convertNumbers = new Main();
        convertNumbers.fillOnesMap();
        convertNumbers.fillTensplaceMap();
        convertNumbers.fillHundredsPlace();
        convertNumbers.fillThousandsPlace();
        String expected = "Four";
        String[] theTest = convertNumbers.splitIntoStringArray(expected);
        String actual = convertNumbers.onesPlaceMap.get(theTest[0]);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void convertDollarAmountTest(){
        Main convertNumbers = new Main();
        convertNumbers.fillOnesMap();
        convertNumbers.fillTensplaceMap();
        convertNumbers.fillHundredsPlace();
        convertNumbers.fillThousandsPlace();
        String expected = "Four-Hundred Thirty Three";
       String[] theTest = convertNumbers.splitIntoStringArray("345764378");
        String actual = convertNumbers.convertDollarAmount(theTest);
        Assert.assertEquals(expected,actual);
    }
}


