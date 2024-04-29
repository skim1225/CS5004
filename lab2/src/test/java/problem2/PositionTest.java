package problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PositionTest {

  private Position testPosition;
  private Integer expectedX;
  private Integer expectedY;

  @BeforeEach
  void setUp() {
    testPosition = new Position(5, 5);
    expectedX = 5; // example of autoboxing
    expectedY = 5;
  }

  @Test
  void getxCoordinate() {
    assertEquals(expectedX, testPosition.getxCoordinate());
  }

  @Test
  void getyCoordinate() {
    assertEquals(expectedY, testPosition.getyCoordinate());
  }

  @Test
  void testEquals_SameObjects() {
    assertTrue(testPosition.equals(testPosition));
  }

  @Test
  void testEquals_NullComparison() {
    assertFalse(testPosition.equals(null));
  }

  @Test
  void testEquals_DifferentDataTypes() {
    assertFalse(testPosition.equals("String"));
  }

  @Test
  void testEquals_DifferentObjectsSameX() {
    Position otherPosition = new Position(5, 10);
    assertFalse(testPosition.equals(otherPosition));
  }

  @Test
  void testEquals_DifferentObjectsSameY() {
  Position otherPosition = new Position(10, 5);
  assertFalse(testPosition.equals(otherPosition));
  }

  @Test
  void testEquals_DifferentObjectsSameValues() {
    Position otherPosition = new Position(5,5);
    assertTrue(testPosition.equals(otherPosition));

  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(testPosition.getxCoordinate(), testPosition.getyCoordinate());
    assertEquals(expectedHashCode, testPosition.hashCode());
  }
}