package model;

public class EnergyDrink extends RestrictedProduct {

  public EnergyDrink() {
  }

  public EnergyDrink(String name, String description, String category, String expiryDate, double price, boolean isFridgeProduct, int ageLimit) {
    super(name, description, category, expiryDate, price, isFridgeProduct, ageLimit);
  }
}
