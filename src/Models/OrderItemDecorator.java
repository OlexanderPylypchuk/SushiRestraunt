package Models;

import Models.Interface.OrderItem;

public abstract class OrderItemDecorator implements OrderItem {
    protected OrderItem item;

    public OrderItemDecorator(OrderItem item) {
        this.item = item;
    }
}
