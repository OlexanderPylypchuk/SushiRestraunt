package Models;

public class DineInOrderProcessor extends OrderProcessor {

    @Override
    protected void takeOrder() {
        System.out.println("Taking order at table.");
    }

    @Override
    protected boolean validatePayment() {
        System.out.println("Payment will be done after meal.");
        return true;
    }

    @Override
    protected void prepareItems() {
        System.out.println("Preparing items for dine-in.");
    }

    @Override
    protected void deliverOrder() {
        System.out.println("Serving order to table.");
    }
}