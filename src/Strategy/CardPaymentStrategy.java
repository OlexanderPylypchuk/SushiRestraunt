package Strategy;

import Adapters.PaymentProxyAdapter;
import Adapters.PaypalIPaymentAdapter;
import Strategy.Interfaces.PaymentStrategy;
import Models.Payment;
import Payment.PayPalService;

public class CardPaymentStrategy implements PaymentStrategy {
    @Override
    public void pay(Payment payment) {
        System.out.println("Charging credit card for $" + payment.getAmount());
        PaymentProxyAdapter proxy = new PaymentProxyAdapter(new PaypalIPaymentAdapter(new PayPalService()));
        proxy.processPayment(payment.getAmount());
        System.out.println("Complete");
    }
}