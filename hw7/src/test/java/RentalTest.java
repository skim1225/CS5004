import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RentalTest {

  private Rental testRental;
  private Integer expectedMonths;

  @BeforeEach
  void setUp() throws InvalidArgumentException {
    testRental = new Rental(10.0, Boolean.TRUE, 24);
    expectedMonths = 24;
  }

  @Test
  void testConstructor_InvalidTerm() throws InvalidArgumentException {
    Assertions.assertThrows(InvalidArgumentException.class, () -> {
      Rental o = new Rental(10.0, Boolean.TRUE, -1);
    });
  }

  @Test
  void getMonths() {
    assertEquals(expectedMonths, testRental.getMonths());
  }
}