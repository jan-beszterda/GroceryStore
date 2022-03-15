package model;

import java.util.ArrayList;

public class Receipt {
  private ArrayList<String> info;

  public Receipt() {
    this.info = new ArrayList<>();
  }

  public ArrayList<String> getInfo() {
    return info;
  }
}
