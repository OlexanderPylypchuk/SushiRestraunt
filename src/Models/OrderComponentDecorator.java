package Models;

import Models.Interface.IOrderComponent;

public abstract class OrderComponentDecorator implements IOrderComponent {
    protected IOrderComponent component;

    public OrderComponentDecorator(IOrderComponent item) {
        this.component = component;
    }
}
