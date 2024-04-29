package Option2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrashTest {
  private Crash testCrash;
  private LocalDate expectedDate;
  private CrashType expectedCrashType;
  private Name expectedName;

  @BeforeEach
  void setUp() {
    testCrash = new Crash(LocalDate.of(2024,4,26), CrashType.FENDER_BENDER,
        new Name("Alicia", "Keys"));
    expectedDate = LocalDate.of(2024,4,26);
    expectedCrashType = CrashType.FENDER_BENDER;
    expectedName = new Name("Alicia", "Keys");
  }

  @Test
  void getDate() {
    assertEquals(expectedDate, testCrash.getDate());
  }

  @Test
  void getType() {
    assertEquals(expectedCrashType, testCrash.getType());
  }

  @Test
  void getOffendingDriver() {
    assertEquals(expectedName, testCrash.getOffendingDriver());
  }
}