package Models;

import Models.Interface.OrderObserver;

public class LoggerObserver implements OrderObserver {
    @Override
    public void onOrderStatusChanged(Order order, String oldStatus, String newStatus) {
        System.out.println("[Logger] Order status changed from " + oldStatus + " to " + newStatus);
    }
}
