package Models;

import Models.Interface.OrderItem;

import java.util.List;

public class OrderMemento {
    private final List<OrderItem> items;

    public OrderMemento(List<OrderItem> items) {
        this.items = items;
    }

    public List<OrderItem> getItems() {
        return items;
    }
}
