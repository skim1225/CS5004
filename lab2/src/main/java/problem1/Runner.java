package problem1;

import java.util.Objects;
/*
 ** Class Runner inherits from class Athlete and stores information about a runner
 */

public class Runner extends Athlete {

  private Double best5kRunTime;
  private Double bestHalfMarathonRunTime;
  private String favoriteRunningEvent;

  /**
   * Constructor for the class Runner.
   * @param athletesName - String, representing runner's name
   * @param height - Double, representing runner's height
   * @param weight - Double, representing runner's weight
   * @param league - String, representing runner's league
   * @param best5kRunTime - Double, representing runner's best 5k run time
   * @param bestHalfMarathonRunTime - Double, representing runner's best half marathon run time
   * @param favoriteRunningEvent - String, representing runner's favorite running event
   */
  public Runner(Name athletesName, Double height, Double weight, String league,
      Double best5kRunTime,
      Double bestHalfMarathonRunTime, String favoriteRunningEvent) {
    super(athletesName, height, weight, league);

    this.best5kRunTime = best5kRunTime;
    this.bestHalfMarathonRunTime = bestHalfMarathonRunTime;
    this.favoriteRunningEvent = favoriteRunningEvent;
  }

  /**
   * Constructor for the class Runner.
   * @param athletesName - String, representing runner's name
   * @param height - Double, representing runner's height
   * @param weight - Double, representing runner's weight
   * @param best5kRunTime - Double, representing runner's best 5k run time
   * @param bestHalfMarathonRunTime - Double, representing runner's best half marathon run time
   * @param favoriteRunningEvent - String, representing runner's favorite running event
   */
  public Runner(Name athletesName, Double height, Double weight, Double best5kRunTime,
      Double bestHalfMarathonRunTime, String favoriteRunningEvent) {
    super(athletesName, height, weight);
    this.best5kRunTime = best5kRunTime;
    this.bestHalfMarathonRunTime = bestHalfMarathonRunTime;
    this.favoriteRunningEvent = favoriteRunningEvent;
  }

  /**
   * Getter for runners best 5k run time
   * @return best 5k run time as a Double
   */
  public Double getBest5kRunTime() {
    return best5kRunTime;
  }

  /**
   * Getter for runner's best half marathon time
   * @return best half marathon time as a Double
   */
  public Double getBestHalfMarathonRunTime() {
    return bestHalfMarathonRunTime;
  }

  /**
   * Getter for runner's favorite running event
   * @return Favorite running event as a String
   */
  public String getFavoriteRunningEvent() {
    return favoriteRunningEvent;
  }

  /**
   *
   * @param o - The Runner object to be compared
   * @return Boolean, giving whether the 2 Runners have the same field values
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Runner runner = (Runner) o;
    return Objects.equals(best5kRunTime, runner.best5kRunTime) && Objects.equals(
        bestHalfMarathonRunTime, runner.bestHalfMarathonRunTime) && Objects.equals(
        favoriteRunningEvent, runner.favoriteRunningEvent);
  }

  /**
   * @return int, giving the Runner's hashCode
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), best5kRunTime, bestHalfMarathonRunTime,
        favoriteRunningEvent);
  }

  /**
   *
   * @return String, giving the runner's fields in a readable format
   */
  @Override
  public String toString() {
    return "Runner{" +
        "best5kRunTime=" + best5kRunTime +
        ", bestHalfMarathonRunTime=" + bestHalfMarathonRunTime +
        ", favoriteRunningEvent='" + favoriteRunningEvent + '\'' +
        ", athletesName=" + athletesName +
        ", height=" + height +
        ", weight=" + weight +
        ", league='" + league + '\'' +
        '}';
  }

}
