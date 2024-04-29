package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactInfoTest {

  private ContactInfo testContact;
  private Name expectedName;
  private String expectedAddress;
  private String expectedPhoneNumber;
  private String expectedEmail;
  private Name expectedEmergencyContact;

  @BeforeEach
  void setUp() {
    testContact = new ContactInfo(new Name("Sooji", "Kim"), "address", "phone",
        "email", new Name("My", "Mom"));
    expectedName = new Name("Sooji", "Kim");
    expectedAddress = "address";
    expectedPhoneNumber = "phone";
    expectedEmail = "email";
    expectedEmergencyContact = new Name("My", "Mom");
  }

  @Test
  void getName() {
    assertEquals(expectedName, testContact.getName());
  }

  @Test
  void getAddress() {
    assertEquals(expectedAddress, testContact.getAddress());
  }

  @Test
  void getPhoneNumber() {
    assertEquals(expectedPhoneNumber, testContact.getPhoneNumber());
  }

  @Test
  void getEmailAddress() {
    assertEquals(expectedEmail, testContact.getEmailAddress());
  }

  @Test
  void getEmergencyContact() {
    assertEquals(expectedEmergencyContact, testContact.getEmergencyContact());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testContact.equals(testContact));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testContact.equals(null));
  }

  @Test
  void testEquals_DifferentType() {
    assertFalse(testContact.equals("String"));
  }

  @Test
  void testEquals_DifferentObjectSameName() {
    ContactInfo otherContact = new ContactInfo(new Name("Sooji", "Kim"), "a", "a",
        "a", new Name("a", "a"));
    assertFalse(testContact.equals(otherContact));
  }

  @Test
  void testEquals_DifferentObjectSameAddress() {
    ContactInfo otherContact = new ContactInfo(new Name("a", "a"), "address", "a",
        "a", new Name("a", "a"));
    assertFalse(testContact.equals(otherContact));
  }

  @Test
  void testEquals_DifferentObjectSamePhoneNumber() {
    ContactInfo otherContact = new ContactInfo(new Name("a", "a"), "a", "phone",
        "a", new Name("a", "a"));
    assertFalse(testContact.equals(otherContact));
  }

  @Test
  void testEquals_DifferentObjectSameEmail() {
    ContactInfo otherContact = new ContactInfo(new Name("a", "a"), "a", "a",
        "email", new Name("a", "a"));
    assertFalse(testContact.equals(otherContact));
  }

  @Test
  void testEquals_DifferentObjectSameEmergencyContact() {
    ContactInfo otherContact = new ContactInfo(new Name("a", "a"), "a", "a",
        "a", new Name("My", "Mom"));
    assertFalse(testContact.equals(otherContact));
  }

  @Test
  void testEquals_DifferentObjectSameFields() {
    ContactInfo otherContact = new ContactInfo(new Name("Sooji", "Kim"), "address", "phone",
        "email", new Name("My", "Mom"));
    assertTrue(testContact.equals(otherContact));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(testContact.getName(), testContact.getAddress(),
        testContact.getPhoneNumber(), testContact.getEmailAddress(), testContact.getEmergencyContact());
    assertEquals(expectedHashCode, testContact.hashCode());
  }
}