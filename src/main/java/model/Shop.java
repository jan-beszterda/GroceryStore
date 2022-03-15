package model;

public interface Shop {

  void addToWarehouse(String productName, Product product, int count);
  void removeFromWarehouse(String productName, int count);
  void employ(Employee employee);
  void fire(Employee employee);
  void sell(Client client, Employee employee);
  void printReceipt(Receipt receipt);
  Employee getAvailableEmployee();
}
