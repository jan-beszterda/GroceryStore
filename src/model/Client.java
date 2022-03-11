package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Client extends Person{
  private int age;
  private ShoppingListImpl shoppingList;
  private ArrayList<Receipt> receipts;
  private HashMap<String, Integer> bag;

  public Client(String name, int age) {
    super(name);
    this.age = age;
    this.shoppingList = new ShoppingListImpl();
    this.bag = new HashMap<>();
  }

  public ShoppingListImpl getShoppingList() {
    return shoppingList;
  }

  public int getAge() {
    return age;
  }

  public HashMap<String, Integer> getBag() {
    return bag;
  }
}
