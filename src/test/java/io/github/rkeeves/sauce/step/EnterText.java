package io.github.rkeeves.sauce.step;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RequiredArgsConstructor(staticName = "into")
public class EnterText implements Step<Void> {

    private final By target;

    private final String text;

    public Void execute(WebDriverWait await) {
        final var element = await.until(ExpectedConditions.visibilityOfElementLocated(target));
        element.sendKeys(Keys.chord(Keys.CONTROL, "A"), Keys.BACK_SPACE, text);
        return null;
    }
}
