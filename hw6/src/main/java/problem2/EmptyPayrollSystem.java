package problem2;

public class EmptyPayrollSystem implements PayrollSystem {

  /**
   * Returns whether the PayrollSystem is empty.
   *
   * @return whether the PayrollSystem is empty.
   */
  @Override
  public boolean isEmpty() {
    return true;
  }

  /**
   * Returns the number of Employees in the PayrollSystem.
   *
   * @return the number of Employees in the PayrollSystem.
   */
  @Override
  public Integer countEmployees() {
    return 0;
  }

  /**
   * For new employees, adds a new Employee to the PayrollSystem. FOr existing employees, updates
   * their role. Returns the updated PayrollSystem.
   *
   * @param employee - The Employee to be added or updated, as an Employee.
   * @return the PayrollSystem with the employee added or employee role updated.
   */
  @Override
  public PayrollSystem add(Employee employee) {
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
    throw new EmployeeNotFoundException();
  }

  /**
   * Returns whether the given Employee exists in the PayrollSystem.
   *
   * @param employee - The employee to check for, as an Employee.
   * @return whether the given Employee exists in the PayrollSystem.
   */
  @Override
  public boolean check(Employee employee) {
    return false;
  }

  /**
   * Returns a PayrollSystem containing all Employees whose annual earnings were over 150,000.
   *
   * @return a PayrollSystem containing all Employees whose annual earnings were over 150,000.
   */
  @Override
  public PayrollSystem getAllHighIncome() {
    return this;
  }

  /**
   * Returns a PayrollSystem containing all Employees with the given role.
   *
   * @param currentRole - The role to be queried, as a String.
   * @return a PayrollSystem containing all Employees with the given role.
   */
  @Override
  public PayrollSystem getByRole(String currentRole) {
    return this;
  }

  /**
   * Returns a PayrollSystem containing all Employees who joined the company in the given year.
   *
   * @param startYear - The year the Employee joined, as an Integer.
   * @return a PayrollSystem containing all Employees who joined the company in the given year.
   */
  @Override
  public PayrollSystem getByStartYear(Integer startYear) {
    return this;
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
    return !(o == null || getClass() != o.getClass());
  }
}
