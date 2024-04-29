package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NameTest {

  private Name testName;
  private String expectedFirstName;
  private String expectedMiddleName;
  private String expectedLastName;


  @BeforeEach
  void setUp() {
    testName = new Name("Jillian", "Florence", "Martin");
    expectedFirstName = "Jillian";
    expectedMiddleName = "Florence";
    expectedLastName = "Martin";
  }

  @Test
  void getFirstName() {
    assertEquals(expectedFirstName, testName.getFirstName());
  }

  @Test
  void getMiddleName() {
    assertEquals(expectedMiddleName, testName.getMiddleName());
  }

  @Test
  void getLastName() {
    assertEquals(expectedLastName, testName.getLastName());
  }
}