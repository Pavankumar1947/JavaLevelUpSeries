package com.eclothing.clothing.programming;

import java.io.Serializable;

public class UserSerialization implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private transient String password;

    public UserSerialization(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString(){
        return username + " " + password;
    }

}
