package problem1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Manager is a class that represents a Manager object as the number of employees managed as well
 * as other fields inherited from Abstract Full Time Employees.
 */
public class Manager extends AbstractFullTimeEmployee implements Employee{
  private static final Integer EMPLOYEE_THRESHOLD = 8;
  private static final Double EMPLOYEE_BONUS = 1.8;
  private Integer numEmployeesManaged;

  /**
   * Constructor creating a new Manager object with given id, contact info,
   * employment date, education level, employment level, earnings, contract hours, actual hours,
   * total earnings, and number of employees managed.
   * @param employeeID - Employee's ID as a String
   * @param contactInfo - Employee's contact info as a ContactInfo object
   * @param employmentDate - Employee's employment date as a LocalDate
   * @param educationLevel - Employee's education level as an EducationLevel
   * @param employmentLevel - Employee's employment level as a EmploymentLevel
   * @param earnings - Employee's earnings as a Double
   * @param basePay - Employee's base pay as a Double
   * @param bonuses - Employee's bonuses as a Double
   * @param overtime - Employee's overtime as a Double
   * @param lastPromotionDate - Employee's last promotion date as a LocalDate
   * @param numProjects - Employee's number of projects as an Integer
   * @param numEmployeesManaged - Employee's number of employees managed as an Integer
   */
  public Manager(String employeeID, ContactInfo contactInfo, LocalDate employmentDate,
      EducationLevel educationLevel, EmploymentLevel employmentLevel, Double earnings,
      Double basePay,
      Double bonuses, Double overtime, LocalDate lastPromotionDate, Integer numProjects,
      Integer numEmployeesManaged) {
    super(employeeID, contactInfo, employmentDate, educationLevel, employmentLevel, earnings,
        basePay, bonuses, overtime, lastPromotionDate, numProjects);
    this.numEmployeesManaged = numEmployeesManaged;
  }

  /**
   * Returns the manager's estimated productivity
   * @return estimated productivity
   */
  @Override
  public Double estimateProductivity() {
    Double productivity = super.estimateProductivity();
    if (numEmployeesManaged > EMPLOYEE_THRESHOLD) {
      productivity += EMPLOYEE_BONUS;
    }
    return productivity;
  }

  /**
   * Returns the number of employees managed
   * @return number of employees managed
   */
  public Integer getNumEmployeesManaged() {
    return numEmployeesManaged;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Manager that = (Manager) o;
    return Objects.equals(employeeID, that.employeeID) && Objects.equals(
        contactInfo, that.contactInfo) && Objects.equals(employmentDate,
        that.employmentDate) && Objects.equals(educationLevel, that.educationLevel)
        && Objects.equals(employmentLevel, that.employmentLevel) && Objects.equals(earnings,
        that.earnings) && Objects.equals(basePay, that.basePay) && Objects.equals(bonuses,
        that.bonuses) && Objects.equals(overtime, that.overtime)
        && Objects.equals(lastPromotionDate, that.lastPromotionDate)
        && Objects.equals(numProjects, that.numProjects) &&
        Objects.equals(numEmployeesManaged, that.numEmployeesManaged);
  }

  @Override
  public int hashCode() {
    return Objects.hash(employeeID, contactInfo, employmentDate, educationLevel, employmentLevel,
        earnings, basePay, bonuses, overtime, lastPromotionDate,
        numProjects, numEmployeesManaged);
  }
}
