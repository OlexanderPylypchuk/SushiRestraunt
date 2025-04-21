package Proxy;

import Adapters.IAdapters.IPaymentAdapter;

public class PaymentProxy implements IPaymentAdapter {
    private IPaymentAdapter paymentAdapter;

    public PaymentProxy(IPaymentAdapter adapter){
        paymentAdapter = adapter;
    }

    public boolean ProcessPayment(double amount){
        //custom proxy logic, mostly for defence
        return paymentAdapter.ProcessPayment(amount);
    }
}
