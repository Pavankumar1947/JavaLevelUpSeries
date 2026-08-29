package com.eclothing.clothing.prog;


import java.util.Optional;

public class OptionalIsPresentIfPresentDemo {
    public static void main(String[] args) {

        Optional<String> name = Optional.of("Pavan");
        Optional<String> emptyName = Optional.empty();

        // Example 1: isPresent() returns boolean
        boolean isNamePresent = name.isPresent();
        System.out.println("Is name present: " + isNamePresent); // true

        // Example 2: Using isPresent() with if block
        if (name.isPresent()) {
            System.out.println("Name: " + name.get()); // Name: Pavan
        }

        // Example 3: Using ifPresent()
        name.ifPresent(value -> System.out.println("Name: " + value)); // Name: Pavan

        // Example 4: Empty Optional — nothing happens, no exception
        emptyName.ifPresent(value -> System.out.println("Name: " + value));
    }
}