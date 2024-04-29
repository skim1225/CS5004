package Option2;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Class Violation represents a Violation as the date it occurred and the type of violation it was.
 */

public class Violation {
  private LocalDate violationDate;
  private ViolationType violationType;

  /**
   * Constructor for creating a new Violation object.
   * @param violationDate - The date of the violation, as a LocalDate.
   * @param violationType - The type of violation, as a ViolationType.
   */
  public Violation(LocalDate violationDate, ViolationType violationType) {
    this.violationDate = violationDate;
    this.violationType = violationType;
  }

  /**
   * Returns the date of the violation, as a LocalDate.
   * @return the date of the violation, as a LocalDate.
   */
  public LocalDate getViolationDate() {
    return violationDate;
  }

  /**
   * Returns the type of the violation, as a ViolationType.
   * @return the type of the violation, as a ViolationType.
   */
  public ViolationType getViolationType() {
    return violationType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Violation violation = (Violation) o;
    return Objects.equals(violationDate, violation.violationDate)
        && Objects.equals(violationType, violation.violationType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(violationDate, violationType);
  }

  @Override
  public String toString() {
    return "Violation{" +
        "violationDate=" + violationDate +
        ", violationType=" + violationType +
        '}';
  }
}
