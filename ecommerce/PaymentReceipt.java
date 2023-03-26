package ecommerce;

public class PaymentReceipt {
    private User user;
    private Product product;
    private double amount;
    private PaymentStrategy paymentStrategy;

    public PaymentReceipt(User user, Product product, double amount, PaymentStrategy paymentStrategy) {
        this.user = user;
        this.product = product;
        this.amount = amount;
        this.paymentStrategy = paymentStrategy;
    }

    public void send() {
        // Send payment receipt email to user
        String paymentMethod;
        if (paymentStrategy instanceof CreditCardPaymentStrategy) {
            paymentMethod = "Credit Card";
        } else if (paymentStrategy instanceof PayPalPaymentStrategy) {
            paymentMethod = "PayPal";
        } else if (paymentStrategy instanceof CryptocurrencyPaymentStrategy) {
            paymentMethod = "Cryptocurrency";
        } else {
            paymentMethod = "Unknown";
        }

        // Payment receipt
        System.out.println("\n\n-----Receipt-----\n");
        System.out.println("Name: " + user.getName() + ",");
        System.out.println("Product: " + product.getName());
        System.out.println("Paid: $" + amount);
        System.out.println("Payment Method: " + paymentMethod);
        System.out.println("Payment Details: " + paymentStrategy.displayPaymentDetails());
        System.out.println();
    }
}
