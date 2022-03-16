package model;

public class Tobacco extends RestrictedProduct {

  public Tobacco() {
  }

  public Tobacco(String name, String brand, String description, String category, String expiryDate, double price, boolean isFridgeProduct, int ageLimit) {
    super(name, brand, description, category, expiryDate, price, isFridgeProduct, ageLimit);
  }


}
