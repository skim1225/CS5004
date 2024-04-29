package Problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CookieCatalogTest {

  private CookieCatalog testCookieCatalog;
  private CookieNode expectedHead;
  private Integer expectedSize;

  @BeforeEach
  void setUp() {
    testCookieCatalog = new CookieCatalog();
    expectedSize = 0;
    expectedHead = null;
  }

  @Test
  void getHead() {
    assertEquals(testCookieCatalog.getHead(), expectedHead);
  }

  @Test
  void isEmpty() {
    assertTrue(testCookieCatalog.isEmpty());
  }

  @Test
  void isEmpty_NotEmpty() {
    testCookieCatalog.addCookie(new Cookie("Chocolate Chip", new String[] {"flour", "butter", "sugar", "chocolate chips"}, 1.0,
        200.0, 30.0, 20.0, 1.0,
        10.0, false, true, false));
    assertFalse(testCookieCatalog.isEmpty());
  }

  @Test
  void countCookies() {
    assertEquals(testCookieCatalog.countCookies(), expectedSize);
  }

  @Test
  void checkCookie_Null() {
    assertFalse(testCookieCatalog.checkCookie("Chocolate chip"));
  }

  @Test
  void checkCookie_Head() {
    testCookieCatalog.addCookie(new Cookie("Chocolate Chip", new String[] {"flour", "butter", "sugar", "chocolate chips"}, 1.0,
        200.0, 30.0, 20.0, 1.0,
        10.0, false, true, false));
    assertTrue(testCookieCatalog.checkCookie("Chocolate Chip"));
  }

  @Test
  void checkCookie_NotHead() {
    testCookieCatalog.addCookie(new Cookie("Chocolate Chip", new String[] {"flour", "butter", "sugar", "chocolate chips"}, 1.0,
        200.0, 30.0, 20.0, 1.0,
        10.0, false, true, false));
    testCookieCatalog.addCookie(new Cookie("test", new String[] {"flour", "butter", "sugar", "chocolate chips"}, 1.0,
        200.0, 30.0, 20.0, 1.0,
        10.0, false, true, false));

    assertTrue(testCookieCatalog.checkCookie("test"));
  }

  @Test
  void addCookie() {
    testCookieCatalog.addCookie(new Cookie("Chocolate Chip", new String[] {"flour", "butter", "sugar", "chocolate chips"}, 1.0,
        200.0, 30.0, 20.0, 1.0,
        10.0, false, true, false));
    assertTrue(testCookieCatalog.checkCookie("Chocolate Chip"));
  }

  @Test
  void addCookie_SameName() {
    testCookieCatalog.addCookie(new Cookie("Chocolate Chip", new String[] {"flour", "butter", "sugar", "chocolate chips"}, 1.0,
        200.0, 30.0, 20.0, 1.0,
        10.0, false, true, false));
    testCookieCatalog.addCookie(new Cookie("Chocolate Chip", new String[] {"flour", "butter", "sugar", "chocolate chips"}, 1.0,
        200.0, 30.0, 20.0, 1.0,
        10.0, false, true, false));
    assertTrue(testCookieCatalog.countCookies() == 1);
  }

  @Test
  void removeCookie() throws CookieNotFoundException {
    testCookieCatalog.addCookie(new Cookie("Chocolate Chip", new String[] {"flour", "butter", "sugar", "chocolate chips"}, 1.0,
        200.0, 30.0, 20.0, 1.0,
        10.0, false, true, false));
    testCookieCatalog.removeCookie(new Cookie("Chocolate Chip", new String[] {"flour", "butter", "sugar", "chocolate chips"}, 1.0,
        200.0, 30.0, 20.0, 1.0,
        10.0, false, true, false));
    assertFalse(testCookieCatalog.checkCookie("Chocolate Chip"));
  }

  @Test
  void removeCookie_NotInCatalog() throws CookieNotFoundException {
    Assertions.assertThrows(CookieNotFoundException.class, () -> {
      testCookieCatalog.removeCookie(new Cookie("Chocolate Chip", new String[] {"flour", "butter", "sugar", "chocolate chips"}, 1.0,
          200.0, 30.0, 20.0, 1.0,
          10.0, false, true, false));
    });
  }

  @Test
  void findGlutenFreeSugarLiteCookies() {
    Cookie gfsl = new Cookie("gfsl", new String[] {"flour", "butter", "sugar", "chocolate chips"}, 1.0,
        200.0, 10.0, 20.0, 1.0,
        10.0, false, true, true);
    testCookieCatalog.addCookie(gfsl);
    assertEquals(testCookieCatalog.findGlutenFreeSugarLiteCookies(), testCookieCatalog);

  }

  @Test
  void findNutsAndDairyCookies() {
    Cookie nd = new Cookie("Chocolate Chip", new String[] {"flour", "butter", "sugar", "chocolate chips"}, 1.0,
        200.0, 30.0, 20.0, 1.0,
        10.0, true, true, false);
    testCookieCatalog.addCookie(nd);
    assertEquals(testCookieCatalog.findNutsAndDairyCookies(), testCookieCatalog);
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testCookieCatalog.equals(testCookieCatalog));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testCookieCatalog.equals(null));
  }

  @Test
  void testEquals_DifferentTypes() {
    assertFalse(testCookieCatalog.equals("string"));
  }

  @Test
  void testEquals_DifferentObjectSameHead() {
    testCookieCatalog.addCookie(new Cookie("Chocolate Chip", new String[] {"flour", "butter", "sugar", "chocolate chips"}, 1.0,
        200.0, 30.0, 20.0, 1.0,
        10.0, false, true, false));
    CookieCatalog other = new CookieCatalog(new CookieNode(new Cookie("Chocolate Chip", new String[] {"flour", "butter", "sugar", "chocolate chips"}, 1.0,
        200.0, 30.0, 20.0, 1.0,
        10.0, false, true, false), null), 2);
    assertNotEquals(testCookieCatalog, other);
  }

  @Test
  void testEquals_DifferentObjectSameSize() {
    testCookieCatalog.addCookie(new Cookie("Chocolate Chip", new String[] {"flour", "butter", "sugar", "chocolate chips"}, 1.0,
        200.0, 30.0, 20.0, 1.0,
        10.0, false, true, false));
    CookieCatalog other = new CookieCatalog(new CookieNode(new Cookie("test", new String[] {"flour"}, 1.0,
        200.0, 30.0, 20.0, 1.0,
        10.0, false, true, false), null), 1);
    assertNotEquals(testCookieCatalog, other);
  }

  @Test
  void testEquals_DifferentObjectSameFields() {
    testCookieCatalog.addCookie(new Cookie("Chocolate Chip", new String[] {"flour", "butter", "sugar", "chocolate chips"}, 1.0,
        200.0, 30.0, 20.0, 1.0,
        10.0, false, true, false));
    CookieCatalog other = new CookieCatalog(new CookieNode(new Cookie("Chocolate Chip", new String[] {"flour", "butter", "sugar", "chocolate chips"}, 1.0,
        200.0, 30.0, 20.0, 1.0,
        10.0, false, true, false), null), 1);
    assertEquals(testCookieCatalog, other);
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(testCookieCatalog.getHead(), testCookieCatalog.countCookies());
    assertEquals(expectedHashCode, testCookieCatalog.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "CookieCatalog{" +
        "head=" + testCookieCatalog.getHead() +
        ", size=" + testCookieCatalog.countCookies() +
        '}';
    assertEquals(expectedString, testCookieCatalog.toString());
  }
}