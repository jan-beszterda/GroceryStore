import model.*;

public class Main {

  /*Din butik kan köras från Main-klassen. I din butik så kommer det att komma in kunder som vill handla olika typer av varor.

  Skapa upp några olika varor Tänk på arv, vad har varorna gemensamt? Vad är specifikt för de enskilda varorna?

  Skapa upp minst 2 olika personer (anställd och kund)Vad har personerna gemensamt och vad skiljer dem åt?

  Skapa upp en inköpslista som bara kunder kan ha Vad händer om varan inte finns i butiken?

  En av kunderna vill köpa energidricka som har åldersgräns - lägg till det. Var ska åldersgränsen finnas? Vilken klass ansvarar för den informationen?

  En av kunderna vill köpa snus som har en annan åldersgräns - lägg till. Återigen, var ska åldersgränsen specificeras?

  Skapa upp ett kvitto som är baserat på om varan fanns eller inte Om kunden inte fick allting på sin inköpslista så ska det alltså inte finnas med på kvittot. Vad kan ett kvitto innehålla?*/

  public static void main(String[] args) {
    ShopImpl shop = new ShopImpl("Livs", "Torget 1, 555 44 Göteborg");
    shop.addToWarehouse("Banana", new Fruit("Banana", "1 kg of bananas", "Fruit", "", 15.95, false), 50);
    shop.addToWarehouse("Snus", new Snus("Ettan", "Some snus", "Tobacco", "2022-04-15", 52.95, true, 18), 20);
    shop.addToWarehouse("Red Bull", new EnergyDrink("Red Bull", "A popular energy drink", "Beverage", "2023-05-31", 14.99, true, 15), 10);

    shop.employ(new Employee("Jan", "12AA234X", 20000));

    Client client = new Client("Mike", 13);
    client.getShoppingList().addToList("Banana", 100);
    client.getShoppingList().addToList("Snus", 1);
    client.getShoppingList().addToList("Bread", 1);
    shop.sell(client, shop.getAvailableEmployee());
  }
}
