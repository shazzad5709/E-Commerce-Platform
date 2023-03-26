package ecommerce;

public interface PaymentStrategy {
    public void pay(double amount);

    public String displayPaymentDetails();
}
