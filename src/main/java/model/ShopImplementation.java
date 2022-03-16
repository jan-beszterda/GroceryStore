package model;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class ShopImplementation implements Shop {

  private String name;
  private String address;
  private HashMap<String, Product> productNames;
  private HashMap<String, Integer> productStock;
  private ArrayList<Person> employees;

  public ShopImplementation(String name, String address) {
    this.name = name;
    this.address = address;
    this.productNames = new HashMap<>();
    this.productStock = new HashMap<>();
    this.employees = new ArrayList<>();
  }

  @Override
  public void addToWarehouse(String productName, Product product, int count) {
    productNames.put(productName, product);
    productStock.put(productName, count);
  }

  @Override
  public void removeFromWarehouse(String productName, int count) {
    productStock.replace(productName, count);
  }

  @Override
  public void employ(Employee employee) {
    employees.add(employee);
  }

  @Override
  public void fire(Employee employee) {
    employees.remove(employee);
  }

  @Override
  public void sell(Client client, Employee employee) {
    employee.setAvailable(false);
    ArrayList<Double> amounts = new ArrayList<>();
    ArrayList<String> itemsToRemove = new ArrayList<>();
    Receipt receipt = new Receipt();
    receipt.getInfo().add("-".repeat(10));
    receipt.getInfo().add(this.name);
    receipt.getInfo().add(this.address);
    receipt.getInfo().add(DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, new Locale("en", "US")).format(Date.from(Instant.now())));
    receipt.getInfo().add("You were served by: " + employee.getName());
    receipt.getInfo().add("-".repeat(10));
    for (String productName : client.getShoppingList().getProducts().keySet()) {
      if (productNames.containsKey(productName)) {
        if (productNames.get(productName).isRestrictedProduct()) {
         RestrictedProduct restrictedProduct = (RestrictedProduct) productNames.get(productName);
         if (restrictedProduct.getAgeLimit() > client.getAge()) {
           System.out.println("You can't buy " + productName + "!");
           continue;
         }
        }
        if (productStock.get(productName) >= client.getShoppingList().getProducts().get(productName)) {
          //TODO: Sell product = remove from stock, remove from shopping list add to bag, add to receipt
          productStock.replace(productName, Math.max(productStock.get(productName) - client.getShoppingList().getProducts().get(productName), 0));
          client.getBag().put(productName, client.getShoppingList().getProducts().get(productName));
          double amount = productNames.get(productName).getPrice() * client.getShoppingList().getProducts().get(productName);
          amounts.add(amount);
          receipt.getInfo().add(client.getShoppingList().getProducts().get(productName) + "x " + productName + " " + amount);
          itemsToRemove.add(productName);
        } else {
          System.out.println("We don't have that much " + productName + "!");
        }
      } else {
        System.out.println("We don't have " + productName + "!");
      }
    }
    double total = 0;
    for (double amount : amounts) {
      total += amount;
    }
    for (String name : itemsToRemove) {
      client.getShoppingList().removeFromList(name);
    }
    receipt.getInfo().add("Total: " + total);
    receipt.getInfo().add("-".repeat(10));
    receipt.getInfo().add("Thank you for shopping!");
    receipt.getInfo().add("-".repeat(10));
    printReceipt(receipt);
    client.getReceipts().add(receipt);
    employee.setAvailable(true);
  }

  @Override
  public void printReceipt(Receipt receipt) {
    for (String info : receipt.getInfo()) {
      System.out.println(info);
    }
  }

  @Override
  public Employee getAvailableEmployee() {
    for (Person person : employees) {
      Employee employee = (Employee) person;
      if (employee.isAvailable()) {
        return employee;
      }
    }
    return null;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public HashMap<String, Product> getProductNames() {
    return productNames;
  }

  public HashMap<String, Integer> getProductStock() {
    return productStock;
  }

  public ArrayList<Person> getEmployees() {
    return employees;
  }
}
