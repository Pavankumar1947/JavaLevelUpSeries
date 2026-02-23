package com.eclothing.clothing.programming;

public class VarargsExample {
    @SafeVarargs
    private static <T> void printAll(T... items) {
        for (T i : items) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        printAll("Java", "Varargs", "SafeVarargs"); // Java Varargs SafeVarargs
        printAll("OneValue");                       // OneValue
        printAll();                                        //
    }
}





