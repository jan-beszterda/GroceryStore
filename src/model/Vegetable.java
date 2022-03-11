package model;

public class Vegetable extends Product {

  public Vegetable() {
  }

  public Vegetable(String name, String description, String category, String expiryDate, double price, boolean isFridgeProduct) {
    super(name, description, category, expiryDate, price, isFridgeProduct, false);
  }
}
