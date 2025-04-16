package Visitor;

import Models.MenuItem;
import Models.Order;

public interface Visitor {
    void visit(Order order);
    void visit(MenuItem item);
}
