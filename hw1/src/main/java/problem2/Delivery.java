package problem2;

import java.util.Objects;

/**
 * Class Delivery stores information about a Delivery
 */
public class Delivery {

  private final Integer SECS_IN_MIN = 60;
  private final Integer SECS_IN_HOUR = 3600;
  private String startLocation;
  private String endLocation;
  private Time startTime;
  private Time endTime;

  /**
   * Constructor for class Delivery
   * @param startLocation - String, representing the start location of the delivery
   * @param endLocation - String, representing the end location of the delivery
   * @param startTime - Time, representing the time the delivery started
   * @param endTime - Time, representing the time the delivery ended
   */
  public Delivery(String startLocation, String endLocation, Time startTime, Time endTime) {
    this.startLocation = startLocation;
    this.endLocation = endLocation;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  /**
   * @return String, giving the start location
   */
  public String getStartLocation() {
    return startLocation;
  }

  /**
   * @return String, giving the end location
   */
  public String getEndLocation() {
    return endLocation;
  }

  /**
   * @return Time, giving the start time
   */
  public Time getStartTime() {
    return startTime;
  }

  /**
   * @return Time, giving the end time
   */
  public Time getEndTime() {
    return endTime;
  }

  /**
   * @return Time, giving a time object representing the difference between the start and end times
   */
  public Time getDuration() {
    int totalStartTimeSecs = this.startTime.timeToSecs();
    int totalEndTimeSecs = this.endTime.timeToSecs();
    int secsDifference = totalEndTimeSecs - totalStartTimeSecs;
    int hours = secsDifference / SECS_IN_HOUR;
    secsDifference %= SECS_IN_HOUR;
    int mins = secsDifference / SECS_IN_MIN;
    int secs = secsDifference % SECS_IN_MIN;
    return new Time(hours, mins, secs);
  }

  /**
   * Method for comparing 2 Delivery objects
   * @param o - object to be compared
   * @return Boolean, representing whether the objects have the same field values
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Delivery delivery = (Delivery) o;
    return Objects.equals(startLocation, delivery.startLocation)
        && Objects.equals(endLocation, delivery.endLocation) && Objects.equals(
        startTime, delivery.startTime) && Objects.equals(endTime, delivery.endTime);
  }

  /**
   * Method for getting hashcode of Delivery object
   * @return int - hashcode of the object
   */
  @Override
  public int hashCode() {
    return Objects.hash(startLocation, endLocation, startTime, endTime);
  }
}
