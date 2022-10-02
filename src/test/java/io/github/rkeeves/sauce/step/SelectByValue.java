package io.github.rkeeves.sauce.step;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

@RequiredArgsConstructor(staticName = "on")
public class SelectByValue implements Step<Void> {

    private final By by;

    private final String optionValueToSelect;

    @Override
    public Void execute(WebDriverWait webDriverWait) {
        final var select = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        new Select(select).selectByValue(optionValueToSelect);
        return null;
    }
}
