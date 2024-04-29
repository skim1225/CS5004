import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResidentialTest {

  private Residential testResidential;
  private String expectedAddress;
  private Integer expectedSize;
  private Integer expectedNumBed;
  private Double expectedNumBath;

  @BeforeEach
  void setUp() throws InvalidArgumentException {
    testResidential = new Residential("225 Terry Ave N, Seattle, WA 98109", 30000, 1, 20.5);
    expectedAddress = "225 Terry Ave N, Seattle, WA 98109";
    expectedSize = 30000;
    expectedNumBed = 1;
    expectedNumBath = 20.5;
  }

  @Test
  void Constructor_InvalidSize() {
    Assertions.assertThrows(InvalidArgumentException.class, () -> {
      Residential other = new Residential("225 Terry Ave N, Seattle, WA 98109", -10, 0, 20.5);
    });
  }

  @Test
  void Constructor_InvalidNumBed() {
    Assertions.assertThrows(InvalidArgumentException.class, () -> {
      Residential other = new Residential("225 Terry Ave N, Seattle, WA 98109", 30000, -1, 20.5);
    });
  }

  @Test
  void Constructor_InvalidNumBath() {
    Assertions.assertThrows(InvalidArgumentException.class, () -> {
      Residential other = new Residential("225 Terry Ave N, Seattle, WA 98109", 30000, 0, -1.0);
    });
  }

  @Test
  void getAddress() {
    assertEquals(expectedAddress, testResidential.getAddress());
  }

  @Test
  void getSqFt() {
    assertEquals(expectedSize, testResidential.getSqFt());
  }

  @Test
  void getNumBed() {
    assertEquals(expectedNumBed, testResidential.getNumBed());
  }

  @Test
  void getNumBath() {
    assertEquals(expectedNumBath, testResidential.getNumBath());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testResidential.equals(testResidential));
  }

  @Test
  void testEquals_NullObject() {
    assertNotEquals(testResidential, null);
  }

  @Test
  void testEquals_DifferentTypes() {
    assertNotEquals(testResidential, "string");
  }

  @Test
  void testEquals_DifferentObjectSameAddress() throws InvalidArgumentException {
    Residential other = new Residential("225 Terry Ave N, Seattle, WA 98109", 0, 0, 0.0);
    assertNotEquals(other, testResidential);
  }

  @Test
  void testEquals_DifferentObjectSameSqFt() throws InvalidArgumentException {
    Residential other = new Residential("test", 30000, 0, 0.0);
    assertNotEquals(other, testResidential);
  }

  @Test
  void testEquals_DifferentObjectSameNumBed() throws InvalidArgumentException {
    Residential other = new Residential("test", 0, 1, 0.0);
    assertNotEquals(other, testResidential);
  }

  @Test
  void testEquals_DifferentObjectSameNumBath() throws InvalidArgumentException {
    Residential other = new Residential("test", 0, 0, 20.5);
    assertNotEquals(other, testResidential);
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(Objects.hash(testResidential.getAddress(),
        testResidential.getSqFt()), testResidential.getNumBed(), testResidential.getNumBath());
    assertEquals(expectedHashCode, testResidential.hashCode());
  }
}
