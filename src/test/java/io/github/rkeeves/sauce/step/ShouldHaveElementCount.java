package io.github.rkeeves.sauce.step;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RequiredArgsConstructor(staticName = "of")
public class ShouldHaveElementCount implements Step<Void> {

    private final By by;

    private final int expected;

    @Override
    public Void execute(WebDriverWait webDriverWait) {
        webDriverWait.until(ExpectedConditions.numberOfElementsToBe(by, expected));
        return null;
    }
}
