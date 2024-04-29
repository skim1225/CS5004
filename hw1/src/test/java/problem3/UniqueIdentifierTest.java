package problem3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UniqueIdentifierTest {

  private UniqueIdentifier testID;
  private Integer expectedYearCreated;
  private String expectedCountryCreated;


  @BeforeEach
  void setUp() {
    testID = new UniqueIdentifier(2023, "Korea");
    expectedYearCreated = 2023;
    expectedCountryCreated = "Korea";
  }

  @Test
  void getYearCreated() {
    assertEquals(expectedYearCreated, testID.getYearCreated());
  }

  @Test
  void getCountryCreated() {
    assertEquals(expectedCountryCreated, testID.getCountryCreated());
  }

  @Test
  void testEquals_SameObjects() {
    assertTrue(testID.equals(testID));
  }

  @Test
  void testEquals_NullObjects() {
    assertFalse(testID.equals(null));
  }

  @Test
  void testEquals_DifferentDataType() {
    assertFalse(testID.equals("String"));
  }

  @Test
  void testEquals_DifferentObjectSameYearCreated() {
    UniqueIdentifier otherID = new UniqueIdentifier(2023, "China");
    assertNotEquals(otherID, testID);
  }

  @Test
  void testEquals_DifferentObjectsSameCountryCreated() {
    UniqueIdentifier otherID = new UniqueIdentifier(2024, "Korea");
    assertNotEquals(otherID, testID);
  }

  @Test
  void testEquals_DifferentObjectsSameValues() {
    UniqueIdentifier otherID = new UniqueIdentifier(2023, "Korea");
    assertEquals(otherID, testID);
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(testID.getYearCreated(), testID.getCountryCreated());
  }
}