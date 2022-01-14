package com.hackerrank.sample.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamExample {

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };

        // Let's try the imperative style first(which we
        // are familiar with)
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("Average using iteration :" + (sum / arr.length));

        // Let's try the declarative style now
        sum = Arrays.stream(arr) // Step 1
                .sum(); // Step 2
        System.out.println("Average using streams : " + (sum / arr.length));

        List<String> records = new ArrayList<>();
        records.add("ddd2");
        records.add("aaa2");
        records.add("bbb1");
        records.add("aaa1");
        records.add("bbb3");
        records.add("ccc");
        records.add("bbb2");
        records.add("ddd1");


        // Filter
        System.out.println("\n\n //Filter");
        records.stream()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);

        // Sorted
        System.out.println("\n\n //Sorted");
        records.stream()
                .sorted()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);
    }


}
