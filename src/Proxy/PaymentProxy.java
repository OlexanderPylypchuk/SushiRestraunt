package Proxy;

import Adapters.IAdapters.IPaymentAdapter;

public class PaymentProxy {
    private IPaymentAdapter paymentAdapter;

    public PaymentProxy(IPaymentAdapter adapter){
        paymentAdapter = adapter;
    }

    public boolean Payment(double amount){
        //custom proxy logic, mostly for defence
        return paymentAdapter.ProcessPayment(amount);
    }
}
