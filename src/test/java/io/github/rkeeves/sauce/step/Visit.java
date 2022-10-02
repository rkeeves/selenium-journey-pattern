package io.github.rkeeves.sauce.step;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

@RequiredArgsConstructor(staticName = "theUrl")
public class Visit implements Step<Void> {

    private final String url;

    public Void execute(WebDriverWait await) {
        await.until(Function.identity()).navigate().to(url);
        return null;
    }
}