package io.github.rkeeves.sauce.step;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RequiredArgsConstructor(staticName = "on")
public class ShouldHaveText implements Step<Void> {

    private final By by;

    private final String expectedText;

    @Override
    public Void execute(WebDriverWait webDriverWait) {
        webDriverWait.until(ExpectedConditions.textToBePresentInElementLocated(by, expectedText));
        return null;
    }
}