import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SaleTest {

  private Sale testSale;
  private Double expectedAskingPrice;
  private Boolean expectedNegotiable;

  @BeforeEach
  void setUp() throws InvalidArgumentException {
    testSale = new Sale(500000.0, Boolean.TRUE);
    expectedAskingPrice = 500000.0;
    expectedNegotiable = Boolean.TRUE;
  }

  @Test
  void testConstructor_InvalidAskingPrice() {
    Assertions.assertThrows(InvalidArgumentException.class, () -> {
      Sale o = new Sale(-100.0, Boolean.TRUE);
    });
  }

  @Test
  void getAskingPrice() {
    assertEquals(expectedAskingPrice, testSale.getAskingPrice());
  }

  @Test
  void getNegotiable() {
    assertEquals(expectedNegotiable, testSale.getNegotiable());
  }
}