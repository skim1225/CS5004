package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MonthlyDonationTest {

  private MonthlyDonation testDonation;
  private LocalDateTime expectedCancellationDateTime;

  @BeforeEach
  void setUp() {
    testDonation = new MonthlyDonation(10.0, LocalDateTime.of(2024,2,1,0,0,0));
  }

  @Test
  void getCancellationDateTime() {
    assertEquals(null, testDonation.getCancellationDateTime());
  }

  @Test
  void setCancellationDateTime() throws InvalidDateException {
    testDonation.setCancellationDateTime(LocalDateTime.of(2024,3,1,10,0,0));
    expectedCancellationDateTime = LocalDateTime.of(2024,3,1,10,0,0);
    assertEquals(expectedCancellationDateTime, testDonation.getCancellationDateTime());
  }

  @Test
  void setCancellationDateTimeFailure() {
    Assertions.assertThrows(InvalidDateException.class, () -> {
      testDonation.setCancellationDateTime(LocalDateTime.of(2020,1,1,0,0,0));
    });
  }

  @Test
  void getYearlyDonation_Case0() {
    assertEquals(0.0, testDonation.getYearlyDonation(2000));
  }

  @Test
  void getYearlyDonation_Case1a() {
    assertEquals(110.0, testDonation.getYearlyDonation(2024));
  }

  @Test
  void getYearlyDonation_Case1b() {
    assertEquals(120.0, testDonation.getYearlyDonation(2025));
  }

  @Test
  void getYearlyDonation_Case2a() throws InvalidDateException {
    testDonation.setCancellationDateTime(LocalDateTime.of(2024,3,1,0,0,0));
    assertEquals(0.0, testDonation.getYearlyDonation(2025));
  }

  @Test
  void getYearlyDonation_Case2b() throws InvalidDateException {
    testDonation.setCancellationDateTime(LocalDateTime.of(2026,3,1,0,0,0));
    assertEquals(120.0, testDonation.getYearlyDonation(2025));
  }

  @Test
  void getYearlyDonation_Case2c() throws InvalidDateException {
    testDonation.setCancellationDateTime(LocalDateTime.of(2025,3,1,0,0,1));
    assertEquals(30.0, testDonation.getYearlyDonation(2025));
  }

  @Test
  void getYearlyDonation_Case2d() throws InvalidDateException {
    testDonation.setCancellationDateTime(LocalDateTime.of(2024,4,1,0,0,1));
    assertEquals(30.0, testDonation.getYearlyDonation(2024));
  }

}