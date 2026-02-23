package com.eclothing.clothing.programming;

import java.util.LinkedList;

public class SequenceCollectionsExample {
    public static void main(String[] args) {
        LinkedList<String> deque = new LinkedList<>();
        deque.addFirst("Java");
        deque.addLast("Python");
        deque.addFirst("JavaScript");
        deque.addLast("Dotnet");

        System.out.println("Initial deque: " + deque);  // Output: [JavaScript, Java, Python, Dotnet]

        // Access first and last elements
        System.out.println("First element: " + deque.getFirst()); // JavaScript
        System.out.println("Last element: " + deque.getLast());   // Dotnet

        // Remove elements from both ends
        String removedFirst = deque.removeFirst();
        String removedLast = deque.removeLast();

        System.out.println("Removed first: " + removedFirst); // JavaScript
        System.out.println("Removed last: " + removedLast);   // Dotnet
        System.out.println("Deque after removals: " + deque); // [Java, Python]
    }
}
