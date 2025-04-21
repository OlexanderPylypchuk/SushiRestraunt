package Adapters;

import Adapters.IAdapters.IPaymentAdapter;

public class PaymentProxyAdapter implements IPaymentAdapter {
    private final PaypalIPaymentAdapter realPaymentAdapter;

    public PaymentProxyAdapter(PaypalIPaymentAdapter realPaymentAdapter){
        this.realPaymentAdapter = realPaymentAdapter;
    }

    @Override
    public boolean processPayment(double amount){
        // Example proxy behavior
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        return realPaymentAdapter.processPayment(amount);
    }
}
