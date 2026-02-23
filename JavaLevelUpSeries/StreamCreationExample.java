package com.eclothing.clothing.programming.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreationExample {
    public static void main(String[] args) {

        // 1. Creating Stream from a Collection
        List<String> names = Arrays.asList("Java", "Spring", "Hibernate");
        names.stream().forEach(System.out::println);

        // 2. Creating Stream from an Array
        int[] numbers = {1, 2, 3, 4, 5};
        Arrays.stream(numbers).forEach(System.out::println);

        // 3. Creating Stream using Stream.of()
        Stream.of("A", "B", "C").forEach(System.out::println);

        // 4. Primitive Streams (IntStream, LongStream, DoubleStream)
        IntStream.range(1, 6).forEach(System.out::println);

        // 5. Infinite Stream using iterate()
        Stream.iterate(1, n -> n + 1)
                .limit(5)
                .forEach(System.out::println);
    }
}
