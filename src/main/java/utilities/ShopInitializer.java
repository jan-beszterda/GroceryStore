package utilities;

import model.*;

import java.sql.Date;
import java.text.DateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Locale;

public class ShopInitializer {

  public static ShopImplementation initialiseShop() {
    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, new Locale("en", "US"));
    ArrayList<String> shopData = ShopDataLoader.readData("src/main/resources/shop.txt");
    ShopImplementation shop = new ShopImplementation(shopData.get(0).split(",")[0], shopData.get(0).split(",")[1]);
    for (int i = 1; i < shopData.size(); i++) {
      String[] productData = shopData.get(i).split(",");
      switch (productData[3]) {
        case "Fruit":
          shop.addToWarehouse(productData[0], new Fruit(productData[0], productData[1], productData[2], productData[3],
              productData[4], Double.parseDouble(productData[5]), Boolean.parseBoolean(productData[6])), 100);
          break;
        case "Dairy":
          shop.addToWarehouse(productData[0], new Dairy(productData[0], productData[1], productData[2], productData[3],
              dateFormat.format(Date.from(Instant.now().plus(14, ChronoUnit.DAYS))), Double.parseDouble(productData[5]), Boolean.parseBoolean(productData[6])), 100);
          break;
        case "Tobacco":
          shop.addToWarehouse(productData[0], new Tobacco(productData[0], productData[1], productData[2], productData[3],
              dateFormat.format(Date.from(Instant.now().plus(180, ChronoUnit.DAYS))), Double.parseDouble(productData[5]), Boolean.parseBoolean(productData[6]), 18), 100);
          break;
      }
    }
    //shop.addToWarehouse("Banana", new Fruit("Banana", "1 kg of bananas", "Fruit", "", 15.95, false), 50);
    //shop.addToWarehouse("Snus", new Snus("Ettan", "Some snus", "Tobacco", "2022-04-15", 52.95, true, 18), 20);
    //shop.addToWarehouse("Red Bull", new EnergyDrink("Red Bull", "A popular energy drink", "Beverage", "2023-05-31", 14.99, true, 15), 10);

    shop.employ(new Employee("Jan", "12AA234X", 20000));

    return shop;
  }

}
