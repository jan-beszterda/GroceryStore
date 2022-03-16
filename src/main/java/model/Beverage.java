package model;

public class Beverage extends RestrictedProduct {

  public Beverage() {
  }

  public Beverage(String name, String brand, String description, String category, String expiryDate, double price, boolean isFridgeProduct, int ageLimit) {
    super(name, brand, description, category, expiryDate, price, isFridgeProduct, ageLimit);
  }
}
