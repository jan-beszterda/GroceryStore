package model;

import java.util.HashMap;
import java.util.Map;

public class ShoppingListImpl implements ShoppingList{
  private HashMap<String, Integer> products;

  public ShoppingListImpl() {
    this.products = new HashMap<>();
  }

  @Override
  public void addToList(String name, int count) {
    this.products.put(name, count);
  }

  @Override
  public void addToList(HashMap<String, Integer> products) {
    this.products.putAll(products);
  }

  @Override
  public void removeFromList(String name) {
    products.remove(name);
  }

  public HashMap<String, Integer> getProducts() {
    return products;
  }

  @Override
  public String toString() {
    StringBuilder shoppingListInfo = new StringBuilder();
    for (Map.Entry<String, Integer> product : products.entrySet()) {
      shoppingListInfo.append(product.getKey()).append(", ").append(product.getValue()).append("\n");
    }
    return shoppingListInfo.toString();
  }
}
