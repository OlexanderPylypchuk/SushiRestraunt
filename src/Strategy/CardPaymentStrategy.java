package Strategy;

import Adapters.PaymentProxyAdapter;
import Adapters.StripePaymentAdapter;
import Strategy.Interfaces.PaymentStrategy;
import Models.Payment;
import Payment.StripeService;

public class CardPaymentStrategy implements PaymentStrategy {
    @Override
    public void pay(Payment payment) {
        System.out.println("Charging credit card for $" + payment.getAmount());
        PaymentProxyAdapter proxy = new PaymentProxyAdapter(new StripePaymentAdapter(new StripeService()));
        proxy.processPayment(payment.getAmount());
        System.out.println("Complete");
    }
}