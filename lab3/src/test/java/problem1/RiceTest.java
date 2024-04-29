package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RiceTest {

  private Rice testRice;
  private String expectedName;
  private Double expectedCurrPrice;
  private Integer expectedQtyAvailable;

  @BeforeEach
  void setUp() {
    testRice = new Rice("Jasmine", 3.45, 128);
    expectedName = "Jasmine";
    expectedCurrPrice = 3.45;
    expectedQtyAvailable = 128;
  }

  @Test
  void getName() {
    assertEquals(expectedName, testRice.getName());
  }

  @Test
  void getCurrPrice() {
    assertEquals(expectedCurrPrice, testRice.getCurrPrice());
  }

  @Test
  void getQtyAvailable() {
    assertEquals(expectedQtyAvailable, testRice.getQtyAvailable());
  }

  @Test
  void getMaxQty() {
    assertEquals(Rice.MAX_QTY, testRice.getMaxQty());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testRice.equals(testRice));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testRice.equals(null));
  }

  @Test
  void testEquals_DifferentDataTypes() {
    assertFalse(testRice.equals("string"));
  }

  @Test
  void testEquals_DifferentObjectSameName() {
    Rice otherRice = new Rice("Basmati", 3.45, 0);
    assertNotEquals(testRice, otherRice);
  }

  @Test
  void testEquals_DifferentObjectSameQtyAvailable() {
    Rice otherRice = new Rice("Basmati", 0.0, 128);
    assertNotEquals(testRice, otherRice);
  }

  @Test
  void testEquals_DifferentObjectSameCurrPrice() {
    Rice otherRice = new Rice("Jasmine", 3.45, 0);
    assertNotEquals(testRice, otherRice);
  }

  @Test
  void testEquals_DifferentObjectSameFields() {
    Rice otherRice = new Rice("Jasmine", 3.45, 128);
    assertEquals(testRice, otherRice);
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(testRice.getName(), testRice.getCurrPrice(),
        testRice.getQtyAvailable(), testRice.getMaxQty());
    assertEquals(expectedHashCode, testRice.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "FoodItem{" +
        "name='" + testRice.getName() + '\'' +
        ", currPrice=" + testRice.getCurrPrice() +
        ", qtyAvailable=" + testRice.getQtyAvailable() +
        ", maxQty=" + testRice.getMaxQty() +
        '}';
    assertEquals(expectedString, testRice.toString());
  }
}