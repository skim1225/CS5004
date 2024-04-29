package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IndividualTest {

  private Individual testIndividual;
  private String expectedFN;
  private String expectedLN;

  @BeforeEach
  void setUp() {
    testIndividual = new Author("Sooji", "Kim");
    expectedFN = "Sooji";
    expectedLN = "Kim";
  }

  @Test
  void getFirstName() {
    assertEquals(expectedFN, testIndividual.getFirstName());
  }

  @Test
  void getLastName() {
    assertEquals(expectedLN, testIndividual.getLastName());
  }
}