package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseballPlayerTest {

  private BaseballPlayer testBaseballPlayer;
  private Name expectedName;
  private Double expectedHeight;
  private Double expectedWeight;
  private String expectedLeague;
  private String expectedTeam;
  private Double expectedAvgBattingScore;
  private Integer expectedSeasonHomeRuns;

  @BeforeEach
  void setUp() {
    Name athletesName = new Name("Jason", "Max", "Parker");
    testBaseballPlayer = new BaseballPlayer(athletesName, 6.2, 185.0, "MLB",
        "Mariners", 0.275, 32);
    expectedName = new Name("Jason", "Max", "Parker");
    expectedHeight = 6.2;
    expectedWeight = 185.0;
    expectedLeague = "MLB";
    expectedTeam = "Mariners";
    expectedAvgBattingScore = 0.275;
    expectedSeasonHomeRuns = 32;
  }

  @Test
  void getTeam() {
      assertEquals(expectedTeam, testBaseballPlayer.getTeam());
  }

  @Test
  void getAvgBattingScore() {
    assertEquals(expectedAvgBattingScore, testBaseballPlayer.getAvgBattingScore());
  }

  @Test
  void getSeasonHomeRuns() {
    assertEquals(expectedSeasonHomeRuns, testBaseballPlayer.getSeasonHomeRuns());
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(Objects.hash(Objects.hash(testBaseballPlayer.getAthletesName(),
            testBaseballPlayer.getHeight(), testBaseballPlayer.getWeight(), testBaseballPlayer.getLeague()),
            testBaseballPlayer.getTeam(), testBaseballPlayer.getAvgBattingScore(), testBaseballPlayer.getSeasonHomeRuns()));
    assertEquals(expectedHashCode, testBaseballPlayer.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "BaseballPlayer{" +
        "team='" + testBaseballPlayer.getTeam() + '\'' +
        ", avgBattingScore=" + testBaseballPlayer.getAvgBattingScore() +
        ", seasonHomeRuns=" + testBaseballPlayer.getSeasonHomeRuns() +
        ", athletesName=" + testBaseballPlayer.getAthletesName() +
        ", height=" + testBaseballPlayer.getHeight() +
        ", weight=" + testBaseballPlayer.getWeight() +
        ", league='" + testBaseballPlayer.getLeague() + '\'' +
        '}';
    assertEquals(expectedString, testBaseballPlayer.toString());
  }

  @Test
  void testEquals_DifferentObjectSameTeam() {
    Name otherName = new Name("A","B","C");
    BaseballPlayer otherPlayer = new BaseballPlayer(otherName, 1.0, 1.0, "ABC", "Mariners", 0.1, 100);
    assertFalse(testBaseballPlayer.equals(otherPlayer));
  }

  @Test
  void testEquals_DifferentObjectSameBattingAvg() {
    Name otherName = new Name("A", "B", "C");
    BaseballPlayer otherPlayer = new BaseballPlayer(otherName, 1.0, 1.0, "ABC", "Rays", 0.275, 100);
    assertFalse(testBaseballPlayer.equals(otherPlayer));
  }

  @Test
  void testEquals_DifferentObjectSameHomeRuns() {
    Name otherName = new Name("A","B","C");
    BaseballPlayer otherPlayer = new BaseballPlayer(otherName, 1.0, 1.0, "ABC", "Rays", 0.1, 32);
    assertFalse(testBaseballPlayer.equals(otherPlayer));
  }
}