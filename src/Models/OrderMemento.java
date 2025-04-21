package Models;

import Models.Interface.OrderItem;

import java.util.List;

public class OrderMemento {
    private Order state;

    public OrderMemento(Order state) {
        this.state = state;
    }

    public Order getState() {
        return state;
    }
}
