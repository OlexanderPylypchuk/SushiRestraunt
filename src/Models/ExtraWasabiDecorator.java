package Models;

import Models.Interface.IOrderItem;

public class ExtraWasabiDecorator extends OrderItemDecorator {
    public ExtraWasabiDecorator(IOrderItem item) {
        super(item);
    }

    public String getDescription() {
        return item.getDescription() + ", extra wasabi";
    }

    public double getPrice() {
        return item.getPrice() + 5.0; // extra cost
    }
}
