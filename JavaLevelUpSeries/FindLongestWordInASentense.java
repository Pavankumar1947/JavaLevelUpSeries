package com.eclothing.clothing.programming.Streams;

import java.util.Arrays;
import java.util.Comparator;

public class FindLongestWordInASentense {
    public static void main(String[] args) {
        String input = "Hello welcome to Pushpas programming";

        String str = Arrays.stream(input.split(" "))
                .max(Comparator.comparingInt(String::length))
                .orElse("");
        System.out.println(str);
    }
}
