package Models;

import java.util.Stack;

public class OrderHistory {
    private Stack<OrderMemento> history = new Stack<>();

    public void save(OrderMemento memento) {
        history.push(memento);
    }

    public OrderMemento undo() {
        if (!history.isEmpty()) {
            return history.pop();
        }
        return null;
    }
}