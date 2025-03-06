package Adapters;

import Adapters.IAdapters.IPaymentAdapter;
import Payment.PayPalService;

public class PaypalIPaymentAdapter implements IPaymentAdapter {
    private PayPalService payPalService;

    public PaypalIPaymentAdapter(PayPalService payPalService) {
        this.payPalService = payPalService;
    }

    @Override
    public boolean ProcessPayment(double amount) {
        return payPalService.SendPayment(amount);
    }
}
