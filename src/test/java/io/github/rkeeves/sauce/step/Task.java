package io.github.rkeeves.sauce.step;

import io.github.rkeeves.sauce.Actor;

public interface Task<T> {

    T execute(Actor actor);
}
