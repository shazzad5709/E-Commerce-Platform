package ecommerce;

public class CouponDiscountStrategy implements DiscountStrategy {
  private String couponCode;
  private double discountPercentage;

  public CouponDiscountStrategy(String couponCode, double discountPercentage) {
      this.couponCode = couponCode;
      this.discountPercentage = discountPercentage;
  }

  @Override
  public double applyDiscount(double price) {
      if (couponCode != null && couponCode.equals("SUMMER2021")) {
          return price * (1 - discountPercentage);
      } else {
          return price;
      }
  }

  @Override
  public String discount() {
      return discountPercentage * 100 + "%";
  }
}