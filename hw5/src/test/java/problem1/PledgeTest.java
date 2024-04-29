package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PledgeTest {

  private Pledge testPledge;
  private LocalDateTime expectedProcessingDate;

  @BeforeEach
  void setUp() {
    testPledge = new Pledge(10.0, LocalDateTime.now(), LocalDateTime.of(2025,1,1,0,0,0));
    expectedProcessingDate = LocalDateTime.of(2025,1,1,0,0,0);
  }

  @Test
  void getProcessingDate() {
    assertEquals(expectedProcessingDate, testPledge.getProcessingDate());
  }

  @Test
  void setProcessingDate() throws InvalidDateException {
    testPledge.setProcessingDate(LocalDateTime.of(2026,1,1,0,0,0));
    expectedProcessingDate = LocalDateTime.of(2026,1,1,0,0,0);
    assertEquals(expectedProcessingDate, testPledge.getProcessingDate());
  }

  @Test
  void setProcessingDate_InvalidDateFailure() {
    Assertions.assertThrows(InvalidDateException.class, () -> {
      testPledge.setProcessingDate(LocalDateTime.of(2000,1,1,0,0,0));
    });
  }

  @Test
  void getYearlyDonation_PledgeYear() {
    assertEquals(10.0, testPledge.getYearlyDonation(2025));
  }

  @Test
  void getYearlyDonation_NotPledgeYear() {
    assertEquals(0.0, testPledge.getYearlyDonation(2024));
  }
  @Test
  void getYearlyDonation_NoProcessingDate() {
  Pledge other = new Pledge(10.0, LocalDateTime.now());
  assertEquals(0.0, other.getYearlyDonation(2024));
  }


}