package problem1;

import java.util.Objects;

/**
 * Class BaseballPlayer inherits from class Athlete and stores information about a baseball player
 */

public class BaseballPlayer extends Athlete{

  private String team;
  private Double avgBattingScore;
  private Integer seasonHomeRuns;

  /**
   * Constructor for class Baseball Player
   * @param athletesName - String, representing athlete's name
   * @param height - Double, representing athlete's height
   * @param weight - Double, representing athlete's weight
   * @param league - String, representing athlete's league
   * @param team - String, representing athlete's team
   * @param avgBattingScore - Double, representing athlete's batting average
   * @param seasonHomeRuns - Integer, representing athlete's season home runs
   */
  public BaseballPlayer(Name athletesName, Double height, Double weight, String league, String team,
      Double avgBattingScore, Integer seasonHomeRuns) {
    super(athletesName, height, weight, league);
    this.team = team;
    this.avgBattingScore = avgBattingScore;
    this.seasonHomeRuns = seasonHomeRuns;
  }

  /**
   * Constructor for class Baseball Player
   * @param athletesName - String, representing athlete's name
   * @param height - Double, representing athlete's height
   * @param weight - Double, representing athlete's weight
   * @param team - String, representing athlete's team
   * @param avgBattingScore - Double, representing athlete's batting average
   * @param seasonHomeRuns - Integer, representing athlete's season home runs
   */
  public BaseballPlayer(Name athletesName, Double height, Double weight, String team,
      Double avgBattingScore, Integer seasonHomeRuns) {
    super(athletesName, height, weight);
    this.team = team;
    this.avgBattingScore = avgBattingScore;
    this.seasonHomeRuns = seasonHomeRuns;
  }

  /**
   * @return - String, giving athlete's team
   */
  public String getTeam() {
    return team;
  }

  /**
   * @return - Double, giving athlete's batting average
   */
  public Double getAvgBattingScore() {
    return avgBattingScore;
  }

  /**
   * @return - Integer, giving athlete's season home runs
   */
  public Integer getSeasonHomeRuns() {
    return seasonHomeRuns;
  }

  /**
   *
   * @param o - The BaseballPlayer object to be compared
   * @return Boolean, giving whether the 2 BaseballPlayers have the same field values
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
    BaseballPlayer that = (BaseballPlayer) o;
    return Objects.equals(team, that.team) && Objects.equals(avgBattingScore,
        that.avgBattingScore) && Objects.equals(seasonHomeRuns, that.seasonHomeRuns);
  }

  /**
   * @return int, giving the BaseballPlayer's hashCode
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), team, avgBattingScore, seasonHomeRuns);
  }

  /**
   *
   * @return String, giving the BaseballPlayer's fields in a readable format
   */
  @Override
  public String toString() {
    return "BaseballPlayer{" +
        "team='" + team + '\'' +
        ", avgBattingScore=" + avgBattingScore +
        ", seasonHomeRuns=" + seasonHomeRuns +
        ", athletesName=" + athletesName +
        ", height=" + height +
        ", weight=" + weight +
        ", league='" + league + '\'' +
        '}';
  }
}
