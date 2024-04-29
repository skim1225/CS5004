package Option2;

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
    testName = new Name("Bobby", "Bobbers");
    expectedFirstName = "Bobby";
    expectedLastName = "Bobbers";
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
    assertNotEquals(testName, null);
  }

  @Test
  void testEquals_DifferentType() {
    assertNotEquals(testName, "a string");
  }

  @Test
  void testEquals_DifferentObjectDifferentFields() {
    Name otherName = new Name("test", "test");
    assertNotEquals(otherName, testName);
  }

  @Test
  void testEquals_DifferentObjectSameFN() {
    Name otherName = new Name("Bobby", "test");
    assertNotEquals(otherName, testName);
  }

  @Test
  void testEquals_DifferentObjectSameLN() {
    Name otherName = new Name("test", "Bobbers");
    assertNotEquals(otherName, testName);
  }

  @Test
  void testEquals_DifferentObjectSameFields() {
    Name otherName = new Name("Bobby", "Bobbers");
    assertEquals(otherName, testName);
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(testName.getFirstName(), testName.getLastName());
    assertEquals(expectedHashCode, testName.hashCode());
  }

  @Test
  void testToString() {
    String ecxpectedString = "Name{" +
        "firstName='" + testName.getFirstName() + '\'' +
        ", lastName='" + testName.getLastName() + '\'' +
        '}';
  }
}