package Models;

import Models.Interface.IOrderComponent;

public class ExtraWasabiDecorator extends OrderDecorator {
    public ExtraWasabiDecorator(IOrderComponent component) {
        super(component);
    }

    public String getDescription() {
        return component.getDescription() + ", extra wasabi";
    }

    public double getPrice() {
        return component.getPrice() + 5.0; // extra cost
    }
}
