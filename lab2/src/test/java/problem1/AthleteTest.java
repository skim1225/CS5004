package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem2.Position;

class AthleteTest {

  private Athlete testAthlete;
  private Name expectedName;
  private Double expectedHeight;
  private Double expectedWeight;
  private String expectedLeague;

  @BeforeEach
  void setUp() {
    Name athletesName = new Name("Jason", "Max", "Parker");
    testAthlete = new Athlete(athletesName, 6.2, 185.0, "NHL");
    expectedName = new Name("Jason", "Max", "Parker");
    expectedHeight = 6.2;
    expectedWeight = 185.0;
    expectedLeague = "NHL";
  }

  @Test
  void getAthletesName() {
    assertEquals(expectedName, testAthlete.getAthletesName());
  }

  @Test
  void getHeight() {
    assertEquals(expectedHeight, testAthlete.getHeight(), 0.01);
  }

  @Test
  void getWeight() {
    assertEquals(expectedWeight, testAthlete.getWeight(), 0.01);
  }

  @Test
  void getLeague() {
    assertEquals(expectedLeague, testAthlete.getLeague());
  }

  @Test
  void testToString() {
    String expectedString = "Athlete{" +
        "athletesName=" + testAthlete.getAthletesName() +
        ", height=" + testAthlete.getHeight() +
        ", weight=" + testAthlete.getWeight() +
        ", league='" + testAthlete.getLeague() + '\'' +
        '}';
    assertEquals(expectedString, testAthlete.toString());
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(testAthlete.getAthletesName(), testAthlete.getHeight(),
        testAthlete.getWeight(), testAthlete.getLeague());
    assertEquals(expectedHashCode, testAthlete.hashCode());
  }


  @Test
  void testEquals_SameObjects() {
    assertTrue(testAthlete.equals(testAthlete));
  }

  @Test
  void testEquals_NullObjects() {
    assertFalse(testAthlete.equals(null));
  }

  @Test
  void testEquals_DifferentDataType() {
    assertFalse(testAthlete.equals("String"));
  }

  @Test
  void testEquals_DifferentObjectSameName() {
    Name athletesName = new Name("Jason", "Max", "Parker");
    Athlete otherAthlete = new Athlete(athletesName, 5.2, 120.0, "NFL");
    assertFalse(testAthlete.equals(otherAthlete));
  }

  @Test
  void testEquals_DifferentObjectSameHeight() {
    Name otherName = new Name("Bobby", "Bob", "Bobbers");
    Athlete otherAthlete = new Athlete(otherName, 6.2, 300.0, "MLB");
    assertFalse(testAthlete.equals(otherAthlete));
  }

  @Test
  void testEquals_DifferentObjectSameWeight() {
    Name otherName = new Name("Bobby", "Bob", "Bobbers");
    Athlete otherAthlete = new Athlete(otherName, 5.7, 185.0, "MLB");
    assertFalse(testAthlete.equals(otherAthlete));
  }

  @Test
  void testEquals_DifferentObjectSameLeague() {
    Name otherName = new Name("Bobby", "Bob", "Bobbers");
    Athlete otherAthlete = new Athlete(otherName, 6.6, 300.0, "NHL");
    assertFalse(testAthlete.equals(otherAthlete));
  }

  @Test
  void testEquals_DifferentObjectsSameValues() {
    Name athletesName = new Name("Jason", "Max", "Parker");
    Athlete otherAthlete = new Athlete(athletesName, 6.2, 185.0, "NHL");
    assertTrue(testAthlete.equals(otherAthlete));
  }
}