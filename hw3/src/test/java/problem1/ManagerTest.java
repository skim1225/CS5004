package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagerTest {

  private Manager testManager;
  private String expectedEmployeeID;
  private ContactInfo expectedContactInfo;
  private LocalDate expectedEmploymentDate;
  private EducationLevel expectedEducationLevel;
  private EmploymentLevel expectedEmploymentLevel;
  private Double expectedEarnings;
  private Double expectedBasePay;
  private Double expectedBonuses;
  private Double expectedOvertime;
  private LocalDate expectedLastPromotionDate;
  private Integer expectedNumProjects;
  private Integer expectedNumEmployeesManaged;

  @BeforeEach
  void setUp() {
    testManager = new Manager("12345", new ContactInfo(new Name("Sooji", "Kim"), "address",
        "phone", "email", new Name("Emergency", "Contact")),
        LocalDate.of(2010, 12, 15), EducationLevel.BACHELORS_DEGREE,
        EmploymentLevel.MID_LEVEL, 20000.0, 20.0, 100.0, 20.0,
        LocalDate.of(2024, 1, 2), 10, 4);
    expectedEmployeeID = "12345";
    expectedContactInfo = new ContactInfo(new Name("Sooji", "Kim"), "address",
        "phone", "email", new Name("Emergency", "Contact"));
    expectedEmploymentDate = LocalDate.of(2010, 12, 15);
    expectedEducationLevel = EducationLevel.BACHELORS_DEGREE;
    expectedEmploymentLevel = EmploymentLevel.MID_LEVEL;
    expectedEarnings = 20000.0;
    expectedBasePay = 20.0;
    expectedBonuses = 100.0;
    expectedOvertime = 20.0;
    expectedLastPromotionDate = LocalDate.of(2024, 1, 2);
    expectedNumProjects = 10;
    expectedNumEmployeesManaged = 4;
  }

  @Test
  void getEmployeeID() {
    assertEquals(expectedEmployeeID, testManager.getEmployeeID());
  }

  @Test
  void getContactInfo() {
    assertEquals(expectedContactInfo, testManager.getContactInfo());
  }

  @Test
  void getEmploymentDate() {
    assertEquals(expectedEmploymentDate, testManager.getEmploymentDate());
  }

  @Test
  void getEducationLevel() {
    assertEquals(expectedEducationLevel, testManager.getEducationLevel());
  }

  @Test
  void getEmploymentLevel() {
    assertEquals(expectedEmploymentLevel, testManager.getEmploymentLevel());
  }

  @Test
  void getEarnings() {
    assertEquals(expectedEarnings, testManager.getEarnings());
  }

  @Test
  void getBasePay() {
    assertEquals(expectedBasePay, testManager.getBasePay());
  }

  @Test
  void getBonuses() {
    assertEquals(expectedBonuses, testManager.getBonuses());
  }

  @Test
  void getOvertime() {
    assertEquals(expectedOvertime, testManager.getOvertime());
  }

  @Test
  void getLastPromotionDate() {
    assertEquals(expectedLastPromotionDate, testManager.getLastPromotionDate());
  }

  @Test
  void getNumProjects() {
    assertEquals(expectedNumProjects, testManager.getNumProjects());
  }

  @Test
  void getNumEmployeesManaged() {
    assertEquals(expectedNumEmployeesManaged, testManager.getNumEmployeesManaged());
  }

  @Test
  void timeDifferenceExceedsThreshold() {
    assertFalse(testManager.timeDifferenceExceedsThreshold(testManager.getLastPromotionDate(), LocalDate.now()));
  }

  @Test
  void estimateProductivity_NoBonuses() {
    Manager otherManager = new Manager("12345", new ContactInfo(new Name("Sooji", "Kim"), "address",
        "phone", "email", new Name("Emergency", "Contact")),
        LocalDate.of(2010, 12, 15), EducationLevel.BACHELORS_DEGREE,
        EmploymentLevel.MID_LEVEL, 20000.0, 20.0, 100.0, 20.0,
        LocalDate.of(2024, 1, 2), 0, 4);
    Double expectedProductivity = 1000.0;
    assertEquals(expectedProductivity, otherManager.estimateProductivity());
  }


  @Test
  void estimateProductivity_ProjectsBonus() {
    Double expectedProductivity = 1001.5;
    assertEquals(expectedProductivity, testManager.estimateProductivity());
  }


  @Test
  void estimateProductivity_EmployeesManagedBonus() {
    Manager otherManager = new Manager("12345", new ContactInfo(new Name("Sooji", "Kim"), "address",
        "phone", "email", new Name("Emergency", "Contact")),
        LocalDate.of(2010, 12, 15), EducationLevel.BACHELORS_DEGREE,
        EmploymentLevel.MID_LEVEL, 20000.0, 20.0, 100.0, 20.0,
        LocalDate.of(2024, 1, 2), 0, 10);
    Double expectedProductivity = 1001.8;
    assertEquals(expectedProductivity, otherManager.estimateProductivity());
  }

  @Test
  void estimateProductivity_PromotionPenalty() {
    Manager otherManager = new Manager("12345", new ContactInfo(new Name("Sooji", "Kim"), "address",
        "phone", "email", new Name("Emergency", "Contact")),
        LocalDate.of(2010, 12, 15), EducationLevel.BACHELORS_DEGREE,
        EmploymentLevel.MID_LEVEL, 20000.0, 20.0, 100.0, 20.0,
        LocalDate.of(2011, 1, 2), 0, 4);
    Double expectedProductivity = 999.2;
    assertEquals(expectedProductivity, otherManager.estimateProductivity());
  }

  @Test
  void estimateProductivity_EmploymentLevelBonus() {
    Manager otherManager = new Manager("12345", new ContactInfo(new Name("Sooji", "Kim"), "address",
        "phone", "email", new Name("Emergency", "Contact")),
        LocalDate.of(2010, 12, 15), EducationLevel.BACHELORS_DEGREE,
        EmploymentLevel.INTERMEDIATE_LEVEL, 20000.0, 20.0, 100.0, 20.0,
        LocalDate.of(2024, 1, 2), 0, 4);
    Double expectedProductivity = 1001.4;
    assertEquals(expectedProductivity, otherManager.estimateProductivity());
  }

  @Test
  void estimateProductivity_NoEmploymentLevelBonus() {

  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testManager.equals(testManager));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testManager.equals(null));
  }

  @Test
  void testEquals_DifferentDataType() {
    assertFalse(testManager.equals("string"));
  }

  @Test
  void testEquals_DifferentObjectsSameEmployeeID() {
    Manager otherManager = new Manager("12345", new ContactInfo(new Name("a","a"),"a",
        "a","a",new Name("a","a")), LocalDate.of(1,1,1),
        EducationLevel.HIGH_SCHOOL_DIPLOMA, EmploymentLevel.ENTRY_LEVEL, 0.0, 0.0, 0.0, 0.0,
        LocalDate.of(2,2,2), 0, 0);
    assertNotEquals(otherManager, testManager);
  }

  @Test
  void testEquals_DifferentObjectsSameContactInfo() {
    Manager otherManager = new Manager("a", new ContactInfo(new Name("Sooji", "Kim"), "address",
        "phone", "email", new Name("Emergency", "Contact")), LocalDate.of(1,1,1),
        EducationLevel.HIGH_SCHOOL_DIPLOMA, EmploymentLevel.ENTRY_LEVEL, 0.0, 0.0, 0.0, 0.0,
        LocalDate.of(2,2,2), 0, 0);
    assertNotEquals(otherManager, testManager);
  }

  @Test
  void testEquals_DifferentObjectsSameEmploymentDate() {
    Manager otherManager = new Manager("a", new ContactInfo(new Name("a","a"),"a",
        "a","a",new Name("a","a")), LocalDate.of(2010, 12, 15),
        EducationLevel.HIGH_SCHOOL_DIPLOMA, EmploymentLevel.ENTRY_LEVEL, 0.0, 0.0, 0.0, 0.0,
        LocalDate.of(2,2,2), 0, 0);
    assertNotEquals(otherManager, testManager);
  }

  @Test
  void testEquals_DifferentObjectsSameEducationLevel() {
    Manager otherManager = new Manager("a", new ContactInfo(new Name("a","a"),"a",
        "a","a",new Name("a","a")), LocalDate.of(1,1,1),
        EducationLevel.BACHELORS_DEGREE, EmploymentLevel.ENTRY_LEVEL, 0.0, 0.0, 0.0, 0.0,
        LocalDate.of(2,2,2), 0, 0);
    assertNotEquals(otherManager, testManager);
  }

  @Test
  void testEquals_DifferentObjectsSameEmploymentLevel() {
    Manager otherManager = new Manager("a", new ContactInfo(new Name("a","a"),"a",
        "a","a",new Name("a","a")), LocalDate.of(1,1,1),
        EducationLevel.HIGH_SCHOOL_DIPLOMA, EmploymentLevel.MID_LEVEL, 0.0, 0.0, 0.0, 0.0,
        LocalDate.of(2,2,2), 0, 0);
    assertNotEquals(otherManager, testManager);
  }

  @Test
  void testEquals_DifferentObjectsSameEarnings() {
    Manager otherManager = new Manager("a", new ContactInfo(new Name("a","a"),"a",
        "a","a",new Name("a","a")), LocalDate.of(1,1,1),
        EducationLevel.HIGH_SCHOOL_DIPLOMA, EmploymentLevel.ENTRY_LEVEL, 20000.0, 0.0, 0.0, 0.0,
        LocalDate.of(2,2,2), 0, 0);
    assertNotEquals(otherManager, testManager);
  }

  @Test
  void testEquals_DifferentObjectsSameBasePay() {
    Manager otherManager = new Manager("a", new ContactInfo(new Name("a","a"),"a",
        "a","a",new Name("a","a")), LocalDate.of(1,1,1),
        EducationLevel.HIGH_SCHOOL_DIPLOMA, EmploymentLevel.ENTRY_LEVEL, 0.0, 20.0, 0.0, 0.0,
        LocalDate.of(2,2,2), 0, 0);
    assertNotEquals(otherManager, testManager);
  }

  @Test
  void testEquals_DifferentObjectsSameBonuses() {
    Manager otherManager = new Manager("a", new ContactInfo(new Name("a","a"),"a",
        "a","a",new Name("a","a")), LocalDate.of(1,1,1),
        EducationLevel.HIGH_SCHOOL_DIPLOMA, EmploymentLevel.ENTRY_LEVEL, 0.0, 0.0, 100.0, 0.0,
        LocalDate.of(2,2,2), 0, 0);
    assertNotEquals(otherManager, testManager);
  }

  @Test
  void testEquals_DifferentObjectsSameOvertime() {
    Manager otherManager = new Manager("a", new ContactInfo(new Name("a","a"),"a",
        "a","a",new Name("a","a")), LocalDate.of(1,1,1),
        EducationLevel.HIGH_SCHOOL_DIPLOMA, EmploymentLevel.ENTRY_LEVEL, 0.0, 0.0, 0.0, 20.0,
        LocalDate.of(2,2,2), 0, 0);
    assertNotEquals(otherManager, testManager);
  }

  @Test
  void testEquals_DifferentObjectsSameLastPromotionDate() {
    Manager otherManager = new Manager("a", new ContactInfo(new Name("a","a"),"a",
        "a","a",new Name("a","a")), LocalDate.of(1,1,1),
        EducationLevel.HIGH_SCHOOL_DIPLOMA, EmploymentLevel.ENTRY_LEVEL, 0.0, 0.0, 0.0, 0.0,
        LocalDate.of(2015,5,2), 0, 0);
    assertNotEquals(otherManager, testManager);
  }

  @Test
  void testEquals_DifferentObjectsSameNumProjects() {
    Manager otherManager = new Manager("a", new ContactInfo(new Name("a","a"),"a",
        "a","a",new Name("a","a")), LocalDate.of(1,1,1),
        EducationLevel.HIGH_SCHOOL_DIPLOMA, EmploymentLevel.ENTRY_LEVEL, 0.0, 0.0, 0.0, 0.0,
        LocalDate.of(2,2,2), 10, 0);
    assertNotEquals(otherManager, testManager);
  }

  @Test
  void testEquals_DifferentObjectsSameNumEmployeesManaged() {
    Manager otherManager = new Manager("a", new ContactInfo(new Name("a","a"),"a",
        "a","a",new Name("a","a")), LocalDate.of(1,1,1),
        EducationLevel.HIGH_SCHOOL_DIPLOMA, EmploymentLevel.ENTRY_LEVEL, 0.0, 0.0, 0.0, 0.0,
        LocalDate.of(2,2,2), 0, 4);
    assertNotEquals(otherManager, testManager);
  }

  @Test
  void testEquals_DifferentObjectsSameFields() {
    Manager otherManager = new Manager("12345", new ContactInfo(new Name("Sooji", "Kim"), "address",
        "phone", "email", new Name("Emergency", "Contact")),
        LocalDate.of(2010, 12, 15), EducationLevel.BACHELORS_DEGREE,
        EmploymentLevel.MID_LEVEL, 20000.0, 20.0, 100.0, 20.0,
        LocalDate.of(2024, 1, 2), 10, 4);
    assertEquals(otherManager, testManager);
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(testManager.getEmployeeID(), testManager.getContactInfo(),
        testManager.getEmploymentDate(), testManager.getEducationLevel(), testManager.getEmploymentLevel(),
        testManager.getEarnings(), testManager.getBasePay(), testManager.getBonuses(), testManager.getOvertime(),
        testManager.getLastPromotionDate(), testManager.getNumProjects(), testManager.getNumEmployeesManaged());
    assertEquals(expectedHashCode, testManager.hashCode());
  }
}