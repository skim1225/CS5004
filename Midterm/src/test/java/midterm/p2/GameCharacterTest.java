package midterm.p2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameCharacterTest {

  private GameCharacter testGC;
  private Double expectedWealthLevel;

  @BeforeEach
  void setUp() throws CombatPowerException, HealthLevelException {
    Name name = new Name("A","A","A");
    testGC = new GameCharacter(name,1,10.0,10.0);
    expectedWealthLevel = 10.0;
  }

  @Test
  void increaseWealthLevel() throws WealthLevelException {
    testGC.increaseWealthLevel(10.0);
    assertEquals(expectedWealthLevel, testGC.getWealthLevel());
  }

  @Test
  void increaseWealthLevel_InvalidAmount() throws WealthLevelException {
    Assertions.assertThrows(WealthLevelException.class, () -> {
      testGC.increaseWealthLevel(200.0);
    });
  }
}