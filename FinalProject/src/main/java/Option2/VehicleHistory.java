package Option2;

import java.util.List;
import java.util.Objects;

/**
 * Class VehicleHistory represents a vehicle's accident and moving violation history.
 */

public class VehicleHistory {
  private List<Crash> crashes;
  private List<Violation> violations;

  /**
   * Constructor for creating a new VehicleHistory.
   * @param crashes - The crashes to be set, as a list of crashes.
   * @param violations - The violations to be set, as a list of violations/
   */
  public VehicleHistory(List<Crash> crashes, List<Violation> violations) {
    this.crashes = crashes;
    this.violations = violations;
  }

  /**
   * Returns the vehicle's crashes, as a list of Crash objects.
   * @return the vehicle's crashes, as a list of Crash objects.
   */
  public List<Crash> getCrashes() {
    return crashes;
  }

  /**
   * Returns the vehicle's violations, as a list of Violation objects.
   * @return the vehicle's violations, as a list of Violation objects.
   */
  public List<Violation> getViolations() {
    return violations;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VehicleHistory that = (VehicleHistory) o;
    return Objects.equals(crashes, that.crashes) && Objects.equals(violations,
        that.violations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(crashes, violations);
  }

  @Override
  public String toString() {
    return "VehicleHistory{" +
        "crashes=" + crashes +
        ", violations=" + violations +
        '}';
  }
}
