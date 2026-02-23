package com.eclothing.clothing.programming.Streams;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LimitAndSkipExample {
    public static void main(String[] args) {
        List<String> products = Arrays.asList("P1", "P2", "P3", "P4", "P5", "P6", "P7", "P8");

        // Using limit() to get the first 5 elements
        List<String> limitedList = products.stream()
                .limit(5)
                .collect(Collectors.toList());
        System.out.println("First 5 elements: " + limitedList);   // [P1, P2, P3, P4, P5]

        // Using skip() to skip the first 5 elements
        List<String> skippedList = products.stream()
                .skip(5)
                .collect(Collectors.toList());
        System.out.println("After skipping first 5 elements: " + skippedList); // [P6, P7, P8]

        //  Combining skip() and limit() to get elements
        List<String> result = products.stream()
                .skip(2)         // Discards P1 and P2
                .limit(3)   // Takes P3, P4, and P5
                .collect(Collectors.toList());
        System.out.println(result); // [P3, P4, P5]
    }
}
