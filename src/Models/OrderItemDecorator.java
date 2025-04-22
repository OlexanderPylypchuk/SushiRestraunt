package Models;

import Models.Interface.IOrderItem;

public abstract class OrderItemDecorator implements IOrderItem {
    protected IOrderItem item;

    public OrderItemDecorator(IOrderItem item) {
        this.item = item;
    }
}
