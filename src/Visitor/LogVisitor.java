package Visitor;

import Models.MenuItem;
import Models.Order;

public class LogVisitor {
    public class ReportVisitor implements Visitor {

        @Override
        public void visit(Order order) {
            System.out.println("Order Report:");
            System.out.println(" - Order ID: " + order.getOrderId());
            System.out.println(" - Total: " + order.calculateTotal());
            // etc.
        }

        @Override
        public void visit(MenuItem item) {
            System.out.println("Menu Item Report:");
            System.out.println(" - Name: " + item.getName());
            System.out.println(" - Price: " + item.getPrice());
            // etc.
        }
    }
}
