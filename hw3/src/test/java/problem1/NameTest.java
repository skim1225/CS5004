package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NameTest {
  private Name testName;
  private String expectedFirstName;
  private String expectedLastName;

  @BeforeEach
  void setUp() {
    testName = new Name("Sooji", "Kim");
    expectedFirstName = "Sooji";
    expectedLastName = "Kim";
  }

  @Test
  void getFirstName() {
    assertEquals(expectedFirstName, testName.getFirstName());
  }

  @Test
  void getLastName() {
    assertEquals(expectedLastName, testName.getLastName());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testName.equals(testName));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testName.equals(null));
  }

  @Test
  void testEquals_DifferentType() {
    assertFalse(testName.equals("String"));
  }

  @Test
  void testEquals_DifferentObjectSameFirstName() {
    Name otherName = new Name("Sooji", "test");
    assertFalse(testName.equals(otherName));
  }

  @Test
  void testEquals_DifferentObjectSameLastName() {
    Name otherName = new Name("test", "Kim");
    assertFalse(testName.equals(otherName));
  }

  @Test
  void testEquals_DifferentObjectSameName() {
    Name otherName = new Name("Sooji", "Kim");
    assertTrue(testName.equals(otherName));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(testName.getFirstName(), testName.getLastName());
    assertEquals(expectedHashCode, testName.hashCode());
  }
}