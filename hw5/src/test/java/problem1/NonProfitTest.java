package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NonProfitTest {

  private NonProfit testNonProfit;
  private String expectedName;
  private ArrayList<AbstractDonation> expectedDonations;
  private Double expectedDonationsAmount;

  @BeforeEach
  void setUp() {
    testNonProfit = new NonProfit("Seattle Humane");
    expectedName = "Seattle Humane";
  }

  @Test
  void getOrganizationName() {
    assertEquals(expectedName, testNonProfit.getOrganizationName());
  }

  @Test
  void addDonation() {
    expectedDonations = new ArrayList<AbstractDonation>();
    OneTimeDonation testOneTimeDonation = new OneTimeDonation(200.0, LocalDateTime.now());
    testNonProfit.addDonation(testOneTimeDonation);
    expectedDonations.add(testOneTimeDonation);
    assertEquals(expectedDonations, testNonProfit.getDonations());
  }

  @Test
  void getDonations() {
    expectedDonations = new ArrayList<AbstractDonation>();
    assertEquals(expectedDonations, testNonProfit.getDonations());
  }

  @Test
  void getTotalDonationsForYear() throws InvalidDateException {
    Pledge testPledge = new Pledge(10.0, LocalDateTime.now());
    testPledge.setProcessingDate(LocalDateTime.of(2024,3,1,0,0,0));
    OneTimeDonation testOneTimeDonation = new OneTimeDonation(200.0, LocalDateTime.now());
    MonthlyDonation testMonthlyDonation = new MonthlyDonation(20.0, LocalDateTime.now());
    expectedDonations = new ArrayList<AbstractDonation>();
    testNonProfit.addDonation(testPledge);
    testNonProfit.addDonation(testOneTimeDonation);
    testNonProfit.addDonation(testMonthlyDonation);
    expectedDonations.add(testPledge);
    expectedDonations.add(testOneTimeDonation);
    expectedDonations.add(testMonthlyDonation);
    expectedDonationsAmount = 430.0;
    assertEquals(expectedDonationsAmount, testNonProfit.getTotalDonationsForYear(2024));
  }
}