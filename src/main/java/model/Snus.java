package model;

public class Snus extends RestrictedProduct {

  public Snus() {
  }

  public Snus(String name, String description, String category, String expiryDate, double price, boolean isFridgeProduct, int ageLimit) {
    super(name, description, category, expiryDate, price, isFridgeProduct, ageLimit);
  }


}
