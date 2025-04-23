package Visitor;

import Models.MenuItem;
import Models.Order;

public class LogVisitor implements Visitor {
    @Override
    public void visit(Order order) {
        System.out.println("Order report:");
        System.out.println(" - Order Id: " + order.getOrderId());
        System.out.println(" - Total: " + order.calculateTotal());
    }

    @Override
    public void visit(MenuItem item) {
        System.out.println("Menu item report:");
        System.out.println(" - Name: " + item.getName());
        System.out.println(" - Price: " + item.getPrice());
    }
}
