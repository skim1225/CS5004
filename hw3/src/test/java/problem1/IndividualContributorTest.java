package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IndividualContributorTest {

  private IndividualContributor testIndividualContributor;
  private Double expectedProductivity;
  private Integer expectedNumPatents;
  private Integer expectedNumPublications;
  private Integer expectedNumExternalProjects;


  @BeforeEach
  void setUp() {
    testIndividualContributor = new IndividualContributor("a", new ContactInfo(new Name("a","a"),"a",
        "a","a",new Name("a","a")), LocalDate.of(1,1,1),
        EducationLevel.HIGH_SCHOOL_DIPLOMA, EmploymentLevel.ENTRY_LEVEL, 20000.0, 20.0, 0.0, 0.0,
        LocalDate.of(2,2,2), 0, 10, 10, 10);
    expectedNumPatents = 10;
    expectedNumPublications = 10;
    expectedNumExternalProjects = 10;
  }

  @Test
  void estimateProductivity_PublicationsBonus() {
    expectedProductivity = 1000.5;
    assertEquals(expectedProductivity, testIndividualContributor.estimateProductivity());
  }

  @Test
  void estimateProductivity_NoPublicationsBonus() {
    IndividualContributor otherIndividualContributor = new IndividualContributor("a", new ContactInfo(new Name("a","a"),"a",
        "a","a",new Name("a","a")), LocalDate.of(1,1,1),
        EducationLevel.HIGH_SCHOOL_DIPLOMA, EmploymentLevel.ENTRY_LEVEL, 20000.0, 20.0, 0.0, 0.0,
        LocalDate.of(2,2,2), 0, 10, 0, 10);
    expectedProductivity = 999.2;
    assertEquals(expectedProductivity, otherIndividualContributor.estimateProductivity());
  }

  @Test
  void getNumPatents() {
    assertEquals(expectedNumPatents, testIndividualContributor.getNumPatents());
  }

  @Test
  void getNumPublications() {
    assertEquals(expectedNumPublications, testIndividualContributor.getNumPublications());
  }

  @Test
  void getNumExternalProjects() {
    assertEquals(expectedNumExternalProjects, testIndividualContributor.getNumExternalProjects());
  }
}