package com.eclothing.clothing.prog;

import java.util.Optional;

public class OptionalOfNullableDemo {
    public static void main(String[] args) {
        String name = "Pavan";
        String nullName = null;

        // Non-null value: Optional contains "Pavan"
        Optional<String> optionalName = Optional.ofNullable(name);
        System.out.println(optionalName.isPresent()); // true

        // Null value: no exception — returns Optional.empty()
        Optional<String> emptyOptional = Optional.ofNullable(nullName);
        System.out.println(emptyOptional.isPresent()); // false

        // Safe default handling
        String result = emptyOptional.orElse("Default Name");
        System.out.println(result); // Default Name
    }
}

