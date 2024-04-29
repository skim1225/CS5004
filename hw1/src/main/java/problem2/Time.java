package problem2;

import java.util.Objects;

/**
 * Class Time stores information about a Time object
 */
public class Time {

  private final Integer SECS_IN_MIN = 60;
  private final Integer SECS_IN_HOUR = 3600;
  private Integer hours;
  private Integer mins;
  private Integer secs;

  /**
   * Constructor for the class Time
   * @param hours - Integer, representing the hour value of the time
   * @param mins - Integer, representing the minutes value of the time
   * @param secs - Integer, representing the seconds value of the time
   */
  public Time(Integer hours, Integer mins, Integer secs) {
    if (hours < 0 || hours > 23  || mins < 0 || mins > 59 || secs < 0 || secs > 59) {
      System.out.println("Invalid argument");
    } else {
      this.hours = hours;
      this.mins = mins;
      this.secs = secs;
    }
  }

  /**
   * @return Integer, giving hours of the time
   */
  public Integer getHours() {
    return hours;
  }

  /**
   * @return Integer, giving minutes of the time
   */
  public Integer getMins() {
    return mins;
  }

  /**
   * @return Integer, giving seconds of the time
   */
  public Integer getSecs() {
    return secs;
  }

  /**
   * Helper method to convert a time object into an integer representing the time converted to seconds
   * @return int, giving the time in seconds.
   */
  public int timeToSecs() {
    int totalSecs = this.secs;
    totalSecs += this.mins * SECS_IN_MIN;
    totalSecs += this.hours * SECS_IN_HOUR;
    return totalSecs;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Time time = (Time) o;
    return Objects.equals(hours, time.hours) && Objects.equals(mins, time.mins)
        && Objects.equals(secs, time.secs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hours, mins, secs);
  }
}
