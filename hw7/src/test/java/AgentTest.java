import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AgentTest {
  private Agent<Residential, Sale> testResidentalSaleAgent;
  private Agent<Commercial, Rental> testCommericalRentalAgent;
  private Agent<Property, Sale> testSaleAgent;

  private Listing<Commercial, Rental> testListing;
  private Listing<Residential, Sale> testListing2;
  private Listing<Commercial, Rental> testCommercialListing;

  @BeforeEach
  void setUp() throws InvalidArgumentException {
    testResidentalSaleAgent = new Agent<>("Mikal Bridges", 0.5);
    testCommericalRentalAgent = new Agent<> ("Lebron James", 1.0);
    testSaleAgent = new Agent<> ("Joel Embiid", 0.6);

    testListing = new Listing<>(new Commercial("225 Terry Ave N, Seattle, WA 98109", 40000, 15, Boolean.FALSE),
        new Rental(10.0, Boolean.TRUE, 24));
    testListing2 = new Listing<>(new Residential("5639 N 68th Pl, Paradise Valley, AZ, 85253", 7019, 5, 7.0),
        new Sale(7049500.0, Boolean.TRUE));
    testCommercialListing = new Listing<>(new Commercial("360 Huntington Ave, Boston, MA 02115", 40000, 15, Boolean.FALSE),
        new Rental(100.0, Boolean.TRUE, 24));
  }

  @Test
  void addListingAddResidential() {
    testResidentalSaleAgent.addListing(testListing2);
    testSaleAgent.addListing(testListing2);
    assertEquals(testResidentalSaleAgent.getListings(), testSaleAgent.getListings());
  }

  @Test
  void getTotalPortfolioValue() {
    testCommericalRentalAgent.addListing(testListing);
    testCommericalRentalAgent.addListing(testCommercialListing);
    assertEquals(testCommericalRentalAgent.getTotalPortfolioValue(), 2640.0);
  }
  @Test
  void completeListingTotalEarnings() throws InvalidListingException {
    testCommericalRentalAgent.addListing(testListing);
    testCommericalRentalAgent.completeListing(testListing);
    assertEquals(testCommericalRentalAgent.getTotalEarnings(), 240.0);
  }
  @Test
  void completeListingRemoves() throws InvalidListingException {
    testCommericalRentalAgent.addListing(testListing);
    testCommericalRentalAgent.completeListing(testListing);
    assertTrue(testCommericalRentalAgent.getListings().isEmpty());
  }

  @Test
  void dropListing() throws InvalidListingException {
    testCommericalRentalAgent.addListing(testListing);
    testCommericalRentalAgent.dropListing(testListing);
    assertTrue(testCommericalRentalAgent.getListings().isEmpty());
  }

  @Test
  void dropListingDoesNotExist() {
    assertThrows(InvalidListingException.class,
        () -> testCommericalRentalAgent.dropListing(testListing));
  }

  @Test
  void completeListingRemoveDoesNotExist() {
    assertThrows(InvalidListingException.class,
        () -> testCommericalRentalAgent.completeListing(testListing));
  }

<<<<<<< HEAD

=======
>>>>>>> main
  @Test
  void getAgentName() {
    assertEquals(testCommericalRentalAgent.getAgentName(), "Lebron James");
  }

  @Test
  void getCommissionRate() {
    assertEquals(testResidentalSaleAgent.getCommissionRate(), 0.5);
  }
<<<<<<< HEAD
}
=======
  
  @Test
  void invalidCommissionRateGreaterThan1() {
    assertThrows(InvalidArgumentException.class,
        () -> new Agent<> ("Lebron James", 1.1));
  }
  
  @Test
  void invalidCommissionRateNegativeValue() {
    assertThrows(InvalidArgumentException.class,
        () -> new Agent<> ("Lebron James", -1.1));
  }
}
>>>>>>> main
