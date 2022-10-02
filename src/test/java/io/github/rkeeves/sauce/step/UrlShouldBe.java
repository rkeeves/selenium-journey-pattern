package io.github.rkeeves.sauce.step;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RequiredArgsConstructor(staticName = "theFollowing")
public class UrlShouldBe implements Step<Void> {

    private final String url;

    @Override
    public Void execute(WebDriverWait webDriverWait) {
        webDriverWait.until(ExpectedConditions.urlToBe(url));
        return null;
    }
}
