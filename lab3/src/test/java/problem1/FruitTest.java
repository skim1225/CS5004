package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FruitTest {

  private Fruit testFruit;
private Integer expectedOrderDate;
private Integer expectedExpirationDate;

  @BeforeEach
  void setUp() {
    testFruit = new Fruit("Apple", 0.50, 90, 0, 1);
    expectedOrderDate = 0;
    expectedExpirationDate = 1;
  }

  @Test
  void getOrderDate() {
    assertEquals(expectedOrderDate, testFruit.getOrderDate());
  }

  @Test
  void getExpirationDate() {
    assertEquals(expectedExpirationDate, testFruit.getExpirationDate());
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(testFruit.getName(), testFruit.getCurrPrice(), testFruit.getQtyAvailable(),
        testFruit.getMaxQty(), testFruit.getOrderDate(), testFruit.getExpirationDate());
    assertEquals(expectedHashCode, testFruit.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "PerishableFood{" +
        "orderDate=" + testFruit.getOrderDate() +
        ", expirationDate=" + testFruit.getExpirationDate() +
        ", name='" + testFruit.getName() + '\'' +
        ", currPrice=" + testFruit.getCurrPrice() +
        ", qtyAvailable=" + testFruit.getQtyAvailable() +
        ", maxQty=" + testFruit.getMaxQty() +
        '}';
    assertEquals(expectedString, testFruit.toString());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testFruit.equals(testFruit));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testFruit.equals(null));
  }

  @Test
  void testEquals_DifferentDataTypes() {
    assertFalse(testFruit.equals("string"));
  }

  @Test
  void testEquals_DifferentObjectSameName() {
    Fruit otherFruit = new Fruit("Apple", 0.0, 0, 1, 2);
    assertFalse(testFruit.equals(otherFruit));
  }
  @Test
  void testEquals_DifferentObjectSameCurrPrice() {
    Fruit otherFruit = new Fruit("Banana", 0.50, 0, 1, 2);
    assertFalse(testFruit.equals(otherFruit));
  }

  @Test
  void testEquals_DifferentObjectSameQtyAvailable() {
    Fruit otherFruit = new Fruit("Banana", 0.0, 90, 1, 2);
    assertFalse(testFruit.equals(otherFruit));
  }

  @Test
  void testEquals_DifferentObjectSameOrderDate() {
    Fruit otherFruit = new Fruit("Banana", 0.0, 0, 0, 2);
    assertFalse(testFruit.equals(otherFruit));
  }

  @Test
  void testEquals_DifferentObjectSameExpirationDate() {
    Fruit otherFruit = new Fruit("Banana", 0.0, 0, 1, 1);
    assertFalse(testFruit.equals(otherFruit));
  }

  @Test
  void testEquals_DifferentObjectsSameFields() {
    Fruit otherFruit = new Fruit("Apple", 0.50, 90, 0, 1);
    assertEquals(testFruit, otherFruit);
  }

}