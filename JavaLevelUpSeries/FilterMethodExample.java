package com.eclothing.clothing.programming.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterMethodExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Before Java 8
        List<Integer> evenNumbersBeforeJava8 = new ArrayList<>();
        for (Integer num : numbers) {
            if (num % 2 == 0) {
                evenNumbersBeforeJava8.add(num);
            }
        }
        System.out.println("Even numbers before Java 8: " + evenNumbersBeforeJava8);

        // Java 8 Streams (filter method)
        List<Integer> evenNumbersUsingStreams =
                numbers.stream()
                        .filter(n -> n % 2 == 0)
                        .collect(Collectors.toList());
        System.out.println("Even numbers using Streams: " + evenNumbersUsingStreams);
    }
}
