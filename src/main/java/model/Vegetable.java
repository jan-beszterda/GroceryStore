package model;

public class Vegetable extends Product {

  public Vegetable() {
  }

  public Vegetable(String name, String brand, String description, String category, String expiryDate, double price, boolean isFridgeProduct) {
    super(name, brand, description, category, expiryDate, price, isFridgeProduct, false);
  }
}
