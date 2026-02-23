package com.eclothing.clothing.programming.Streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountLengthOfEachWord {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "pavan", "reddy");

        Map<String, Integer> map = list.stream()
                .collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(map);

        // 2nd way
        Map<String, Integer> map1 = list.stream()
                .collect(Collectors.toMap(word -> word, word -> word.length()));
        System.out.println(map1);

    }
}
