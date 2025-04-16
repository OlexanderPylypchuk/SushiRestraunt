package Strategy;

import Models.Payment;
import Strategy.Interfaces.PaymentStrategy;

public class CashPaymentStrategy implements PaymentStrategy {
    @Override
    public void pay(Payment payment) {
        System.out.println("Processing cash payment of $" + payment.getAmount());
        System.out.println("Complete");
    }
}