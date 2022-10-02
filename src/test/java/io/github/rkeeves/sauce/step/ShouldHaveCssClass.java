package io.github.rkeeves.sauce.step;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RequiredArgsConstructor(staticName = "on")
public class ShouldHaveCssClass implements Step<Void> {

    private final By by;

    private final String cssClass;

    @Override
    public Void execute(WebDriverWait webDriverWait) {
        webDriverWait.until(ExpectedConditions.attributeContains(by, "class", cssClass));
        return null;
    }
}
