package Models;

public class Payment {
    public Payment(double amount){
        this.amount = amount;
    }
    private double amount;
    public double getAmount(){
        return amount;
    }
}
