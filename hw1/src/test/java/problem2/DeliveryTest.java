package problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeliveryTest {

  private Delivery testDelivery;
  private String expectedStartLocation;
  private String expectedEndLocation;
  private Time expectedStartTime;
  private Time expectedEndTime;

  @BeforeEach
  void setUp() {
    testDelivery = new Delivery("FiveGuys", "Home",
        new Time(10, 30,0), new Time(12, 0, 15));
    expectedStartLocation = "FiveGuys";
    expectedEndLocation = "Home";
    expectedStartTime = new Time(10, 30,0);
    expectedEndTime = new Time(12, 0, 15);
  }

  @Test
  void getStartLocation() {
    assertEquals(expectedStartLocation, testDelivery.getStartLocation());
  }

  @Test
  void getEndLocation() {
    assertEquals(expectedEndLocation, testDelivery.getEndLocation());
  }

  @Test
  void getStartTime() {
    assertEquals(expectedStartTime, testDelivery.getStartTime());
  }

  @Test
  void getEndTime() {
    assertEquals(expectedEndTime, testDelivery.getEndTime());
  }

  @Test
  void getDuration() {
    Time expectedDuration = new Time(1,30,15);
    assertEquals(expectedDuration, testDelivery.getDuration());
  }

  @Test
  void testEquals_SameObjects() {
    assertTrue(testDelivery.equals(testDelivery));
  }

  @Test
  void testEquals_NullComparison() {
    assertFalse(testDelivery.equals(null));
  }

  @Test
  void testEquals_DifferentDataTypes() {
    assertFalse(testDelivery.equals("String"));
  }

  @Test
  void testEquals_DifferentObjectsSameStartLocation() {
    Delivery otherDelivery = new Delivery("FiveGuys", "test", new Time(0,0,0),
        new Time(1,1,1));
    assertNotEquals(testDelivery, otherDelivery);
  }

  @Test
  void testEquals_DifferentObjectsSameEndLocation() {
    Delivery otherDelivery = new Delivery("test", "Home", new Time(0,0,0),
        new Time(1,1,1));
    assertNotEquals(testDelivery, otherDelivery);
  }

  @Test
  void testEquals_DifferentObjectsSameStartTime() {
    Delivery otherDelivery = new Delivery("test", "test", new Time(10,30,0),
        new Time(11,1,1));
    assertNotEquals(testDelivery, otherDelivery);
  }

  @Test
  void testEquals_DifferentObjectsSameEndTime() {
    Delivery otherDelivery = new Delivery("test", "Home", new Time(0,0,0),
        new Time(12,0,15));
    assertNotEquals(testDelivery, otherDelivery);
  }

  @Test
  void testEquals_DifferentObjectsSameValues() {
    Delivery otherDelivery = new Delivery("FiveGuys", "Home",
        new Time(10, 30,0), new Time(12, 0, 15));
    assertEquals(testDelivery, otherDelivery);
  }

  @Test
  void testHashCode() {
    int expectedHash = Objects.hash(testDelivery.getStartLocation(), testDelivery.getEndLocation(),
        testDelivery.getStartTime(), testDelivery.getEndTime());
    assertEquals(expectedHash, testDelivery.hashCode());
  }
}