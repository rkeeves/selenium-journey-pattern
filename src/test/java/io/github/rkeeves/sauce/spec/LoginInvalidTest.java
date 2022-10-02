package io.github.rkeeves.sauce.spec;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.rkeeves.sauce.Actor;
import io.github.rkeeves.sauce.data.Users;
import io.github.rkeeves.sauce.task.login.LoginTasks;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.stream.Stream;

public class LoginInvalidTest {

    static WebDriver webDriver;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @AfterAll
    static void afterAll() {
        webDriver.quit();
    }

    @ParameterizedTest
    @MethodSource
    void errorMessageShouldBeShownForMissingFields(String username, String password, String errorMessage) {
        final var webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5L), Duration.ofMillis(400L));
        Actor.of(webDriverWait)
                .exec(LoginTasks.visit())
                .exec(LoginTasks.fillUsernameAndPassword(username, password))
                .exec(LoginTasks.submit())
                .exec(LoginTasks.shouldShowErrorMessage(errorMessage));
    }

    static Stream<Arguments> errorMessageShouldBeShownForMissingFields() {
        return Stream.of(
                Arguments.of("", "",
                        "Epic sadface: Username is required"),
                Arguments.of("", "a",
                        "Epic sadface: Username is required"),
                Arguments.of("a", "",
                        "Epic sadface: Password is required"),
                Arguments.of("unknown", Users.standard().getPassword(),
                        "Epic sadface: Username and password do not match any user in this service"),
                Arguments.of(Users.standard().getUsername(), "badpassword",
                        "Epic sadface: Username and password do not match any user in this service")
        );
    }

    @ParameterizedTest
    @MethodSource
    void usernameFieldErrorShouldBeShown(String username, String password) {
        final var webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5L), Duration.ofMillis(400L));
        Actor.of(webDriverWait)
                .exec(LoginTasks.visit())
                .exec(LoginTasks.fillUsernameAndPassword(username, password))
                .exec(LoginTasks.submit())
                .exec(LoginTasks.shouldShowFieldErrorForUsername());
    }

    static Stream<Arguments> usernameFieldErrorShouldBeShown() {
        return Stream.of(
                Arguments.of("", ""),
                Arguments.of("", "a"),
                Arguments.of("a", ""),
                Arguments.of(Users.standard().getUsername(), "garbage")
        );
    }

    @ParameterizedTest
    @MethodSource
    void passwordFieldErrorShouldBeShown(String username, String password) {
        final var webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5L), Duration.ofMillis(400L));
        Actor.of(webDriverWait)
                .exec(LoginTasks.visit())
                .exec(LoginTasks.fillUsernameAndPassword(username, password))
                .exec(LoginTasks.submit())
                .exec(LoginTasks.shouldShowFieldErrorForPassword());
    }

    static Stream<Arguments> passwordFieldErrorShouldBeShown() {
        return Stream.of(
                Arguments.of("", ""),
                Arguments.of("", "a"),
                Arguments.of("a", ""),
                Arguments.of(Users.standard().getUsername(), "garbage")
        );
    }
}
