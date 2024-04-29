package problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmptyPayrollSystemTest {

  private EmptyPayrollSystem testEmptyPS;

  @BeforeEach
  void setUp() {
    testEmptyPS = new EmptyPayrollSystem();
  }

  @Test
  void isEmpty() {
    assertTrue(testEmptyPS.isEmpty());
  }

  @Test
  void countEmployees() {
    assertEquals(0, testEmptyPS.countEmployees());
  }

  @Test
  void add() {
    Name testName = new Name("a","a","a");
    ContactInfo testContactInfo = new ContactInfo("a","a","a","a","a","a");
    Employee testEmployee = new Employee(testName, testContactInfo, LocalDate.of(2000,1,1), "a", 2020, "a", 2021, 100.0);
    PayrollSystem nonEmpty = new NonEmptyPayrollSystem(new Employee(new Name("a","a","a"),
        new ContactInfo("a","a","a","a","a","a"),
        LocalDate.of(2000,1,1), "a", 2020, "a", 2021, 100.0), new EmptyPayrollSystem());
    assertEquals(nonEmpty, testEmptyPS.add(testEmployee));
  }

  @Test
  void remove() {Name testName = new Name("a","a","a");
    ContactInfo testContactInfo = new ContactInfo("a","a","a","a","a","a");
    Employee testEmployee = new Employee(testName, testContactInfo, LocalDate.of(2000,1,1), "a", 2020, "a", 2021, 100.0);
    Assertions.assertThrows(EmployeeNotFoundException.class, () -> {
      testEmptyPS.remove(testEmployee);
    });
  }

  @Test
  void check() {
    Name testName = new Name("a","a","a");
    ContactInfo testContactInfo = new ContactInfo("a","a","a","a","a","a");
    Employee testEmployee = new Employee(testName, testContactInfo, LocalDate.of(2000,1,1), "a", 2020, "a", 2021, 100.0);
    assertFalse(testEmptyPS.check(testEmployee));
  }

  @Test
  void getAllHighIncome() {
    assertEquals(testEmptyPS, testEmptyPS.getAllHighIncome());
  }

  @Test
  void getByRole() {
    assertEquals(testEmptyPS, testEmptyPS.getByRole("swe"));
  }

  @Test
  void getByStartYear() {
    assertEquals(testEmptyPS, testEmptyPS.getByStartYear(2024));
  }
}