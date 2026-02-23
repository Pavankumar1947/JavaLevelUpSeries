package com.eclothing.clothing.programming.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapVsFlatMapExample {
    public static void main(String[] args) {
        // Example 1: map() - Transform each element
        List<String> names = Arrays.asList("java", "spring", "stream");
        List<String> upperCaseNames =
                names.stream().map(String::toUpperCase)
                        .collect(Collectors.toList());
        System.out.println("Using map(): " + upperCaseNames);

        // Example 2: flatMap() - Flatten nested collections
        List<List<String>> data =
                Arrays.asList(Arrays.asList("Java", "Spring"),
                        Arrays.asList("Hibernate", "Streams")
                );

        List<String> flattenedList =
                data.stream()
                        .flatMap(list -> list.stream())
                        .collect(Collectors.toList());
        System.out.println("Using flatMap(): " + flattenedList);
    }
}
