package ESHOP;

public interface EcommerceMediator {
    public void addUser(User user);
    public void addProduct(Product product);
    public void processOrder(User user, Product product, PaymentStrategy paymentStrategy);
}