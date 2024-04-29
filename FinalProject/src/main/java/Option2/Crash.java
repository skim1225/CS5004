package Option2;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Class Crash stores information about a car crash including the date it occurred, the type of
 * crash, and the name of the offending driver.
 */

public class Crash {

  private LocalDate date;
  private CrashType type;
  private Name offendingDriver;

  /**
   * Constructor for creating a new Crash object.
   * @param date - The date the Crash occurred, as a Date.
   * @param type - The type of Crash, as a CrashType
   * @param offendingDriver - The name of the offending Driver, as a Name.
   */
  public Crash(LocalDate date, CrashType type, Name offendingDriver) {
    this.date = date;
    this.type = type;
    this.offendingDriver = offendingDriver;
  }

  /**
   * Returns the date of the Crash, as a LocalDate.
   * @return  the date of the Crash, as a LocalDate.
   */
  public LocalDate getDate() {
    return date;
  }

  /**
   * Returns the type of Crash, as a CrashType.
   * @return the type of Crash, as a CrashType.
   */
  public CrashType getType() {
    return type;
  }

  /**
   * Returns the Name of the offending Driver, as a Name.
   * @return the Name of the offending Driver, as a Name.
   */
  public Name getOffendingDriver() {
    return offendingDriver;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Crash crash = (Crash) o;
    return Objects.equals(date, crash.date) && type == crash.type
        && Objects.equals(offendingDriver, crash.offendingDriver);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, type, offendingDriver);
  }
}