package Models.Interface;

import Components.Component;

public interface Mediator {
    void notify(Component sender, String event);
}