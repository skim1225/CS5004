package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AbstractDonationTest {

  private OneTimeDonation testDonation;
  private Double expectedAmount;
  private LocalDateTime expectedCreationDate;


  @BeforeEach
  void setUp() {
    testDonation = new OneTimeDonation(10.00, LocalDateTime.of(2024,1,1,10,0,0));
    expectedAmount = 10.0;
    expectedCreationDate = LocalDateTime.of(2024,1,1,10,0,0);
  }

  @Test
  void getAmount() {
    assertEquals(expectedAmount, testDonation.getAmount());
  }

  @Test
  void getCreationDate() {
    assertEquals(expectedCreationDate, testDonation.getCreationDate());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testDonation.equals(testDonation));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testDonation.equals(null));
  }

  @Test
  void testEquals_DifferentTypes() {
    assertFalse(testDonation.equals("string"));
  }

  @Test
  void testEquals_DifferentObjectSameAmount() {
    OneTimeDonation other = new OneTimeDonation(10.0, LocalDateTime.now());
    assertNotEquals(other, testDonation);
  }

  @Test
  void testEquals_DifferentObjectSameCreation() {
    OneTimeDonation other = new OneTimeDonation(100.0, LocalDateTime.of(2024,1,1,10,0,0));
    assertNotEquals(other, testDonation);
  }

  @Test
  void testEquals_DifferentObjectSameFields() {
    OneTimeDonation other = new OneTimeDonation(10.0, LocalDateTime.of(2024,1,1,10,0,0));
    assertEquals(other, testDonation);
  }

  @Test
  void testHashCode() {
    int expectedHash = Objects.hash(expectedAmount, expectedCreationDate);
    assertEquals(expectedHash, testDonation.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "AbstractDonation{" +
        "amount=" + testDonation.getAmount() +
        ", date=" + testDonation.getCreationDate() +
        '}';
    assertEquals(expectedString, testDonation.toString());
  }
}