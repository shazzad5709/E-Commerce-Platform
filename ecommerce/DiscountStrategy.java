package ecommerce;

public interface DiscountStrategy {
    double applyDiscount(double price);
    String discount();
}


