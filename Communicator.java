import java.util.ArrayList;
import java.util.List;

public class Communicator {
  private List<Product> products = new ArrayList<>();
  private List<User> users = new ArrayList<>();

  public void addProduct(Product product) {
    products.add(product);
  }

  public void addUser(User user) {
    users.add(user);
  }

  public List<Product> getProducts() {
    return products;
  }

  public List<User> getUsers() {
    return users;
  }

  public void notifyUser(User user, String message) {
    System.out.println("Sending notification to " + user.getEmail() + ": " + message);
}

  public void notifyAdmins(String message) {
    for (User user : users) {
      if (user instanceof Admin) {
        notifyUser(user, message);
      }
    }
  }
}
