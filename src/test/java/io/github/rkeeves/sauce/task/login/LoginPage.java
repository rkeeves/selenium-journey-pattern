package io.github.rkeeves.sauce.task.login;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.By;

@UtilityClass
class LoginPage {

    static final String PAGE_URL = "https://www.saucedemo.com/";

    static final By USERNAME = By.cssSelector("*[data-test='username']");

    static final By PASSWORD = By.cssSelector("*[data-test='password']");

    static final By LOGIN_BUTTON = By.cssSelector("*[data-test='login-button']");

    static final By ERROR_MESSAGE = By.cssSelector("h3[data-test='error']");

    static final String INPUT_ERROR_CSS_CLASS = "input_error";
}
