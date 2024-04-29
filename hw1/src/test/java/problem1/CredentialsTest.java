package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CredentialsTest {

  private Credentials testCredentials;
  private String expectedUsername;
  private String expectedPasswordHash;

  @BeforeEach
  void setUp() {
    testCredentials = new Credentials("username", "12345");
    expectedUsername = "username";
    expectedPasswordHash = "12345";
  }

  @Test
  void getUsername() {
    assertEquals(expectedUsername, testCredentials.getUsername());
  }

  @Test
  void setUsername() {
    String otherUsername = "other";
    testCredentials.setUsername(otherUsername);
    assertEquals(otherUsername, testCredentials.getUsername());
  }

  @Test
  void getPasswordHash() {
    assertEquals(expectedPasswordHash, testCredentials.getPasswordHash());
  }

  @Test
  void setPasswordHash() {
    String otherPasswordHash = "67890";
    testCredentials.setPasswordHash(otherPasswordHash);
    assertEquals(otherPasswordHash, testCredentials.getPasswordHash());
  }

  @Test
  void testEquals_SameObjects() {
    assertTrue(testCredentials.equals(testCredentials));
  }

  @Test
  void testEquals_NullObjects() {
    assertFalse(testCredentials.equals(null));
  }

  @Test
  void testEquals_DifferentDataType() {
    assertFalse(testCredentials.equals("String"));
  }

  @Test
  void testEquals_DifferentObjectSameUsername() {
    Credentials otherCredentials = new Credentials("username", "56789");
    assertFalse(testCredentials.equals(otherCredentials));
  }

  @Test
  void testEquals_DifferentObjectSamePasswordHash() {
    Credentials otherCredentials = new Credentials("test", "12345");
    assertFalse(testCredentials.equals(otherCredentials));
  }

  @Test
  void testEquals_DifferentObjectsSameValues() {
    Credentials otherCredentials = new Credentials("username", "12345");
    assertTrue(testCredentials.equals(otherCredentials));
  }

  @Test
  void testHashCode() {
    int expectedHash = Objects.hash(testCredentials.getUsername(), testCredentials.getPasswordHash());
    assertEquals(expectedHash, testCredentials.hashCode());
  }
}