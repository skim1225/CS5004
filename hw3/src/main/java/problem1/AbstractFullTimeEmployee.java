package problem1;

import java.time.LocalDate;
import java.time.Period;

/**
 * Class AbstractFullTimeEmployee represents a full time employee as their base pay, bonuses,
 * overtime, last promotion date, and number of projects.
 */
public abstract class AbstractFullTimeEmployee extends AbstractEmployee{
  private static final Double PROMOTION_PENALTY = 0.8;
  private static final Integer PROMOTION_THRESHOLD = 3;
  private static final Integer PROJECTS_THRESHOLD = 2;
  private static final Double PROJECTS_BONUS = 1.5;

  protected Double basePay;
  protected Double bonuses;
  protected Double overtime;
  protected LocalDate lastPromotionDate;
  protected Integer numProjects;

  /**
   * Helps construct concrete full time employees with the given fields.
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
   */
  public AbstractFullTimeEmployee(String employeeID, ContactInfo contactInfo,
      LocalDate employmentDate, EducationLevel educationLevel, EmploymentLevel employmentLevel,
      Double earnings, Double basePay, Double bonuses, Double overtime, LocalDate lastPromotionDate,
      Integer numProjects) {
    super(employeeID, contactInfo, employmentDate, educationLevel, employmentLevel, earnings);
    this.basePay = basePay;
    this.bonuses = bonuses;
    this.overtime = overtime;
    this.lastPromotionDate = lastPromotionDate;
    this.numProjects = numProjects;
  }

  /**
   * Returns the employee's estimated productivity rounded to 1 decimal place
   * @return estimated productivity
   */
  @Override
  public Double estimateProductivity() {
    Double baseProductivity = this.earnings / this.basePay;
    baseProductivity =  Math.round(baseProductivity * 10) / 10.0;
    Double bonus = super.estimateProductivity();
    if (timeDifferenceExceedsThreshold(lastPromotionDate, LocalDate.now())) {
      bonus -= PROMOTION_PENALTY;
    }
    if (numProjects > PROJECTS_THRESHOLD) {
      bonus += PROJECTS_BONUS;
    }
    return baseProductivity + bonus;
  }

  /**
   * A helper method to determine whether the time since the employee has last been promoted
   * exceeds the penalty limit.
   * @param startDate - The date of the employees last promotion as a LocalDate
   * @param endDate - The current date as a LocalDate
   * @return - Whether the time since last promotion exceeds penalty limit as a Boolean
   */
  public Boolean timeDifferenceExceedsThreshold(LocalDate startDate, LocalDate endDate) {
    Period timeBetween = Period.between(startDate, endDate);
    return timeBetween.getYears() >= PROMOTION_THRESHOLD;
}

  /**
   * Returns the employee's base pay
   * @return base pay
   */
  public Double getBasePay() {
    return basePay;
  }

  /**
   * Returns the employee's bonuses
   * @return bonuses
   */
  public Double getBonuses() {
    return bonuses;
  }

  /**
   * Returns the employee's overtime
   * @return overtime
   */
  public Double getOvertime() {
    return overtime;
  }

  /**
   * Returns the employee's last promotion date
   * @return last promotion date
   */
  public LocalDate getLastPromotionDate() {
    return lastPromotionDate;
  }

  /**
   * Returns the employee's number of projects
   * @return number of projects
   */
  public Integer getNumProjects() {
    return numProjects;
  }
}
