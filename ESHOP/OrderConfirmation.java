package ESHOP;

public class OrderConfirmation {
    private User user;
    private Product product;
    private double amount;

    public OrderConfirmation(User user, Product product, double amount) {
        this.user = user;
        this.product = product;
        this.amount = amount;
    }

    public void send() {
        // order memo
        System.out.println("\nMEMO");
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Product: " + product.getName());
        System.out.println("Due: $" + amount);
        System.out.println();
    }
}

