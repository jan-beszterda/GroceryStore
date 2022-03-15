package model;

public class Dairy extends Product {

  public Dairy() {
  }

  public Dairy(String name, String description, String category, String expiryDate, double price, boolean isFridgeProduct) {
    super(name, description, category, expiryDate, price, isFridgeProduct, false);
  }
}
