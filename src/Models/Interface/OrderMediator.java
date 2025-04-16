package Models.Interface;

import Components.Component;

public interface OrderMediator {
    void notify(Component sender, String event);
}