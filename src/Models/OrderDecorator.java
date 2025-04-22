package Models;

import Models.Interface.IOrderComponent;

public abstract class OrderDecorator implements IOrderComponent {
    protected IOrderComponent component;

    public OrderDecorator(IOrderComponent component) {
        this.component = component;
    }

    @Override
    public String getDescription() {
        return component.getDescription();
    }

    @Override
    public double getPrice() {
        return component.getPrice();
    }
}
