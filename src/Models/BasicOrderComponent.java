package Models;

import Models.Interface.IOrderComponent;

public class BasicOrderComponent implements IOrderComponent {
    private String name;
    private double price;

    public BasicOrderComponent(String name, double price) {
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