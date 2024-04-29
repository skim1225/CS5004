package Option2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VehicleHistoryTest {
  private VehicleHistory testVehicleHistory;
  private List<Crash> expectedCrashes;
  private List<Violation> expectedViolations;


  @BeforeEach
  void setUp() {
    testVehicleHistory = new VehicleHistory(new ArrayList<>(Arrays.asList(new Crash(LocalDate.of(2024,4,26), CrashType.FENDER_BENDER,
        new Name("Alicia", "Keys")))), new ArrayList<>(Arrays.asList(new Violation(LocalDate.of(2024,4,26), NonMovingViolation.PARKING_VIOLATION))));
    expectedCrashes = new ArrayList<>(Arrays.asList(new Crash(LocalDate.of(2024,4,26), CrashType.FENDER_BENDER,
        new Name("Alicia", "Keys"))));
    expectedViolations = new ArrayList<>(Arrays.asList(new Violation(LocalDate.of(2024,4,26), NonMovingViolation.PARKING_VIOLATION)));
  }

  @Test
  void getCrashes() {
    assertEquals(expectedCrashes, testVehicleHistory.getCrashes());
  }

  @Test
  void getViolations() {
    assertEquals(expectedViolations, testVehicleHistory.getViolations());
  }
}