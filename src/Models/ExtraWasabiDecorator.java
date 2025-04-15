package Models;

import Models.Interface.OrderItem;

public class ExtraWasabiDecorator extends OrderItemDecorator {
    public ExtraWasabiDecorator(OrderItem item) {
        super(item);
    }

    public String getDescription() {
        return item.getDescription() + ", extra wasabi";
    }

    public double getPrice() {
        return item.getPrice() + 5.0; // extra cost
    }
}
