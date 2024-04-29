package problem1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * IndividualContributor is a class that represents an Individual Contractor as a number of
 * patents, number of publications, and number of external projects, as well as the fields of
 * the AbstractFullTimeEmployee class.
 */
public class IndividualContributor extends AbstractFullTimeEmployee implements Employee {
  private static final Integer PUBLICATIONS_THRESHOLD = 4;
  private static final Double PUBLICATIONS_BONUS = 1.3;
  private Integer numPatents;
  private Integer numPublications;
  private Integer numExternalProjects;

  /**
   * Constructor creating a new Individual Contributor object with the given id, contact info,
   * employment date, education level, employment level, earnings, contract hours, actual hours,
   * total earnings, number of patents, number of publications, and number of external projects.
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
   * @param numPatents - Employee's number of patents as an Integer
   * @param numPublications - Employee's number of publications as an Integer
   * @param numExternalProjects - Employee's number of external projects as an Integer
   */
  public IndividualContributor(String employeeID, ContactInfo contactInfo,
      LocalDate employmentDate, EducationLevel educationLevel,
      EmploymentLevel employmentLevel, Double earnings, Double basePay, Double bonuses,
      Double overtime, LocalDate lastPromotionDate, Integer numProjects, Integer numPatents,
      Integer numPublications, Integer numExternalProjects) {
    super(employeeID, contactInfo, employmentDate, educationLevel, employmentLevel, earnings,
        basePay, bonuses, overtime, lastPromotionDate, numProjects);
    this.numPatents = numPatents;
    this.numPublications = numPublications;
    this.numExternalProjects = numExternalProjects;
  }

  /**
   * Returns the individual contributor's estimated productivity
   * @return estimated productivity
   */
  @Override
  public Double estimateProductivity() {
    Double productivity = super.estimateProductivity();
    if (numPublications > PUBLICATIONS_THRESHOLD) {
      productivity += PUBLICATIONS_BONUS;
    }
    return productivity;
  }

  /**
   * Returns the number of patents
   * @return number of patents
   */
  public Integer getNumPatents() {
    return numPatents;
  }

  /**
   * Returns the number of publications
   * @return number of publications
   */
  public Integer getNumPublications() {
    return numPublications;
  }

  /**
   * Returns the number of external projects
   * @return number of external projects
   */
  public Integer getNumExternalProjects() {
    return numExternalProjects;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IndividualContributor that = (IndividualContributor) o;
    return Objects.equals(employeeID, that.employeeID) && Objects.equals(
        contactInfo, that.contactInfo) && Objects.equals(employmentDate,
        that.employmentDate) && educationLevel == that.educationLevel
        && employmentLevel == that.employmentLevel && Objects.equals(earnings,
        that.earnings) && Objects.equals(basePay, that.basePay) && Objects.equals(bonuses,
        that.bonuses) && Objects.equals(overtime, that.overtime)
        && Objects.equals(lastPromotionDate, that.lastPromotionDate)
        && Objects.equals(numProjects, that.numProjects) &&
        Objects.equals(numPatents, that.numPatents) && Objects.equals(
        numPublications, that.numPublications) && Objects.equals(numExternalProjects,
        that.numExternalProjects);
  }

  @Override
  public int hashCode() {
    return Objects.hash(employeeID, contactInfo, employmentDate, educationLevel, employmentLevel,
        earnings, basePay, bonuses, overtime, lastPromotionDate,
        numProjects, numPatents, numPublications, numExternalProjects);
  }
}
