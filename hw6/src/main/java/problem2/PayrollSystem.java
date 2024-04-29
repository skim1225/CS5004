package problem2;

/**
 * Interface PayrollSystemADT stores information about the features our payroll system supports.
 */
public interface PayrollSystem {

  /**
   * Returns whether the PayrollSystem is empty.
   * @return whether the PayrollSystem is empty.
   */
  boolean isEmpty();

  /**
   * Returns the number of Employees in the PayrollSystem.
   * @return the number of Employees in the PayrollSystem.
   */
  Integer countEmployees();

  /**
   * For new employees, adds a new Employee to the PayrollSystem. FOr existing employees, updates
   * their role. Returns the updated PayrollSystem.
   * @param employee - The Employee to be added or updated, as an Employee.
   * @return the PayrollSystem with the employee added or employee role updated.
   */
  PayrollSystem add(Employee employee);

  /**
   * Removes the given employee from the PayrollSystem and returns the updated PayrollSystem.
   * @param employee - The Employee to be removed, as an Employee.
   * @return the updated PayrollSystem after removing the Employee.
   * @throws EmployeeNotFoundException if the Employee does not exist in the PayrollSystem.
   */
  PayrollSystem remove(Employee employee) throws EmployeeNotFoundException;

  /**
   * Returns whether the given Employee exists in the PayrollSystem.
   * @param employee - The employee to check for, as an Employee.
   * @return whether the given Employee exists in the PayrollSystem.
   */
  boolean check(Employee employee);

  /**
   * Returns a PayrollSystem containing all Employees whose annual earnings were over 150,000.
   * @return a PayrollSystem containing all Employees whose annual earnings were over 150,000.
   */
  PayrollSystem getAllHighIncome();

  /**
   * Returns a PayrollSystem containing all Employees with the given role.
   * @param currentRole - The role to be queried, as a String.
   * @return a PayrollSystem containing all Employees with the given role.
   */
  PayrollSystem getByRole(String currentRole);

  /**
   * Returns a PayrollSystem containing all Employees who joined the company in the given year.
   * @param startYear - The year the Employee joined, as an Integer.
   * @return a PayrollSystem containing all Employees who joined the company in the given year.
   */
  PayrollSystem getByStartYear(Integer startYear);

  /**
   * Returns whether two PayrollSystems are equal. Two PayrollSystems are equal if they contain the
   * same employees, regardless of order.
   * @return whether two PayrollSystems are equal.
   */
  boolean equals(Object o);

}
