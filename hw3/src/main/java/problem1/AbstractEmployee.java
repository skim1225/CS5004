package problem1;

import java.time.LocalDate;

/**
 * AbstractEmployee is an abstract class which represents employees as their ID, contact info,
 * employment date, education level, employment level, and earnings.
 */
public abstract class AbstractEmployee implements Employee {
  private static final Double EMPLOYMENT_LEVEL_BONUS = 1.4;

  protected String employeeID;
  protected ContactInfo contactInfo;
  protected LocalDate employmentDate;
  protected EducationLevel educationLevel;
  protected EmploymentLevel employmentLevel;
  protected Double earnings;

  /**
   * Used to create concrete employees with the given fields.
   * @param employeeID - Employee's ID as a String
   * @param contactInfo - Employee's contact info as a ContactInfo object
   * @param employmentDate - Employee's employment date as a LocalDate
   * @param educationLevel - Employee's education level as an EducationLevel
   * @param employmentLevel - Employee's employment level as a EmploymentLevel
   * @param earnings - Employee's earnings as a Double
   */
  public AbstractEmployee(String employeeID, ContactInfo contactInfo, LocalDate employmentDate,
      EducationLevel educationLevel, EmploymentLevel employmentLevel, Double earnings) {
    this.employeeID = employeeID;
    this.contactInfo = contactInfo;
    this.employmentDate = employmentDate;
    this.educationLevel = educationLevel;
    this.employmentLevel = employmentLevel;
    this.earnings = earnings;
  }

  /**
   * Returns the employee's ID
   * @return employeeID
   */
  public String getEmployeeID() {
    return employeeID;
  }

  /**
   * Returns the employee's contact info
   * @return contact info
   */
  public ContactInfo getContactInfo() {
    return contactInfo;
  }

  /**
   * Returns the employee's employment date
   * @return employment date
   */
  public LocalDate getEmploymentDate() {
    return employmentDate;
  }

  /**
   * Returns the employee's education level
   * @return education level
   */
  public EducationLevel getEducationLevel() {
    return educationLevel;
  }

  /**
   * Returns the employee's employment level
   * @return employment level
   */
  public EmploymentLevel getEmploymentLevel() {
    return employmentLevel;
  }

  /**
   * Returns the employee's earnings
   * @return earnings
   */
  public Double getEarnings() {
    return earnings;
  }

  /**
   * Returns the productivity bonus from employement level
   * @return productivity bonus
   */
  @Override
  public Double estimateProductivity() {
    Double bonus = 0.0;
    if (employmentLevel.equals(EmploymentLevel.INTERMEDIATE_LEVEL)) {
      bonus += EMPLOYMENT_LEVEL_BONUS;
    }
    return bonus;
  }
}

