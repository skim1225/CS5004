package problem1;

import java.time.LocalDate;
import java.util.Objects;

public class BenefitsEligibleEmployee extends AbstractPartTimeEmployee implements Employee {

  /**
   * Constructs a benefits eligible employee with given id, contact info, employment date,
   * education level, employment level, earnings, contract horus, actual hours, and
   * total earnings.
   * @param employeeID - Employee's ID as a String
   * @param contactInfo - Employee's contact info as a ContactInfo object
   * @param employmentDate - Employee's employment date as a LocalDate
   * @param educationLevel - Employee's education level as an EducationLevel
   * @param employmentLevel - Employee's employment level as a EmploymentLevel
   * @param earnings - Employee's earnings as a Double
   * @param contractHours - Employee's contract hours as a Double
   * @param actualHours - Employee's actual hours as a Double
   * @param totalEarnings - Employee's total earnings as a Double
   */
  public BenefitsEligibleEmployee(String employeeID, ContactInfo contactInfo,
      LocalDate employmentDate, EducationLevel educationLevel,
      EmploymentLevel employmentLevel, Double earnings, Double contractHours, Double actualHours,
      Double totalEarnings) {
    super(employeeID, contactInfo, employmentDate, educationLevel, employmentLevel, earnings,
        contractHours, actualHours, totalEarnings);
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
        actualHours, that.actualHours) && Objects.equals(totalEarnings, that.totalEarnings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(employeeID, contactInfo, employmentDate, educationLevel, employmentLevel,
        earnings, contractHours, actualHours, totalEarnings);
  }
}
