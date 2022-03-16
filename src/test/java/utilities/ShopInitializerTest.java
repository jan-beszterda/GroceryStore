package utilities;

import model.Client;
import model.RestrictedProduct;
import model.ShopImplementation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopInitializerTest {

  static ShopInitializer unitUnderTest;

  @BeforeAll
  static void setUp() {
    unitUnderTest = new ShopInitializer();
  }

  @Test
  void initialiseShop_ShouldReturnInstanceOfShopImpl() {
    ShopImplementation actual = unitUnderTest.initialiseShop();
    assertInstanceOf(ShopImplementation.class, actual);
  }

  @Test
  void initialiseShop_ShouldNotReturnNull() {
    ShopImplementation actual = unitUnderTest.initialiseShop();
    assertNotNull(actual);
  }

  @Test
  void initialiseShop_ShouldFillShopImplEmployeesList() {
    ShopImplementation actual = unitUnderTest.initialiseShop();
    //assertNotNull(actual.getEmployees());
    assertTrue(actual.getEmployees().size() > 0);
  }

  @Test
  void initialiseShop_ShouldFillShopImplProductMaps() {
    ShopImplementation actual = unitUnderTest.initialiseShop();
    //assertNotNull(actual.getEmployees());
    assertTrue(actual.getProductNames().size() > 0 && actual.getProductStock().size() > 0);
  }

  @Test
  void initialiseShop_ShouldFillShopImplProductMaps_With50Banana() {
    ShopImplementation actual = unitUnderTest.initialiseShop();
    //assertNotNull(actual.getEmployees());
    assertEquals(50, actual.getProductStock().get("Banana"));
  }

  @Test
  void initialiseShop_ShouldFillShopImplWithSnus_WithAgeLimit18() {
    ShopImplementation shop = unitUnderTest.initialiseShop();
    RestrictedProduct actual = (RestrictedProduct) shop.getProductNames().get("Snus");
    assertEquals(18, actual.getAgeLimit());
  }

  @Test
  void initialiseShop_ShouldFillShopImplWithRedBull_ShouldBeAFridgeProduct() {
    ShopImplementation actual = unitUnderTest.initialiseShop();
    assertTrue(actual.getProductNames().get("Red Bull").isFridgeProduct());
  }
}