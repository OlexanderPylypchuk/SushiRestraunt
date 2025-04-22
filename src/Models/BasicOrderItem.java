package Models;

import Models.Interface.IOrderItem;

public class BasicOrderItem implements IOrderItem {
    private String name;
    private double price;

    public BasicOrderItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getDescription() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}