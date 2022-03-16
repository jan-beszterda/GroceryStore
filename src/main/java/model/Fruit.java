package model;

public class Fruit extends Product{

  public Fruit() {
  }

  public Fruit(String name, String brand, String description, String category, String expiryDate, double price, boolean isFridgeProduct) {
    super(name, brand, description, category, expiryDate, price, isFridgeProduct, false);
  }


}
