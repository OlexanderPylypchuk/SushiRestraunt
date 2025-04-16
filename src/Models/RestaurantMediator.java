package Models;

import Components.Component;
import Components.Delivery;
import Components.Kitchen;
import Models.Interface.OrderMediator;

public class RestaurantMediator implements OrderMediator {
    private Kitchen kitchen;
    private Delivery delivery;

    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    @Override
    public void notify(Component sender, String event) {
        if (sender == kitchen && event.equals("prepared")) {
            delivery.deliverOrder();
        } else if (sender == delivery && event.equals("delivered")) {
            System.out.println("[Mediator] Order completed!");
        }
    }
}