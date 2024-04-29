a. input validation:
```
if(this.validateAvgBattingScore(avgBattingScore)) {
      this.team = team;
      this.avgBattingScore = avgBattingScore;
      this.seasonHomeRuns = seasonHomeRuns;
}
```

b. inheritance:

```
public class BaseballPlayer extends Athlete{
```

c. method overriding:
There are no examples of method overriding (when a child class provides a difference implementation
of a parent class's method) in this code.

d. casting:
There are no examples of casting (turning the runtime type of an object to a different class) in this code.

e. method overloading:
```
  /**
   * Constructor for BaseballPlayer.
   * @param athletesName baseball player's name, as Name
   * @param height baseball player's height, as Double
   * @param weight baseball player's weight, as Double
   * @param league baseball player's league, as String
   * @param team baseball player's team, as String
   * @param avgBattingScore average batting score, as Double
   * @param seasonHomeRuns season home runs, as Integer
   */
  public BaseballPlayer(Name athletesName, Double height, Double weight, String league, String team,
      Double avgBattingScore, Integer seasonHomeRuns) throws InvalidBattingScoreException {
    super(athletesName, height, weight, league);
    if(this.validateAvgBattingScore(avgBattingScore)) {
      this.team = team;
      this.avgBattingScore = avgBattingScore;
      this.seasonHomeRuns = seasonHomeRuns;
    }
  }

  /**
   * Another constructor for BaseballPlayer.
   * @param athletesName baseball player's name, as Name
   * @param height baseball player's height, as Double
   * @param weight baseball player's weight, as Double
   * @param team baseball player's team, as String
   * @param avgBattingScore average batting score, as Double
   * @param seasonHomeRuns season home runs, as Integer
   */
  public BaseballPlayer(Name athletesName, Double height, Double weight, String team,
      Double avgBattingScore, Integer seasonHomeRuns) throws InvalidBattingScoreException {
    super(athletesName, height, weight);
    if(this.validateAvgBattingScore(avgBattingScore)) {
      this.team = team;
      this.avgBattingScore = avgBattingScore;
      this.seasonHomeRuns = seasonHomeRuns;
    }
  }
```