package Test;

// ✅ Facade Class
public class RestaurantFacadeImpl implements RestaurantFacade {
    private Kitchen kitchen;
    private PaymentSystem payment;
    private DeliverySystem delivery;

    public RestaurantFacadeImpl() {
        kitchen = new Kitchen();
        payment = new PaymentSystem();
        delivery = new DeliverySystem();
    }

    @Override
    public void completeOrder() {
        kitchen.prepareOrder();
        payment.pay(100);
        delivery.deliver();
    }
}
