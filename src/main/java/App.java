import model.Client;
import model.ShopImplementation;
import utilities.Dialogs;
import utilities.ShopInitializer;

import java.util.ArrayList;
import java.util.HashMap;

public class App {

  private ShopImplementation shop;
  private ArrayList<Client> customers = new ArrayList<>();
  private Client currentClient;

  public App() {
    run();
  }

  private void run() {
    this.shop = ShopInitializer.initialiseShop();
    Dialogs.displayWelcomeMessage();
    showMainMenu();
  }

  private void showMainMenu() {
    switch(Dialogs.showDialog("What do you want to do?", "Create customer", "Select customer", "Show current customer",
        "Create shopping list", "Start shopping", "Quit")) {
      case 1:
        createCustomer();
        showMainMenu();
        break;
      case 2:
        if (customers.isEmpty()) {
          System.out.println("""
              ------------------------------------
              You need to create a customer first.""");
        } else {
          System.out.println("""
              -------------------
              Available customers""");
          displayCustomers();
          System.out.println("""
              -------------------------------------
              Which customer do you want to select?""");
          System.out.print(">> ");
          currentClient = customers.get(Dialogs.readIntInput(1, customers.size()) - 1);
        }
        showMainMenu();
        break;
      case 3:
        if (customers.isEmpty()) {
          System.out.println("""
              -----------------------------------------------
              You need to create and select a customer first.""");
        } else if (!customers.isEmpty() && currentClient == null) {
          System.out.println("""
              ------------------------------------
              You need to select a customer first.""");
        } else {
          showCurrentCustomer();
        }
        showMainMenu();
        break;
      case 4:
        if (customers.isEmpty()) {
          System.out.println("""
              -----------------------------------------------
              You need to create and select a customer first.""");
        } else if (!customers.isEmpty() && currentClient == null) {
          System.out.println("""
              ------------------------------------
              You need to select a customer first.""");
        } else {
          createShoppingList();
        }
        showMainMenu();
        break;
      case 5:
        if (customers.isEmpty()) {
          System.out.println("""
              -----------------------------------------------
              You need to create and select a customer first.""");
        } else if (!customers.isEmpty() && currentClient == null) {
          System.out.println("""
              ------------------------------------
              You need to select a customer first.""");
        } else if (!customers.isEmpty() && currentClient != null && currentClient.getShoppingList().getProducts().isEmpty()) {
          System.out.println("""
              ------------------------------------
              You need to create a shopping list first.""");
        } else {
          shop.sell(currentClient, shop.getAvailableEmployee());
        }
        showMainMenu();
      case 6:
        System.out.println("""
            --------------------------------------------
            Thank you for using my application. Goodbye!""");
        System.exit(0);
        break;
    }
  }

  private void createShoppingList() {
    HashMap<String, Integer> productsToAdd = new HashMap<>();
    boolean control = true;
    while (control) {
      String productName = Dialogs.readStringInput("Input product name");
      int amount;
      try {
        amount = Integer.parseInt(Dialogs.readStringInput("Input amount"));
      } catch (Exception ignore) {
        System.out.println("Wrong input!");
        amount = Integer.parseInt(Dialogs.readStringInput("Input amount"));
      }
      productsToAdd.put(productName, amount);
      if (Dialogs.readStringInput("Add another product? (Y/N)").equalsIgnoreCase("N")) {
        control = false;
      }
    }
    currentClient.getShoppingList().addToList(productsToAdd);
  }

  private void showCurrentCustomer() {
    System.out.println("""
        ----------------
        Current customer""");
    System.out.println(currentClient);
    if (Dialogs.readStringInput("Check shopping list? (Y/N)").equalsIgnoreCase("Y")) {
      System.out.println(currentClient.getShoppingList().getProducts().size() > 0 ? currentClient.getShoppingList() : "Empty");
    }
  }

  private void createCustomer() {
    boolean control = true;
    while (control) {
      String name = Dialogs.readStringInput("Input name");
      System.out.println("Input age");
      System.out.print(">> ");
      int age = Dialogs.readIntInput(1, 150);
      customers.add(new Client(name, age));
      String answer = Dialogs.readStringInput("Add another? (Y/N)");
      if (answer.equalsIgnoreCase("N")) {
        control = false;
      }
    }
  }

  private void displayCustomers() {
    for (int i = 0; i < customers.size(); i++) {
      System.out.println((i+1) + ". " + customers.get(i).getName());
    }
  }
}
