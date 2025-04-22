package Models;

public class OrderMemento {
    private Order state;

    public OrderMemento(Order state) {
        this.state = state;
    }

    public Order getState() {
        return state;
    }
}
