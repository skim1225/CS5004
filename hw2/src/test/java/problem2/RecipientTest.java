package problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RecipientTest {

  private Recipient testRecipient;
  private String expectedFirstName;
  private String expectedLastName;
  private String expectedEmailAddress;

  @BeforeEach
  void setUp() {
    testRecipient = new Recipient("Sooji", "Kim", "kim.sooji1@northeastern.edu");
    expectedFirstName = "Sooji";
    expectedLastName = "Kim";
    expectedEmailAddress = "kim.sooji1@northeastern.edu";
  }

  @Test
  void getFirstName() {
    assertEquals(expectedFirstName, testRecipient.getFirstName());
  }

  @Test
  void getLastName() {
    assertEquals(expectedLastName, testRecipient.getLastName());
  }

  @Test
  void getEmailAddress() {
    assertEquals(expectedEmailAddress, testRecipient.getEmailAddress());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testRecipient.equals(testRecipient));
  }

  @Test
  void testEquals_NullObject() {
    assertNotEquals(testRecipient, null);
  }

  @Test
  void testEquals_DifferentTypes() {
    assertNotEquals(testRecipient, "string");
  }

  @Test
  void testEquals_DifferentObjectsSameFirstName() {
    Recipient otherRecipient = new Recipient("Sooji", "test", "test");
    assertNotEquals(testRecipient, otherRecipient);
  }

  @Test
  void testEquals_DifferentObjectsSameLastName() {
    Recipient otherRecipient = new Recipient("test", "Kim", "test");
    assertNotEquals(testRecipient, otherRecipient);
  }

  @Test
  void testEquals_DifferentObjectsSameEmail() {
    Recipient otherRecipient = new Recipient("test", "test", "kim.sooji1@northeastern.edu");
    assertNotEquals(testRecipient, otherRecipient);
  }

  @Test
  void testEquals_DifferentObjectsSameFields() {
    Recipient otherRecipient = new Recipient("Sooji", "Kim", "kim.sooji1@northeastern.edu");
    assertEquals(testRecipient, otherRecipient);
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(testRecipient.getFirstName(), testRecipient.getLastName(),
        testRecipient.getEmailAddress());
    assertEquals(expectedHashCode, testRecipient.hashCode());
  }
}