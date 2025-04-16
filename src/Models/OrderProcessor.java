package Models;

public abstract class OrderProcessor {

    // Template method
    public final void processOrder() {
        takeOrder();
        if (validatePayment()) {
            prepareItems();
            deliverOrder();
            sendReceipt();
        } else {
            cancelOrder();
        }
    }

    protected abstract void takeOrder();
    protected abstract boolean validatePayment();
    protected abstract void prepareItems();
    protected abstract void deliverOrder();

    protected void sendReceipt() {
        System.out.println("Sending receipt to customer.");
    }

    protected void cancelOrder() {
        System.out.println("Payment failed. Order cancelled.");
    }
}
