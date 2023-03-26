package ecommerce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // create users
        User user1 = new User("Octane", "octane@skirmisher.com", "launchpad", "Psamathe");
        User user2 = new User("Valkyrie", "valkyrie@skirmisher.com", "skywarddive", "Angelia");
        User user3 = new User("Catalyst", "catalyst@controller.com", "darkveil", "Boreas");

        // add users to list
        ArrayList<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        // create products
        Product product1 = new Product("R99", "SMG Light", 1999.00, "<image of R99>", 10);
        Product product2 = new Product("Mastiff", "Shotgun", 1099.00, "<image of Mastiff>", 5);
        Product product3 = new Product("Flatline", "AR Heavy", 1199.00, "<image of Flatline>", 8);

        // add products to list
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);

        // create discount strategies
        DiscountStrategy noDiscountStrategy = new NoDiscountStrategy();
        DiscountStrategy couponDiscountStrategy = new CouponDiscountStrategy("SPRING23", 0.2);

        // create payment strategies
        PaymentStrategy creditCardPaymentStrategy = new CreditCardPaymentStrategy("7457 9038 8123 6313", "12/24",
                "570");
        PaymentStrategy payPalPaymentStrategy = new PayPalPaymentStrategy("catalyst@controller.com", "darkveil");
        PaymentStrategy cryptocurrencyPaymentStrategy = new CryptocurrencyPaymentStrategy(
                "0x5B38Da6a701c568545dCfcB03FcB875f56beddC4");

        try (// create scanner object for user input
                Scanner scanner = new Scanner(System.in)) {
            // prompt user to login or create new account
            System.out.println("\n-----Welcome to Apex Shop!-----\n");
            System.out.println("1. Login");
            System.out.println("2. Create new account");
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();

            // handle user choice
            User currentUser = null;
            if (choice == 1) {
                // prompt user to enter email and password
                System.out.print("\nEnter your email: ");
                String email = scanner.next();
                System.out.print("Enter your password: ");
                String password = scanner.next();

                // check if user exists in the list
                for (User user : userList) {
                    if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                        currentUser = user;
                        break;
                    }
                }

                // if user not found, display error message and exit
                if (currentUser == null) {
                    System.out.println("Invalid email or password. Please try again.");
                    System.exit(0);
                }
            } else if (choice == 2) {
                // prompt user to enter details for new account
                System.out.print("\nEnter your name: ");
                String name = scanner.next();
                System.out.print("Enter your email: ");
                String email = scanner.next();
                System.out.print("Enter your password: ");
                String password = scanner.next();
                System.out.print("Enter your address: ");
                String address = scanner.next();

                // create new user and add to list
                User newUser = new User(name, email, password, address);
                userList.add(newUser);

                // set current user to new user
                currentUser = newUser;
            } else {
                // invalid choice, display error message and exit
                System.out.println("Invalid choice. Please try again.");
                System.exit(0);
            }

            // display product list
            System.out.println("\nProduct List:");
            for (int i = 0; i < productList.size(); i++) {
                System.out.println(
                        (i + 1) + ". " + productList.get(i).getName() + " - $" + productList.get(i).getPrice());
            }

            // prompt user to select a product
            System.out.print("\nEnter the number of the product you want to purchase: ");
            int productChoice = scanner.nextInt();
            scanner.nextLine();

            // get selected product
            Product selectedProduct = productList.get(productChoice - 1);

            // prompt user to select a payment method
            System.out.println("\nSelect a payment method:");
            System.out.println("1. Credit Card");
            System.out.println("2. PayPal");
            System.out.println("3. Cryptocurrency");
            System.out.print("\nEnter your choice: ");
            int paymentChoice = scanner.nextInt();
            scanner.nextLine();

            // define the payment strategies and their choice numbers
            Map<Integer, PaymentStrategy> paymentStrategies = new HashMap<>();
            paymentStrategies.put(1, creditCardPaymentStrategy);
            paymentStrategies.put(2, payPalPaymentStrategy);
            paymentStrategies.put(3, cryptocurrencyPaymentStrategy);

            // get the selected payment strategy based on the user's choice
            PaymentStrategy selectedPaymentStrategy = paymentStrategies.get(paymentChoice);

            // check if the choice is valid
            if (selectedPaymentStrategy == null) {
                System.out.println("Invalid choice. Please try again.");
                System.exit(0);
            }

            // prompt user to enter coupon code (if any)
            System.out.print("\nEnter coupon code (if any): ");
            String couponCode = scanner.nextLine();

            // apply discount based on coupon code (if any)
            DiscountStrategy selectedDiscountStrategy = noDiscountStrategy;
            if (!couponCode.isEmpty() && couponCode.equals("SPRING23")) {
                selectedDiscountStrategy = couponDiscountStrategy;
            }

            // create product purchase template
            ProductPurchaseTemplate productPurchaseTemplate = new ProductPurchaseTemplate();

            // purchase the product
            System.out.println("\n\n-----Product Purchase-----\n");
            productPurchaseTemplate.purchaseProduct(currentUser, selectedProduct, selectedPaymentStrategy,
                    selectedDiscountStrategy);
        }
    }

}
