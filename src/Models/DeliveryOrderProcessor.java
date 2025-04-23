package Models;

public class DeliveryOrderProcessor extends OrderProcessor {

    @Override
    protected void takeOrder() {
        System.out.println("Taking order via online system.");
    }

    @Override
    protected boolean validatePayment() {
        System.out.println("Validating payment");
        return true;
    }

    @Override
    protected void prepareItems() {
        System.out.println("Preparing items for delivery.");
    }

    @Override
    protected void deliverOrder() {
        System.out.println("Dispatching order to courier.");
    }
}
