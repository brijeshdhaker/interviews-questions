package com.hackerrank.sample.stocks;
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

/**

 An investor has saved some money and wants to invest in the stock market. There are a number of stocks to choose from, and they want to buy at most 1 share in any company. The total invested cannot exceed the funds available. A friend who is a stock market expert has predicted the value of each stock after 1 year. Determine the maximum profit that can be earned at the end of the year assuming the predictions come true.

 Example
 saving = 250
 currentValue = [175, 133, 109, 201, 97]
 futureValue = [200, 125, 128, 228, 133]

 To maximize profits, the investor should buy stocks at indices 2 and 4 for an investment of 109 + 97 = 206. At the end of the year the stocks are sold for 128+133 = 261, so total profit is 261-206 = 55

 Example
 saving = 30
 currentValue = [1,2,4,6]
 futureValue = [5,3,5,6]

 Output = 6

 Example
 *saving = 500
 currentValue = [150, 199, 200, 168, 153]
 futureValue = [140, 175, 199, 121, 111]

 Output = 0 since all of the stocks lost money*

 **/

public class StockExample {

    /*
     * Complete the 'selectStock' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER saving
     *  2. INTEGER_ARRAY currentValue
     *  3. INTEGER_ARRAY futureValue
     */

    public static int selectStock(int saving, List<Integer> currentValue, List<Integer> futureValue) {
        int[] dp = new int[saving+1];
        int N = currentValue.size();
        for (int i = 1; i <= N; i++){
            int weight = currentValue.get(i-1), value = futureValue.get(i-1) - currentValue.get(i-1);
            for (int j = saving; j >= weight; j--){
                dp[j] = Math.max(dp[j], dp[j-weight]+value);
            }
        }
        return dp[saving];

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int saving = Integer.parseInt(bufferedReader.readLine().trim());

        int currentValueCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> currentValue = IntStream.range(0, currentValueCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int futureValueCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> futureValue = IntStream.range(0, futureValueCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = selectStock(saving, currentValue, futureValue);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}
