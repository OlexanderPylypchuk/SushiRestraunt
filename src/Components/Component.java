package Components;

import Models.Interface.OrderMediator;

public abstract class Component {
    protected OrderMediator mediator;

    public Component(OrderMediator mediator) {
        this.mediator = mediator;
    }
}
