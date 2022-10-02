package io.github.rkeeves.sauce;

import io.github.rkeeves.sauce.step.Step;
import io.github.rkeeves.sauce.step.Task;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.support.ui.WebDriverWait;

@RequiredArgsConstructor(staticName = "of")
public class Actor {

    private final WebDriverWait webDriverWait;

    public <T> Actor exec(Step<T> step) {
        step.execute(webDriverWait);
        return this;
    }

    public <T> T yield(Step<T> step) {
        return step.execute(webDriverWait);
    }

    public Void yieldVoid() {
        return null;
    }

    public <T> Actor exec(Task<T> task) {
        task.execute(this);
        return this;
    }

    public <T> T yield(Task<T> task) {
        return task.execute(this);
    }
}
