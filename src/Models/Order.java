package Models;

import Models.Interface.IOrderItem;
import Models.Interface.OrderObserver;
import Visitor.Visitable;
import Visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Order implements Visitable {
    private List<IOrderItem> items = new ArrayList<>();
    private int tableNumber;
    private String status;
    private int orderId;
    private static int Counter = 0;
    private final List<OrderObserver> observers = new ArrayList<>();

    public Order(){
        orderId = Counter++;
        status = "added";
    }

    public int getTableNumber() {return tableNumber;}
    public void setTableNumber(int newNumber) {tableNumber = newNumber;}

    public int getOrderId(){
        return orderId;
    }

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

    public void addItem(IOrderItem item) {
        items.add(item);
    }

    public void removeItem(IOrderItem item) {
        items.remove(item);
    }

    public List<IOrderItem> getItems() {
        return items;
    }

    public void showOrder() {
        System.out.println("Current order: " + items);
    }

    // Memento methods
    public OrderMemento saveState() {
        Order order = new Order();
        order.tableNumber = this.tableNumber;
        order.orderId = this.orderId;
        order.status = this.status;
        for (IOrderItem item : items){
            order.addItem(item);
        }
        return new OrderMemento(order);
    }

    public void restoreState(OrderMemento memento) {
        Order order = memento.getState();
        this.tableNumber = order.tableNumber;
        this.orderId = order.orderId;
        this.status = order.status;
        for (IOrderItem item : order.getItems()){
            this.addItem(item);
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (Object item : items) {
            if (item instanceof MenuItem) {
                total += ((MenuItem) item).getPrice();
            } else if (item instanceof IOrderItem) {
                total += ((IOrderItem) item).getPrice();
            }
        }
        return total;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
