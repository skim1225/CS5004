package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

  private User testUser;
  private String expectedFirstName;
  private String expectedLastName;
  private String expectedPhoneNumber;
  private String expectedEmail;
  private Credentials expectedCredentials;

  @BeforeEach
  void setUp() {
    expectedCredentials = new Credentials("username", "passwordHash");
    testUser = new User("Sooji", "Kim", "1111111111",
        "kim.sooji1@Northeastern.edu", expectedCredentials);
    expectedFirstName = "Sooji";
    expectedLastName = "Kim";
    expectedPhoneNumber = "1111111111";
    expectedEmail = "kim.sooji1@Northeastern.edu";
  }

  @Test
  void getFirstName() {
    assertEquals(expectedFirstName, testUser.getFirstName());
  }

  @Test
  void getLastName() {
    assertEquals(expectedLastName, testUser.getLastName());
  }

  @Test
  void getPhoneNumber() {
    assertEquals(expectedPhoneNumber, testUser.getPhoneNumber());
  }

  @Test
  void getEmail() {
    assertEquals(expectedEmail, testUser.getEmail());
  }

  @Test
  void getCredentialPair() {
    assertEquals(expectedCredentials, testUser.getCredentialPair());
  }

  @Test
  void setFirstName() {
    String otherName = "blah";
    testUser.setFirstName(otherName);
    assertEquals(otherName, testUser.getFirstName());
  }

  @Test
  void setLastName() {
    String otherName = "blah";
    testUser.setLastName(otherName);
    assertEquals(otherName, testUser.getLastName());
  }

  @Test
  void setPhoneNumber() {
    String otherPhoneNumber = "0000000000";
    testUser.setPhoneNumber(otherPhoneNumber);
    assertEquals(otherPhoneNumber, testUser.getPhoneNumber());
  }

  @Test
  void setEmail() {
    String otherEmail = "blah@blah.com";
    testUser.setEmail(otherEmail);
    assertEquals(otherEmail, testUser.getEmail());
  }
  @Test
  void setCredentialPair() {
    Credentials otherCredentials = new Credentials("test", "test");
    testUser.setCredentialPair(otherCredentials);
    assertEquals(otherCredentials, testUser.getCredentialPair());
  }

  @Test
  void testEquals_SameObjects() {
    assertTrue(testUser.equals(testUser));
  }

  @Test
  void testEquals_NullObjects() {
    assertFalse(testUser.equals(null));
  }

  @Test
  void testEquals_DifferentDataType() {
    assertFalse(testUser.equals("String"));
  }

  @Test
  void testEquals_DifferentObjectSameFirstName() {
    Credentials otherCredentials = new Credentials("test", "test");
    User otherUser = new User("Sooji", "test", "0000000000",
        "test", otherCredentials);
    assertFalse(testUser.equals(otherUser));
  }

  void testEquals_DifferentObjectSameLastName() {
    Credentials otherCredentials = new Credentials("test", "test");
    User otherUser = new User("test", "Kim", "0000000000",
        "test", otherCredentials);
    assertFalse(testUser.equals(otherUser));
  }

  void testEquals_DifferentObjectSamePhoneNumber() {
    Credentials otherCredentials = new Credentials("test", "test");
    User otherUser = new User("test", "test", "1111111111",
        "test", otherCredentials);
    assertFalse(testUser.equals(otherUser));
  }

  void testEquals_DifferentObjectSameEmail() {
    Credentials otherCredentials = new Credentials("test", "test");
    User otherUser = new User("test", "test", "0000000000",
        "kim.sooji1@northeastern.edu", otherCredentials);
    assertFalse(testUser.equals(otherUser));
  }

  void testEquals_DifferentObjectSameValues() {
    Credentials otherCredentials = new Credentials("username", "passwordHash");
    User otherUser = new User("Sooji", "Kim", "1111111111",
        "kim.sooji1@Northeastern.edu", expectedCredentials);
    assertTrue(testUser.equals(otherUser));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(testUser.getFirstName(), testUser.getLastName(),
        testUser.getPhoneNumber(), testUser.getEmail(), testUser.getCredentialPair());
    assertEquals(expectedHashCode, testUser.hashCode());
  }
}