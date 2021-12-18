package com.hackerrank.sample.discount;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class DiscountTest {

    /*
     * Complete the 'calculateAmount' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY prices as parameter.
     */

    // Method for getting the minimum value
    public static int getMin(int[] inputArray){
        int minValue = inputArray[0];
        for(int i=1;i<inputArray.length;i++){
            if(inputArray[i] < minValue){
                minValue = inputArray[i];
            }
        }
        return minValue;
    }

    public static int[] getPreviousPrices(int index, List<Integer> prices){
        int [] p_prices = new int[index];
        for(int j = 0 ; j < index; j++){
            p_prices[j] =  prices.get(j);
        }
        return p_prices;
    }

    public static long calculateAmount(List<Integer> prices) {
        long totalcost = 0;
        long p_m_price = 0;
        for(int i = 0; i < prices.size(); i++){
            long a_price = 0;
            long c_price = new Long(prices.get(i));
            if(i != 0){
                // int [] p_prices = getPreviousPrices(i+1, prices);
                // m_price = getMin(p_prices);
                // a_price = Math.max((c_price - m_price), 0);
                long p_price = new Long(prices.get(i-1));
                p_m_price = Math.min(p_m_price, p_price);
                a_price = Math.max((c_price - p_m_price), 0);
            }else{
                a_price = c_price;
                p_m_price = c_price;
            }
            //
            totalcost = totalcost + a_price;
        }

        return totalcost;
    }

    public static void main(String[] args) {

        Integer[] p1 = { 2, 5, 1, 4 };
        List<Integer> prices = Arrays.asList(p1);

        long pt = calculateAmount(prices);
        System.out.println("Total Cost - 1 : " + pt);

        Integer[] p2 = { 4, 9, 2, 3 };
        List<Integer> prices2 = Arrays.asList(p2);

        long pt2 = calculateAmount(prices2);
        System.out.println("Total Cost - 2 : " + pt2);
    }
}
