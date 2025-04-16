package Models;

import Models.Interface.OrderItem;
import Models.Interface.OrderObserver;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> items = new ArrayList<>();
    private String status;
    private final List<OrderObserver> observers = new ArrayList<>();

    // Observer management
    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(String oldStatus, String newStatus) {
        for (OrderObserver observer : observers) {
            observer.onOrderStatusChanged(this, oldStatus, newStatus);
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        String oldStatus = this.status;
        this.status = status;
        notifyObservers(oldStatus, status);
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void showOrder() {
        System.out.println("Current order: " + items);
    }

    // Memento methods
    public OrderMemento saveState() {
        return new OrderMemento(new ArrayList<>(items));
    }

    public void restoreState(OrderMemento memento) {
        this.items = new ArrayList<>(memento.getItems());
    }
}
