package model;

public class RestrictedProduct extends Product {
  private int ageLimit;

  public RestrictedProduct() {
  }

  public RestrictedProduct(int ageLimit) {
    this.ageLimit = ageLimit;
  }

  public RestrictedProduct(String name, String description, String category, String expiryDate, double price, boolean isFridgeProduct, int ageLimit) {
    super(name, description, category, expiryDate, price, isFridgeProduct, true);
    this.ageLimit = ageLimit;
  }

  public int getAgeLimit() {
    return ageLimit;
  }
}
