package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InitializerTest {

  static Initializer unitUnderTest;

  @BeforeAll
  static void setUp() {
    unitUnderTest = new Initializer();
  }

  @Test
  void initialiseShop_ShouldReturnInstanceOfShopImpl() {
    ShopImpl actual = unitUnderTest.initialiseShop();
    assertInstanceOf(ShopImpl.class, actual);
  }

  @Test
  void initialiseShop_ShouldNotReturnNull() {
    ShopImpl actual = unitUnderTest.initialiseShop();
    assertNotNull(actual);
  }

  @Test
  void initialiseShop_ShouldFillShopImplEmployeesList() {
    ShopImpl actual = unitUnderTest.initialiseShop();
    //assertNotNull(actual.getEmployees());
    assertTrue(actual.getEmployees().size() > 0);
  }

  @Test
  void initialiseShop_ShouldFillShopImplProductMaps() {
    ShopImpl actual = unitUnderTest.initialiseShop();
    //assertNotNull(actual.getEmployees());
    assertTrue(actual.getProductNames().size() > 0 && actual.getProductStock().size() > 0);
  }

  @Test
  void initialiseShop_ShouldFillShopImplProductMaps_With50Banana() {
    ShopImpl actual = unitUnderTest.initialiseShop();
    //assertNotNull(actual.getEmployees());
    assertEquals(50, actual.getProductStock().get("Banana"));
  }

  @Test
  void initialiseShop_ShouldFillShopImplWithSnus_WithAgeLimit18() {
    ShopImpl shop = unitUnderTest.initialiseShop();
    RestrictedProduct actual = (RestrictedProduct) shop.getProductNames().get("Snus");
    assertEquals(18, actual.getAgeLimit());
  }

  @Test
  void initialiseShop_ShouldFillShopImplWithRedBull_ShouldBeAFridgeProduct() {
    ShopImpl actual = unitUnderTest.initialiseShop();
    assertTrue(actual.getProductNames().get("Red Bull").isFridgeProduct());
  }

  @Test
  void initialiseClient_ShouldReturnInstanceOfClient() {
    Client actual = unitUnderTest.initialiseClient();
    assertInstanceOf(Client.class, actual);
  }

  @Test
  void initialiseClient_ShouldFillClientsShoppingListWith100Banana() {
    Client actual = unitUnderTest.initialiseClient();
    assertEquals(100, actual.getShoppingList().getProducts().get("Banana"));
  }

  @Test
  void initialiseClient_ClientsReceiptListShouldBeEmptyBeforeAnyTransaction() {
    Client actual = unitUnderTest.initialiseClient();
    assertEquals(0, actual.getReceipts().size());
  }
}