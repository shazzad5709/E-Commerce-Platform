package ecommerce;

public class CryptocurrencyPaymentStrategy implements PaymentStrategy {
    private String address;

    public CryptocurrencyPaymentStrategy(String address) {
        this.address = address;
    }

    public void pay(double amount) {
        System.out.println("Processing cryptocurrency payment of $" + amount + "...");
    }

    public String displayPaymentDetails() {
        return "Cryptocurrency\n Address: " + address;
    }
}