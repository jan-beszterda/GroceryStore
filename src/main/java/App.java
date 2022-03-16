import model.Client;
import model.ShopImplementation;
import utilities.ShopInitializer;

import java.util.ArrayList;

public class App {

  private ShopImplementation shop;
  private ArrayList<Client> customers;

  public App() {
    run();
  }

  private void run() {
    this.shop = ShopInitializer.initialiseShop();

  }
}
