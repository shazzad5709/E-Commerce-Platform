package ecommerce;

import java.util.ArrayList;
import java.util.List;

public class EcommercePlatform implements EcommerceMediator {
    private List<User> users;
    private List<Product> products;

    public EcommercePlatform() {
        this.users = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void processOrder(User user, Product product, PaymentStrategy paymentStrategy) {
        if (products.contains(product) && users.contains(user)) {
            if (product.getInventory() > 0) {
                product.setInventory(product.getInventory() - 1);
                double amount = product.getPrice();

                // send order confirmation and payment receipt to the user
                OrderConfirmation orderConfirmation = new OrderConfirmation(user, product, amount);
                PaymentReceipt paymentReceipt = new PaymentReceipt(user, product, amount, paymentStrategy);

                orderConfirmation.send();
                paymentStrategy.pay(amount);
                paymentReceipt.send();
            }
            else {
                // inform the user that the product is out of stock
                System.out.println("Sorry, the product is out of stock.");
            }
        }
        else {
            // inform the user that the product or user is not found
            System.out.println("Sorry, we could not process your order. Please try again later.");
        }
    }
}
