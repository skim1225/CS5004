package Problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CookieTest {

  private Cookie testCookie;
  private String expectedName;
  private String[] expectedIngredients;
  private Double expectedQuantityPerServing;
  private Double expectedCaloriesPerServing;
  private Double expectedSugarPerServing;
  private Double expectedFatPerServing;
  private Double expectedProteinPerServing;
  private Double expectedFiberPerServing;
  private Boolean expectedContainsNuts;
  private Boolean expectedContainsDairy;
  private Boolean expectedGlutenFree;

  @BeforeEach
  void setUp() {
    testCookie = new Cookie("Chocolate Chip", new String[] {"flour", "butter", "sugar", "chocolate chips"}, 1.0,
        200.0, 30.0, 20.0, 1.0,
        10.0, false, true, false);
    expectedName = "Chocolate Chip";
    expectedIngredients = new String[] {"flour", "butter", "sugar", "chocolate chips"};
    expectedQuantityPerServing = 1.0;
    expectedCaloriesPerServing = 200.0;
    expectedSugarPerServing = 30.0;
    expectedFatPerServing = 20.0;
    expectedProteinPerServing = 1.0;
    expectedFiberPerServing = 10.0;
    expectedContainsNuts = false;
    expectedContainsDairy = true;
    expectedGlutenFree = false;
  }

  @Test
  void getName() {
    assertEquals(expectedName, testCookie.getName());
  }

  @Test
  void getIngredients() {
    assertTrue(Arrays.equals(expectedIngredients, testCookie.getIngredients()));
  }

  @Test
  void getQuantityPerServing() {
    assertEquals(expectedQuantityPerServing, testCookie.getQuantityPerServing());
  }

  @Test
  void getCaloriesPerServing() {
    assertEquals(expectedCaloriesPerServing, testCookie.getCaloriesPerServing());
  }

  @Test
  void getSugarPerServing() {
    assertEquals(expectedSugarPerServing, testCookie.getSugarPerServing());
  }

  @Test
  void getFatPerServing() {
    assertEquals(expectedFatPerServing, testCookie.getFatPerServing());
  }

  @Test
  void getProteinPerServing() {
    assertEquals(expectedProteinPerServing, testCookie.getProteinPerServing());
  }

  @Test
  void getFiberPerServing() {
    assertEquals(expectedFiberPerServing, testCookie.getFiberPerServing());
  }

  @Test
  void getContainsNuts() {
    assertEquals(expectedContainsNuts, testCookie.getContainsNuts());
  }

  @Test
  void getContainsDairy() {
    assertEquals(expectedContainsDairy, testCookie.getContainsDairy());
  }

  @Test
  void getGlutenFree() {
    assertEquals(expectedGlutenFree, testCookie.getGlutenFree());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testCookie.equals(testCookie));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testCookie.equals(null));
  }

  @Test
  void testEquals_DifferentType() {
    assertFalse(testCookie.equals("string"));
  }

  @Test
  void testEquals_DifferentObjectSameName() {
    Cookie otherCookie = new Cookie("Chocolate Chip", new String[] {}, 0.0, 0.0,
        0.0, 0.0, 0.0, 0.0, true, false, true);
    assertNotEquals(otherCookie, testCookie);
  }

  @Test
  void testEquals_DifferentObjectSameIngredients() {
    Cookie otherCookie = new Cookie("", new String[] {"flour", "butter", "sugar", "chocolate chips"}, 0.0, 0.0,
        0.0, 0.0, 0.0, 0.0, true, false, true);
    assertNotEquals(otherCookie, testCookie);
  }

  @Test
  void testEquals_DifferentObjectSameQuantityPerServing() {
    Cookie otherCookie = new Cookie("", new String[] {}, 1.0, 0.0,
        0.0, 0.0, 0.0, 0.0, true, false, true);
    assertNotEquals(otherCookie, testCookie);
  }

  @Test
  void testEquals_DifferentObjectSameCaloriesPerServing() {
    Cookie otherCookie = new Cookie("", new String[] {}, 0.0, 200.0,
        0.0, 0.0, 0.0, 0.0, true, false, true);
    assertNotEquals(otherCookie, testCookie);
  }

  @Test
  void testEquals_DifferentObjectSameSugarPerServing() {
    Cookie otherCookie = new Cookie("", new String[] {}, 0.0, 0.0,
        30.0, 0.0, 0.0, 0.0, true, false, true);
    assertNotEquals(otherCookie, testCookie);
  }

  @Test
  void testEquals_DifferentObjectSameFatPerServing() {
    Cookie otherCookie = new Cookie("", new String[] {}, 0.0, 0.0,
        0.0, 20.0, 0.0, 0.0, true, false, true);
    assertNotEquals(otherCookie, testCookie);
  }

  @Test
  void testEquals_DifferentObjectSameProteinPerServing() {
    Cookie otherCookie = new Cookie("", new String[] {}, 0.0, 0.0,
        0.0, 0.0, 1.0, 0.0, true, false, true);
    assertNotEquals(otherCookie, testCookie);
  }

  @Test
  void testEquals_DifferentObjectSameFiberPerServing() {
    Cookie otherCookie = new Cookie("", new String[] {}, 0.0, 0.0,
        0.0, 0.0, 0.0, 10.0, true, false, true);
    assertNotEquals(otherCookie, testCookie);
  }

  @Test
  void testEquals_DifferentObjectSameContainsNuts() {
    Cookie otherCookie = new Cookie("", new String[] {}, 0.0, 0.0,
        0.0, 0.0, 0.0, 0.0, false, false, true);
    assertNotEquals(otherCookie, testCookie);
  }

  @Test
  void testEquals_DifferentObjectSameContainsDairy() {
    Cookie otherCookie = new Cookie("", new String[] {}, 0.0, 0.0,
        0.0, 0.0, 0.0, 0.0, true, true, true);
    assertNotEquals(otherCookie, testCookie);
  }

  @Test
  void testEquals_DifferentObjectSameGlutenFree() {
    Cookie otherCookie = new Cookie("", new String[] {}, 0.0, 0.0,
        0.0, 0.0, 0.0, 0.0, true, false, false);
    assertNotEquals(otherCookie, testCookie);
  }

  @Test
  void testEquals_DifferentObjectSameFields() {
    Cookie otherCookie = new Cookie("Chocolate Chip", new String[] {"flour", "butter", "sugar", "chocolate chips"}, 1.0,
        200.0, 30.0, 20.0, 1.0,
        10.0, false, true, false);
    assertEquals(otherCookie, testCookie);
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(testCookie.getName(), testCookie.getQuantityPerServing(),
        testCookie.getCaloriesPerServing(), testCookie.getSugarPerServing(), testCookie.getFatPerServing(),
        testCookie.getProteinPerServing(), testCookie.getFiberPerServing(), testCookie.getContainsNuts(),
        testCookie.getContainsDairy(), testCookie.getGlutenFree());
    expectedHashCode = 31 * expectedHashCode + Arrays.hashCode(testCookie.getIngredients());
    assertEquals(expectedHashCode, testCookie.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "Cookie{" +
        "name='" + testCookie.getName() + '\'' +
        ", ingredients=" + Arrays.toString(testCookie.getIngredients()) +
        ", quantityPerServing=" + testCookie.getQuantityPerServing() +
        ", caloriesPerServing=" + testCookie.getCaloriesPerServing() +
        ", sugarPerServing=" + testCookie.getSugarPerServing() +
        ", fatPerServing=" + testCookie.getFatPerServing() +
        ", proteinPerServing=" + testCookie.getProteinPerServing() +
        ", fiberPerServing=" + testCookie.getFiberPerServing() +
        ", containsNuts=" + testCookie.getContainsNuts() +
        ", containsDairy=" + testCookie.getContainsDairy() +
        ", glutenFree=" + testCookie.getGlutenFree() +
        '}';
    assertEquals(expectedString, testCookie.toString());
  }
}