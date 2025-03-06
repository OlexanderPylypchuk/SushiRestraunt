package Adapters;

import Adapters.IAdapters.IPaymentAdapter;
import Payment.StripeService;

public class StripePaymentAdapter implements IPaymentAdapter {
    private StripeService stripeService;

    public StripePaymentAdapter(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    @Override
    public boolean ProcessPayment(double amount) {
        try{
            stripeService.ProcessPayment(amount);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }
}
