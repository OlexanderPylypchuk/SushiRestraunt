package Models;

public class Payment {
    public Payment(String method, double amount){
        this.method = method;
        this.amount = amount;
    }
    private String method; // "cash", "card", "wallet"
    private double amount;
    public String getMethod(){
        return  method;
    }
    public double getAmount(){
        return amount;
    }
}
