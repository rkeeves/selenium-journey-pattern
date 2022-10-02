package io.github.rkeeves.sauce.task.login;

import io.github.rkeeves.sauce.data.User;
import io.github.rkeeves.sauce.step.*;
import lombok.experimental.UtilityClass;

@UtilityClass
public class LoginTasks {

    public static Task<Void> visit() {
        return actor -> actor
                .exec(Visit.theUrl(LoginPage.PAGE_URL))
                .exec(UrlShouldBe.theFollowing(LoginPage.PAGE_URL))
                .yieldVoid();
    }

    public static Task<Void> fillUsernameAndPassword(User user) {
        return actor -> actor
                .exec(EnterText.into(LoginPage.USERNAME, user.getUsername()))
                .exec(EnterText.into(LoginPage.PASSWORD, user.getPassword()))
                .yieldVoid();
    }

    public static Task<Void> fillUsernameAndPassword(String username, String password) {
        return actor -> actor
                .exec(EnterText.into(LoginPage.USERNAME, username))
                .exec(EnterText.into(LoginPage.PASSWORD, password))
                .yieldVoid();
    }

    public static Task<Void> submit() {
        return actor -> actor
                .exec(Click.on(LoginPage.LOGIN_BUTTON))
                .yieldVoid();
    }

    public static Task<Void> shouldShowErrorMessage(String message) {
        return actor -> actor
                .exec(ShouldHaveText.on(LoginPage.ERROR_MESSAGE, message))
                .yieldVoid();
    }

    public static Task<Void> shouldShowFieldErrorForUsername() {
        return actor -> actor
                .exec(ShouldHaveCssClass.on(LoginPage.USERNAME, LoginPage.INPUT_ERROR_CSS_CLASS))
                .yieldVoid();
    }

    public static Task<Void> shouldShowFieldErrorForPassword() {
        return bot -> bot
                .exec(ShouldHaveCssClass.on(LoginPage.PASSWORD, LoginPage.INPUT_ERROR_CSS_CLASS))
                .yieldVoid();
    }
}
