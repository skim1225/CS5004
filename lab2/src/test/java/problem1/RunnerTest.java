package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RunnerTest {

  private Runner testRunner;
  private Name expectedName;
  private Double expectedHeight;
  private Double expectedWeight;

  private String expectedLeague;
  private Double expectedBest5kRunTime;
  private Double expectedBestHalfMarathonRunTime;
  private String expectedFavoriteRunningEvent;


  @BeforeEach
  void setUp() {
    Name athletesName = new Name("Jason", "Max", "Parker");
    testRunner = new Runner(athletesName, 5.5, 130.0, "RRCA", 16.0, 85.5, "Steeplechase");
    expectedName = new Name("Jason", "Max", "Parker");
    expectedHeight = 5.5;
    expectedWeight = 130.0;
    expectedLeague = "RRCA";
    expectedBest5kRunTime = 16.0;
    expectedBestHalfMarathonRunTime = 85.5;
    expectedFavoriteRunningEvent = "Steeplechase";
  }

  @Test
  void getBest5kRunTime() {
    assertEquals(expectedBest5kRunTime, testRunner.getBest5kRunTime());
  }

  @Test
  void getBestHalfMarathonRunTime() {
    assertEquals(expectedBestHalfMarathonRunTime, testRunner.getBestHalfMarathonRunTime());
  }

  @Test
  void getFavoriteRunningEvent() {
    assertEquals(expectedFavoriteRunningEvent, testRunner.getFavoriteRunningEvent());
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(Objects.hash(testRunner.getAthletesName(), testRunner.getHeight(), testRunner.getWeight(), testRunner.getLeague()),
        testRunner.getBest5kRunTime(), testRunner.getBestHalfMarathonRunTime(), testRunner.getFavoriteRunningEvent());
    assertEquals(expectedHashCode, testRunner.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "Runner{" +
        "best5kRunTime=" + testRunner.getBest5kRunTime() +
        ", bestHalfMarathonRunTime=" + testRunner.getBestHalfMarathonRunTime() +
        ", favoriteRunningEvent='" + testRunner.getFavoriteRunningEvent() + '\'' +
        ", athletesName=" + testRunner.getAthletesName() +
        ", height=" + testRunner.getHeight() +
        ", weight=" + testRunner.getWeight() +
        ", league='" + testRunner.getLeague() + '\'' +
        '}';
    assertEquals(expectedString, testRunner.toString());
  }
  @Test
  void testEquals_SameObjects() {
    assertTrue(testRunner.equals(testRunner));
  }

  @Test
  void testEquals_NullObjects() {
    assertFalse(testRunner.equals(null));
  }

  @Test
  void testEquals_DifferentDataType() {
    assertFalse(testRunner.equals("String"));
  }

  void testEquals_DifferentObjectSame5k() {
    Name otherName = new Name("Bobby", "Bob", "Jones");
    Runner otherRunner = new Runner(otherName, 5.8, 160.0, "ITRA", 16.0, 100.0, "1600");
    assertFalse(testRunner.equals(otherRunner));
  }

  @Test
  void testEquals_DifferentObjectsSameHalfMarathon() {
    Name otherName = new Name("Bobby", "Bob", "Jones");
    Runner otherRunner = new Runner(otherName, 5.8, 160.0, "ITRA", 17.0, 85.5, "1600");
    assertFalse(testRunner.equals(otherRunner));
  }

  @Test
  void testEquals_DifferentObjectsSameFavoriteEvent() {
    Name otherName = new Name("Bobby", "Bob", "Jones");
    Runner otherRunner = new Runner(otherName, 5.8, 160.0, "ITRA", 17.0, 90.0, "Steeplechase");
    assertFalse(testRunner.equals(otherRunner));
  }
}