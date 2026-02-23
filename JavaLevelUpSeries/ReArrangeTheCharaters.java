package com.eclothing.clothing.programming.Streams;

import java.util.stream.Collectors;

public class ReArrangeTheCharaters {
    public static void main(String[] args) {
        String input = "pavan";

        String output = input.chars()
                .sorted()
                .mapToObj(c->String.valueOf((char)c))
                .collect(Collectors.joining());
        System.out.println(output);
    }
}