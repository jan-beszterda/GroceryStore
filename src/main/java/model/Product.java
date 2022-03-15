package model;

public class Product {
  private String name;
  private String description;
  private String category;
  private String expiryDate;
  private double price;
  private boolean isFridgeProduct;

  public boolean isFridgeProduct() {
    return isFridgeProduct;
  }

  private boolean isRestrictedProduct = false;

  public Product() {}

  public Product(String name, String description, String category, String expiryDate, double price, boolean isFridgeProduct, boolean isRestrictedProduct) {
    this.name = name;
    this.description = description;
    this.category = category;
    this.expiryDate = expiryDate;
    this.price = price;
    this.isFridgeProduct = isFridgeProduct;
    this.isRestrictedProduct = isRestrictedProduct;
  }

  public String getName() {
    return name;
  }

  public boolean isRestrictedProduct() {
    return isRestrictedProduct;
  }

  public double getPrice() {
    return price;
  }
}
