package Proxy;

import Adapters.IAdapters.IPaymentAdapter;

public class PaymentProxy {
    private IPaymentAdapter paymentAdapter;

    public PaymentProxy(IPaymentAdapter adapter){
        paymentAdapter = adapter;
    }

    public boolean Payment(double amount){
        if(Math.round(amount)%2==0){
            return paymentAdapter.ProcessPayment(amount);
        }
        return false;
    }
}
