package Strategy;

import Adapters.StripePaymentAdapter;
import Strategy.Interfaces.PaymentStrategy;
import Models.Payment;
import Payment.StripeService;

public class CardPaymentStrategy implements PaymentStrategy {
    @Override
    public void pay(Payment payment) {
        System.out.println("Charging credit card for $" + payment.getAmount());
        StripePaymentAdapter adapter = new StripePaymentAdapter(new StripeService());
        adapter.ProcessPayment(payment.getAmount());
        System.out.println("Complete");
    }
}