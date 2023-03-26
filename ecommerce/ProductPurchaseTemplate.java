package ecommerce;

public class ProductPurchaseTemplate {
    public void displayProduct(Product product, DiscountStrategy discountStrategy) {
        // display product information
        double discountedPrice = discountStrategy.applyDiscount(product.getPrice()); // apply 10% discount
        
        System.out.println("Product Name: " + product.getName());
        System.out.println("Product Description: " + product.getDescription());
        System.out.println("Product Price: $" + product.getPrice());

        product.setPrice(discountedPrice);

        System.out.println("Discount: " + discountStrategy.discount());

        if (discountStrategy instanceof CouponDiscountStrategy) 
            System.out.println("Discount Price: $" + discountedPrice);
            
        System.out.println("Product Image: " + product.getImage());
        System.out.println("Product Inventory: " + product.getInventory());
    }

    public void displayUserAccount(User user) {
        // display user account information
        System.out.println("Username: " + user.getName());
        System.out.println("Email: " + user.getEmail());
    }

    public void purchaseProduct(User user, Product product, PaymentStrategy paymentStrategy, DiscountStrategy discountStrategy) {
        // display product information
        displayProduct(product, discountStrategy);
        System.out.println();
        // display user account information
        displayUserAccount(user);

        // process the order using the mediator
        EcommerceMediator mediator = new EcommercePlatform();
        mediator.addUser(user);
        mediator.addProduct(product);
        mediator.processOrder(user, product, paymentStrategy);
    }
}
