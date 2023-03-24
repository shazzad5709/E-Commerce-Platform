package ESHOP;

public class PayPalPaymentStrategy implements PaymentStrategy {
    private String email;
    private String password;

    public PayPalPaymentStrategy(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void pay(double amount) {
        System.out.println("Processing PayPal payment of $" + amount + "...");
    }
}