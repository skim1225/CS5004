import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListingTest {

  private Listing<Property, Contract> testListing;
  private Property expectedProperty;
  private Contract expectedContract;

  @BeforeEach
  void setUp() throws InvalidArgumentException {
    testListing = new Listing<>(new Commercial("225 Terry Ave N, Seattle, WA 98109", 40000, 15, Boolean.FALSE),
        new Rental(10.0, Boolean.TRUE, 24));
    expectedProperty = new Commercial("225 Terry Ave N, Seattle, WA 98109", 40000, 15, Boolean.FALSE);
    expectedContract = new Rental(10.0, Boolean.TRUE, 24);
  }

  @Test
  void getProperty() {
    assertEquals(expectedProperty, testListing.getProperty());
  }

  @Test
  void getContract() {
    assertEquals(expectedContract, testListing.getContract());
  }
}