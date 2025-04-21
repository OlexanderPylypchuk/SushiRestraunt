package Adapters;

import Adapters.IAdapters.IPaymentAdapter;

public class PaymentProxyAdapter implements IPaymentAdapter {
    private IPaymentAdapter paymentAdapter;

    public PaymentProxyAdapter(IPaymentAdapter adapter){
        paymentAdapter = adapter;
    }

    public boolean ProcessPayment(double amount){
        //custom proxy logic, mostly for defence
        return paymentAdapter.ProcessPayment(amount);
    }
}
