package problem1;

import java.time.LocalDate;

/**
 * Abstract part-time employee is an abstract class which holds information about part time
 * employees including their contracted hours, actual hours, and total earnings.
 */

public abstract class AbstractPartTimeEmployee extends AbstractEmployee {

  private static final Double PRODUCTIVITY_RATIO = 3.7;

  protected Double contractHours;
  protected Double actualHours;
  protected Double totalEarnings;

  /**
   * Constructor to help create concrete part-time employees
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
  public AbstractPartTimeEmployee(String employeeID, ContactInfo contactInfo,
      LocalDate employmentDate, EducationLevel educationLevel, EmploymentLevel employmentLevel,
      Double earnings, Double contractHours, Double actualHours, Double totalEarnings) {
    super(employeeID, contactInfo, employmentDate, educationLevel, employmentLevel, earnings);
    this.contractHours = contractHours;
    this.actualHours = actualHours;
    this.totalEarnings = totalEarnings;
  }

  /**
   * Returns estimated productivity rounded to 1 decimal place
   * @return estimated productivity rounded to 1 decimal place
   */
  @Override
  public Double estimateProductivity() {
    Double bonus = super.estimateProductivity();
    Double baseProductivity = Math.round(actualHours / contractHours * PRODUCTIVITY_RATIO * 10) / 10.0;
    return baseProductivity + bonus;
  }

  /**
   * Returns employee's contract hours
   * @return contract hours
   */
  public Double getContractHours() {
    return contractHours;
  }

  /**
   * Returns employee's actual hours
   * @return actual hours
   */
  public Double getActualHours() {
    return actualHours;
  }

  /**
   * Returns employee's total earnings
   * @return total earnings
   */
  public Double getTotalEarnings() {
    return totalEarnings;
  }
}