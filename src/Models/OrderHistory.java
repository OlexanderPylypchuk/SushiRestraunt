package Models;

import java.util.Stack;

public class OrderHistory {
    private Order originator;
    private final Stack<OrderMemento> history = new Stack<>();

    public void save(OrderMemento memento) {
        originator = memento.getState();
        history.push(memento);
    }

    public OrderMemento undo() {
        if (!history.isEmpty()) {
            OrderMemento m = history.pop();
            originator = m.getState();
            return m;
        }
        return null;
    }
}