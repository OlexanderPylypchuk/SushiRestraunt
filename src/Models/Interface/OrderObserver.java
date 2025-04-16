package Models.Interface;

import Models.Order;

public interface OrderObserver {
    void onOrderStatusChanged(Order order, String oldStatus, String newStatus);
}