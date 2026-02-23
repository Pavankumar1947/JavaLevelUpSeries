package com.eclothing.clothing.programming.Streams;


import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseAStringWordByWord {
    public static void main(String[] args) {
        String str = " Java Streams API";

        String result = Arrays.stream(str.split(" "))
                .map(word->new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
        System.out.println(result);

    }
}
