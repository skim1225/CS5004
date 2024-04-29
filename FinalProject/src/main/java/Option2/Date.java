package Option2;

import java.util.Objects;

/**
 * Class Date holds information about a Date as its day, month, and year.
 */

public class Date {

  private Integer day;
  private Integer month;
  private Integer year;

  /**
   * Constructor for creating a new Date with the given day, month, and year.
   * @param day - The day of the Date, as an Integer.
   * @param month - The month of the Date, as an Integer.
   * @param year - The year of the Date, as an Integer.
   */
  public Date(Integer day, Integer month, Integer year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  /**
   * Returns the day of the Date, as an Integer.
   * @return the day of the Date, as an Integer.
   */
  public Integer getDay() {
    return day;
  }

  /**
   * Returns the month of the Date, as an Integer.
   * @return the month of the Date, as an Integer.
   */
  public Integer getMonth() {
    return month;
  }

  /**
   * Returns the year of the Date, as an Integer.
   * @return the year of the Date, as an Integer.
   */
  public Integer getYear() {
    return year;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Date date = (Date) o;
    return Objects.equals(day, date.day) && Objects.equals(month, date.month)
        && Objects.equals(year, date.year);
  }

  @Override
  public int hashCode() {
    return Objects.hash(day, month, year);
  }

  @Override
  public String toString() {
    return "Date{" +
        "day=" + day +
        ", month=" + month +
        ", year=" + year +
        '}';
  }
}
