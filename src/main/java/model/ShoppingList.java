package model;

import java.util.HashMap;

public interface ShoppingList {

  void addToList(String name, int count);
  void addToList(HashMap<String, Integer> products);
  void removeFromList(String name);
}
