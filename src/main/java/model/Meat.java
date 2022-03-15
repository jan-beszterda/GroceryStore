package model;

public class Meat extends Product {

  public Meat() {
  }

  public Meat(String name, String description, String category, String expiryDate, double price, boolean isFridgeProduct) {
    super(name, description, category, expiryDate, price, isFridgeProduct, false);
  }
}
