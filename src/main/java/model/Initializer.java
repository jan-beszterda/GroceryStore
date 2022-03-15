package model;

public class Initializer {

  public ShopImpl initialiseShop() {
    ShopImpl shop = new ShopImpl("Livs", "Kungsgatan 1");
    shop.addToWarehouse("Banana", new Fruit("Banana", "1 kg of bananas", "Fruit", "", 15.95, false), 50);
    shop.addToWarehouse("Snus", new Snus("Ettan", "Some snus", "Tobacco", "2022-04-15", 52.95, true, 18), 20);
    shop.addToWarehouse("Red Bull", new EnergyDrink("Red Bull", "A popular energy drink", "Beverage", "2023-05-31", 14.99, true, 15), 10);

    shop.employ(new Employee("Jan", "12AA234X", 20000));

    return shop;
  }

  public Client initialiseClient() {
    Client client = new Client("Mike", 13);
    client.getShoppingList().addToList("Banana", 100);
    client.getShoppingList().addToList("Snus", 1);
    client.getShoppingList().addToList("Bread", 1);

    return client;
  }
}
