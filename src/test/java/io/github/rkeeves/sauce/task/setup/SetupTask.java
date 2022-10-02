package io.github.rkeeves.sauce.task.setup;

import io.github.rkeeves.sauce.data.User;
import io.github.rkeeves.sauce.step.Task;
import io.github.rkeeves.sauce.task.inventory.InventoryTasks;
import io.github.rkeeves.sauce.task.login.LoginTasks;

public class SetupTask {

    public static Task<Void> logMeIn(User user) {
        return actor -> actor
                .exec(LoginTasks.visit())
                .exec(LoginTasks.fillUsernameAndPassword(user))
                .exec(LoginTasks.submit())
                .exec(InventoryTasks.shouldBeAt())
                .yieldVoid();
    }
}
