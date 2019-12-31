package org.ibrahimhilali.TimeTracker.classes;

import org.ibrahimhilali.TimeTracker.settings.PluginState;
import org.ibrahimhilali.TimeTracker.settings.Storage;

import java.io.Serializable;

public class User implements Serializable {
    private static final String key = "4hrycPM1hSXQOTHUNLQ6UDI8ePttoZicBFXn1vwOQJM=";
    private String name;
    private String email;
    private char[] token;

    public User() {
        this("Default", "Default", "Default".toCharArray());
    }

    public User(String username, String email, String decrypt) {
        this(username, email, "Default".toCharArray());
    }

    User(char[] token) {
        this(null, null, token);
    }

    public User(String name, String email, char[] token) {
        setName(name);
        setEmail(email);
        setToken(token);
    }

    public static User getUser() {
        PluginState state = Storage.getInstance().getState();
        if (state != null) {
            return new User
                    (
                            state.username,
                            state.email,
                            Encryptors.decrypt(state.token, key)
                    );
        }
        return null;
    }

    public static void setUser(User user) {
        PluginState state = Storage.getInstance().getState();
        if (state != null) {
            state.username = user.getName();
            state.email = user.getEmail();
            state.token = Encryptors.encrypt(String.valueOf(user.getToken()), key);
        }
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

    public char[] getToken() {
        return token;
    }

    public void setToken(char[] token) {
        this.token = token;
    }
}
