package model;

import java.util.HashMap;

public class ShoppingListImpl implements ShoppingList{
  private HashMap<String, Integer> products;

  public ShoppingListImpl() {
    this.products = new HashMap<>();
  }

  @Override
  public void addToList(String name, int count) {
    products.put(name, count);
  }

  @Override
  public void removeFromList(String name) {
    products.remove(name);
  }

  /*public void showList() {
    for (int i = 0; i < products.size(); i++) {
      System.out.println((i+1) + ". " + products.);
    }
  }*/

  public HashMap<String, Integer> getProducts() {
    return products;
  }
}
