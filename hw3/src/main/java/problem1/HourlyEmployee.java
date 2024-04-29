package problem1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Class Hourly Employee stores information about an hourly employee including their
 * hourly earnings.
 */
public class HourlyEmployee extends AbstractPartTimeEmployee implements Employee {
  private static final Integer PRODUCTIVITY_BONUS = 3;
  private static final Integer HOURLY_RATE_THRESHOLD = 14;

  private Double hourlyEarnings;

  /**
   * Constructs a new Hourly employee object with the given id, contact info, employment date,
   * education level, employment level, earnings, contract hours, actual hours, total earnings,
   * and hourly earnings.
   *
   * @param employeeID - Employee's ID as a String
   * @param contactInfo - Employee's contact info as a ContactInfo object
   * @param employmentDate - Employee's employment date as a LocalDate
   * @param educationLevel - Employee's education level as an EducationLevel
   * @param employmentLevel - Employee's employment level as a EmploymentLevel
   * @param earnings - Employee's earnings as a Double
   * @param contractHours - Employee's contract hours as a Double
   * @param actualHours - Employee's actual hours as a Double
   * @param totalEarnings - Employee's total earnings as a Double
   * @param hourlyEarnings - Employee's hourly earnings as a Double
   */
  public HourlyEmployee(String employeeID, ContactInfo contactInfo,
      LocalDate employmentDate, EducationLevel educationLevel,
      EmploymentLevel employmentLevel, Double earnings, Double contractHours, Double actualHours,
      Double totalEarnings, Double hourlyEarnings) {
    super(employeeID, contactInfo, employmentDate, educationLevel, employmentLevel, earnings,
        contractHours, actualHours, totalEarnings);
    this.hourlyEarnings = hourlyEarnings;
  }

  /**
   * Returns the employee's estimated productivity
   * @return estimated productivity
   */
  @Override
  public Double estimateProductivity() {
    Double productivity = super.estimateProductivity();
    if (hourlyEarnings < HOURLY_RATE_THRESHOLD) {
      productivity += PRODUCTIVITY_BONUS;
    }
    return productivity;
  }

  /**
   * Returns the employee's hourly earnings
   * @return hourly earnings
   */
  public Double getHourlyEarnings() {
    return hourlyEarnings;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    HourlyEmployee that = (HourlyEmployee) o;
    return Objects.equals(employeeID, that.employeeID) && Objects.equals(
        contactInfo, that.contactInfo) && Objects.equals(employmentDate,
        that.employmentDate) && educationLevel == that.educationLevel
        && employmentLevel == that.employmentLevel && Objects.equals(earnings,
        that.earnings) && Objects.equals(contractHours, that.contractHours) && Objects.equals(
        actualHours, that.actualHours) && Objects.equals(totalEarnings, that.totalEarnings) &&
        Objects.equals(hourlyEarnings, that.hourlyEarnings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(employeeID, contactInfo, employmentDate, educationLevel, employmentLevel,
        earnings, contractHours, actualHours, totalEarnings, hourlyEarnings);
  }
}
