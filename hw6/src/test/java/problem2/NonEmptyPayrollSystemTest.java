package problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem1.EmptyPriorityQueueException;

class NonEmptyPayrollSystemTest {

  private NonEmptyPayrollSystem testNonEmptyPS;
  private Employee expectedHead;
  private EmptyPayrollSystem expectedRest;
  Name name1 = new Name("A","A","A");
  Name name2 = new Name("B","B","B");
  Name name3 = new Name("C","C","C");
  ContactInfo contactInfo1 = new ContactInfo("A","A","A","A","A","A");
  ContactInfo contactInfo2 = new ContactInfo("B","B","B","B","B","B");
  ContactInfo contactInfo3 = new ContactInfo("C","C","C","C","C","C");
  Employee employee1 = new Employee(name1, contactInfo1, LocalDate.of(2000,1,1), "A", 2020, "Manager", 2021, 200000.0);
  Employee employee2 = new Employee(name2, contactInfo2, LocalDate.now(), "B", 2023, "Manager", 2024, 100000.0);
  Employee employee3 = new Employee(name3, contactInfo3, LocalDate.now(), "C", 2023, "Engineer", 2024, 250000.0);

  @BeforeEach
  void setUp() {
    testNonEmptyPS = new NonEmptyPayrollSystem(employee1, new EmptyPayrollSystem());
    expectedHead = new Employee(new Name("A","A","A"), new ContactInfo("A","A","A","A","A","A"), LocalDate.of(2000,1,1), "A", 2020, "Manager", 2021, 200000.0);
    expectedRest = new EmptyPayrollSystem();
  }

  @Test
  void getHead() {
    assertEquals(expectedHead, testNonEmptyPS.getHead());
  }

  @Test
  void getRest() {
    assertEquals(expectedRest, testNonEmptyPS.getRest());
  }

  @Test
  void isEmpty() {
    assertFalse(testNonEmptyPS.isEmpty());
  }

  @Test
  void countEmployees() {
    assertEquals(1, testNonEmptyPS.countEmployees());
  }

  @Test
  void add() {
    testNonEmptyPS.add(employee2);
    NonEmptyPayrollSystem other = new NonEmptyPayrollSystem(employee1, new NonEmptyPayrollSystem(employee2, new EmptyPayrollSystem()));
    assertEquals(testNonEmptyPS, other);
  }

  @Test
  void remove_fail() throws EmployeeNotFoundException {
    Assertions.assertThrows(EmployeeNotFoundException.class, () -> {
      testNonEmptyPS.remove(employee3);
    });
  }

  @Test
  void remove() throws EmployeeNotFoundException {
    NonEmptyPayrollSystem other = new NonEmptyPayrollSystem(employee1, new EmptyPayrollSystem());
    testNonEmptyPS.add(employee2);
    testNonEmptyPS.remove(employee2);
    assertEquals(testNonEmptyPS, other);
  }

  @Test
  void check() {
    assertTrue(testNonEmptyPS.check(employee1));
  }

  @Test
  void getAllHighIncome() {
    testNonEmptyPS.add(employee2);
    testNonEmptyPS.add(employee3);
    NonEmptyPayrollSystem expectedHighIncome = new NonEmptyPayrollSystem(employee1, new EmptyPayrollSystem());
    expectedHighIncome.add(employee3);
    assertEquals(expectedHighIncome, testNonEmptyPS.getAllHighIncome());
  }

  @Test
  void getByRole() {
    testNonEmptyPS.add(employee2);
    testNonEmptyPS.add(employee3);
    NonEmptyPayrollSystem expectedHighIncome = new NonEmptyPayrollSystem(employee1, new EmptyPayrollSystem());
    expectedHighIncome.add(employee2);
    assertEquals(expectedHighIncome, testNonEmptyPS.getByRole("Manager"));
  }

  @Test
  void getByStartYear() {
    testNonEmptyPS.add(employee2);
    testNonEmptyPS.add(employee3);
    NonEmptyPayrollSystem expectedHighIncome = new NonEmptyPayrollSystem(employee2, new EmptyPayrollSystem());
    expectedHighIncome.add(employee3);
    assertEquals(expectedHighIncome, testNonEmptyPS.getByStartYear(2023));
  }
}