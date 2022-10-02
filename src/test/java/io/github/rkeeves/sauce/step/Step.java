package io.github.rkeeves.sauce.step;

import org.openqa.selenium.support.ui.WebDriverWait;

public interface Step<T> {

    T execute(WebDriverWait webDriverWait);
}
