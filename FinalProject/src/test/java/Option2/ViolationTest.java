package Option2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ViolationTest {
  private Violation testViolation;
  private LocalDate expectedViolationDate;
  private ViolationType expectedViolationType;

  @BeforeEach
  void setUp() {
    testViolation = new Violation(LocalDate.of(2024,4,26), NonMovingViolation.PARKING_VIOLATION);
    expectedViolationDate = LocalDate.of(2024,4,26);
    expectedViolationType = NonMovingViolation.PARKING_VIOLATION;
  }

  @Test
  void getViolationDate() {
    assertEquals(expectedViolationDate, testViolation.getViolationDate());
  }

  @Test
  void getViolationType() {
    assertEquals(expectedViolationType, testViolation.getViolationType());
  }
}