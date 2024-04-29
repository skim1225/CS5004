package problem2;

import java.time.LocalDate;
import java.util.Objects;

/*
 Class Employee contains information about an employee.
 */
public class Employee {

  private Name employee;
  private ContactInfo employeesContactInfo;
  private LocalDate employeesDOB;
  private String employeeID;
  private Integer yearJoinedCompany;
  private String currentRole;
  private Integer yearLastPromoted;
  private Double annualEarnings;

  public Employee(Name employee, ContactInfo employeesContactInfo, LocalDate employeesDOB,
                  String employeeID, Integer yearJoinedCompany, String currentRole,
                  Integer yearLastPromoted, Double annualEarnings) {
    this.employee = employee;
    this.employeesContactInfo = employeesContactInfo;
    this.employeesDOB = employeesDOB;
    this.employeeID = employeeID;
    this.yearJoinedCompany = yearJoinedCompany;
    this.currentRole = currentRole;
    this.yearLastPromoted = yearLastPromoted;
    this.annualEarnings = annualEarnings;
  }

  public Name getEmployee() {
    return employee;
  }

  public ContactInfo getEmployeesContactInfo() {
    return employeesContactInfo;
  }

  public LocalDate getEmployeesDOB() {
    return employeesDOB;
  }

  public String getEmployeeID() {
    return employeeID;
  }

  public Integer getYearJoinedCompany() {
    return yearJoinedCompany;
  }

  public String getCurrentRole() {
    return currentRole;
  }

  public Integer getYearLastPromoted() {
    return yearLastPromoted;
  }

  public Double getAnnualEarnings() {
    return annualEarnings;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Employee)) return false;
    Employee employee1 = (Employee) o;
    return Objects.equals(getEmployee(), employee1.getEmployee()) &&
        Objects.equals(getEmployeesContactInfo(), employee1.getEmployeesContactInfo()) &&
        Objects.equals(getEmployeesDOB(), employee1.getEmployeesDOB()) &&
        Objects.equals(getEmployeeID(), employee1.getEmployeeID()) &&
        Objects.equals(getYearJoinedCompany(), employee1.getYearJoinedCompany()) &&
        Objects.equals(getCurrentRole(), employee1.getCurrentRole()) &&
        Objects.equals(getYearLastPromoted(), employee1.getYearLastPromoted()) &&
        Objects.equals(getAnnualEarnings(), employee1.getAnnualEarnings());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getEmployee(), getEmployeesContactInfo(),
        getEmployeesDOB(), getEmployeeID(), getYearJoinedCompany(),
        getCurrentRole(), getYearLastPromoted(), getAnnualEarnings());
  }
}
