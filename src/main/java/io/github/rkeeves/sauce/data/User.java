package io.github.rkeeves.sauce.data;

import lombok.Data;

@Data
public class User {

    private final String username;

    private final String password;

    public static User ofUsername(String username) {
        return new User(username, "secret_sauce");
    }
}
