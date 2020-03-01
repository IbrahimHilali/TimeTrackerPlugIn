package org.ibrahimhilali.TimeTracker.classes;

import com.google.gson.Gson;

public class User {
    private static final String key = "4hrycPM1hSXQOTHUNLQ6UDI8ePttoZicBFXn1vwOQJM=";
    private String name;
    private String email;
    private String token;

    User() {
    }

    User(String token) {
        this(null, null, token);
    }

    public User(String name, String email, String token) {
        setName(name);
        setEmail(email);
        setToken(token);
    }

    @Override
    public String toString() {
        return (new Gson()).toJson(this);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
