package ESHOP;

public class FiftyPercentDiscountStrategy implements DiscountStrategy{
  @Override
    public double applyDiscount(double amount) {
        return amount * 0.5; // apply 10% discount
    }

  @Override
  public String discount() {
    return "50%";
  }
}
