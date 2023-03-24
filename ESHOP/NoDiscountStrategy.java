package ESHOP;

public class NoDiscountStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        return amount; // no discount
    }

    @Override
    public String discount() {
        return "Null";
    }
}
