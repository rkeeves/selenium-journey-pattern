package io.github.rkeeves.sauce.data;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Users {

    private static final User STANDARD = User.ofUsername("standard_user");

    private static final User LOCKED_OUT = User.ofUsername("locked_out_user");

    private static final User PROBLEM = User.ofUsername("problem_user");

    private static final User PERFORMANCE_GLITCH = User.ofUsername("performance_glitch_user");

    public static User standard() {
        return STANDARD;
    }

    public static User lockedOut() {
        return LOCKED_OUT;
    }
}
