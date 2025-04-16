package Strategy;

import Strategy.Interfaces.PaymentStrategy;
import Models.Payment;

public class CardPaymentStrategy implements PaymentStrategy {
    @Override
    public void pay(Payment payment) {
        System.out.println("Charging credit card for $" + payment.getAmount());
        // simulate card charge, use tokenization if needed
    }
}