package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PastaTest {

  Pasta testPasta = new Pasta("Spaghetti", 2.00, 150);

  @Test
  void testConstructor() {
    assertEquals(testPasta, testPasta);
  }

}