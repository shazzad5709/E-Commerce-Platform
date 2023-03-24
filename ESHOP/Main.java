package ESHOP;

public class Main {
    public static void main(String[] args) {
        // create a user
        User user = new User("John Doe", "john.doe@boohoo.com", "password", "Maine Lane");

        // create a product
        Product product = new Product("Ryzen 9", "Ryzen 7 5990X", 999.00, "<image of ryzen 9>", 10);
        
        //create discount strategies
        DiscountStrategy discountStrategy = new NoDiscountStrategy();

        // create payment strategies
        PaymentStrategy creditCardPaymentStrategy = new CreditCardPaymentStrategy("7457 9038 8123 6313", "12/24", "570");
        PaymentStrategy payPalPaymentStrategy = new PayPalPaymentStrategy("john.doe@boohoo.com", "password");
        PaymentStrategy cryptocurrencyPaymentStrategy = new CryptocurrencyPaymentStrategy("0x5B38Da6a701c568545dCfcB03FcB875f56beddC4");

        // create a product purchase template
        ProductPurchaseTemplate productPurchaseTemplate = new ProductPurchaseTemplate() {};

        //purchase the product using a credit card
        System.out.println("\n-----Credit Card Purchase-----\n");
        productPurchaseTemplate.purchaseProduct(user, product, creditCardPaymentStrategy, discountStrategy);

        // purchase the product using PayPal
        System.out.println("\n-----PayPal Purchase-----\n");
        productPurchaseTemplate.purchaseProduct(user, product, payPalPaymentStrategy, discountStrategy);

        // purchase the product using cryptocurrency
        System.out.println("\n-----Cryptocurrency Purchase-----\n");
        productPurchaseTemplate.purchaseProduct(user, product, cryptocurrencyPaymentStrategy, discountStrategy);

        // ProductPurchaseTemplate productPurchase = new ProductPurchaseWithPromotion();

        PaymentStrategy paymentStrategy = new CreditCardPaymentStrategy("4823 0081 2797 7542", "12/23", "258");
        
        // purchase the product with promotion
        productPurchaseTemplate.purchaseProduct(user, product, paymentStrategy, discountStrategy);    
    }
}
