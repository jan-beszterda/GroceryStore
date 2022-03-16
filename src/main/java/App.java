import model.Client;
import model.ShopImplementation;
import utilities.Dialogs;
import utilities.ShopInitializer;

import java.util.ArrayList;

public class App {

  private ShopImplementation shop;
  private ArrayList<Client> customers = new ArrayList<>();

  public App() {
    run();
  }

  private void run() {
    this.shop = ShopInitializer.initialiseShop();
    Dialogs.displayWelcomeMessage();
    showMainMenu();
  }

  private void showMainMenu() {
    switch(Dialogs.showDialog("What do you want to do?", "Create customer", "Quit")) {
      case 1:
        createCustomer();
        break;
      case 2:
        System.out.println("""
            --------------------------------------------
            Thank you for using my application. Goodbye!""");
        System.exit(0);
        break;
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
}
