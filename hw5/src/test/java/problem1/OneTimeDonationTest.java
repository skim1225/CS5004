package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OneTimeDonationTest {

  private OneTimeDonation testDonation;
  Double expectedYearlyDonation;


  @BeforeEach
  void setUp() {
    testDonation = new OneTimeDonation(100.0, LocalDateTime.now());
    expectedYearlyDonation = 100.0;
  }

  @Test
  void getYearlyDonation_SameYear() {
    assertEquals(expectedYearlyDonation, testDonation.getYearlyDonation(2024));
  }

  @Test
  void getYearlyDonation_DifferentYear() {
    expectedYearlyDonation = 0.0;
    assertEquals(expectedYearlyDonation, testDonation.getYearlyDonation(2020));
  }
}