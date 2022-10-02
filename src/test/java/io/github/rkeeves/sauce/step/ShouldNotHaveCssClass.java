package io.github.rkeeves.sauce.step;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.attributeContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.not;

@RequiredArgsConstructor(staticName = "on")
public class ShouldNotHaveCssClass implements Step<Void> {

    private final By by;

    private final String cssClass;

    @Override
    public Void execute(WebDriverWait webDriverWait) {
        webDriverWait.until(not(attributeContains(by, "class", cssClass)));
        return null;
    }
}