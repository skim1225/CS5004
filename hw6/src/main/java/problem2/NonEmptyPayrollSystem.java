package problem2;

public class NonEmptyPayrollSystem implements PayrollSystem {

  private Employee head;
  private PayrollSystem rest;
  private static final Integer HIGH_INCOME_MIN = 150000;

  public NonEmptyPayrollSystem(Employee head, PayrollSystem rest) {
    this.head = head;
    this.rest = rest;
  }

  /**
   * Returns the head.
   * @return the head.
   */
  public Employee getHead() {
    return head;
  }

  /**
   * Returns the rest of this collection.
   * @return the rest of this collection.
   */
  public PayrollSystem getRest() {
    return rest;
  }

  /**
   * Returns whether the PayrollSystem is empty.
   *
   * @return whether the PayrollSystem is empty.
   */
  @Override
  public boolean isEmpty() {
    return false;
  }

  /**
   * Returns the number of Employees in the PayrollSystem.
   *
   * @return the number of Employees in the PayrollSystem.
   */
  @Override
  public Integer countEmployees() {
    return 1 + this.rest.countEmployees();
  }

  /**
   * For new employees, adds a new Employee to the PayrollSystem. FOr existing employees, updates
   * their role. Returns the updated PayrollSystem.
   * @param employee - The Employee to be added or updated, as an Employee.
   * @return the PayrollSystem with the employee added or employee role updated.
   */
  @Override
  public PayrollSystem add(Employee employee) {
    if (check(employee)) {
      try {
        remove(employee);
      } catch (EmployeeNotFoundException e) {
        // this will never execute because we checked that the employee exists
      }
    }
    return new NonEmptyPayrollSystem(employee, this);
  }

  /**
   * Removes the given employee from the PayrollSystem and returns the updated PayrollSystem.
   *
   * @param employee - The Employee to be removed, as an Employee.
   * @return the updated PayrollSystem after removing the Employee.
   * @throws EmployeeNotFoundException if the Employee does not exist in the PayrollSystem.
   */
  @Override
  public PayrollSystem remove(Employee employee) throws EmployeeNotFoundException {
    if (this.head.equals(employee)) {
      return this.rest;
    } else {
      return new NonEmptyPayrollSystem(this.head, this.rest.remove(employee));
    }
  }

  /**
   * Returns whether the given Employee exists in the PayrollSystem based on the employee's ID.
   *
   * @param employee - The employee to check for, as an Employee.
   * @return whether the given Employee exists in the PayrollSystem.
   */
  @Override
  public boolean check(Employee employee) {
    if (this.head.getEmployeeID().equals(employee.getEmployeeID())) {
      return true;
    } else {
      return this.rest.check(employee);
    }
  }

  /**
   * Returns a PayrollSystem containing all Employees whose annual earnings were over 150,000.
   *
   * @return a PayrollSystem containing all Employees whose annual earnings were over 150,000.
   */
  @Override
  public PayrollSystem getAllHighIncome() {
    if (this.isHighIncome(this.head)) {
      return new NonEmptyPayrollSystem(this.head, this.rest.getAllHighIncome());
    } else
      return this.rest.getAllHighIncome();
  }

  /**
   * Returns whether an employee is high income (makes over $150,000).
   *
   * @param employee - The employee to be checked, as an Employee.
   * @return whether an employee is high income (makes over $150,000)
   */
  private Boolean isHighIncome(Employee employee) {
    return employee.getAnnualEarnings() >= HIGH_INCOME_MIN;
  }

  /**
   * Returns a PayrollSystem containing all Employees with the given role.
   *
   * @param currentRole - The role to be queried, as a String.
   * @return a PayrollSystem containing all Employees with the given role.
   */
  @Override
  public PayrollSystem getByRole(String currentRole) {
    if (this.head.getCurrentRole().equals(currentRole)) {
      return new NonEmptyPayrollSystem(this.head, this.rest.getByRole(currentRole));
    } else
      return this.rest.getByRole(currentRole);
  }

  /**
   * Returns a PayrollSystem containing all Employees who joined the company in the given year.
   *
   * @param startYear - The year the Employee joined, as an Integer.
   * @return a PayrollSystem containing all Employees who joined the company in the given year.
   */
  @Override
  public PayrollSystem getByStartYear(Integer startYear) {
    if (this.head.getYearJoinedCompany().equals(startYear)) {
      return new NonEmptyPayrollSystem(this.head, this.rest.getByStartYear(startYear));
    } else {
      return this.rest.getByStartYear(startYear);
    }
  }


  /**
   * Returns whether two PayrollSystems are equal. Two PayrollSystems are equal if they contain the
   * same employees, regardless of order.
   *
   * @return whether two PayrollSystems are equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    else {
      NonEmptyPayrollSystem other = (NonEmptyPayrollSystem) o;
      while (!other.getRest().getClass().equals("class problem2.EmptyPayrollSystem")) {
        if (!this.check(other.getHead())) {
          return false;
        } else {
          return equals(other.getRest());
        }
      }
    }
    return true;
  }
}
