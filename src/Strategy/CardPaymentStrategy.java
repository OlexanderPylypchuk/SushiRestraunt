package Strategy;

import Adapters.StripePaymentAdapter;
import Proxy.PaymentProxy;
import Strategy.Interfaces.PaymentStrategy;
import Models.Payment;
import Payment.StripeService;

public class CardPaymentStrategy implements PaymentStrategy {
    @Override
    public void pay(Payment payment) {
        System.out.println("Charging credit card for $" + payment.getAmount());
        PaymentProxy proxy = new PaymentProxy(new StripePaymentAdapter(new StripeService()));
        proxy.Payment(payment.getAmount());
        System.out.println("Complete");
    }
}