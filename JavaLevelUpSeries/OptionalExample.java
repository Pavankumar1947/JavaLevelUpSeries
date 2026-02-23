package com.eclothing.clothing.programming;

import java.util.Optional;

class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

public class OptionalExample {
    public static void main(String[] args) {

        User user = new User("pavan");

        String username = Optional.ofNullable(user)
                .map(User::getUsername)
                .orElse("DEFAULT_USER");

        System.out.println(username);
    }
}

