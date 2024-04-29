package Problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TermNodeTest {

  private TermNode testNode;
  private Integer expectedPower;
  private Integer expectedCoefficient;
  private TermNode expectedNextNode;

  @BeforeEach
  void setUp() {
    testNode = new TermNode(1,1);
    expectedPower = 1;
    expectedCoefficient = 1;
    expectedNextNode = null;
  }

  @Test
  void getCoefficient() {
    assertEquals(expectedCoefficient, testNode.getCoefficient());
  }

  @Test
  void getPower() {
    assertEquals(expectedPower, testNode.getPower());
  }

  @Test
  void getNextNode() {
    assertEquals(expectedNextNode, testNode.getNextNode());
  }

  @Test
  void setCoefficient() {
    testNode.setCoefficient(2);
    assertEquals(testNode.getCoefficient(), 2);
  }

  @Test
  void setNextNode() {
    testNode.setNextNode(new TermNode(2,2));
    expectedNextNode = new TermNode(2,2);
    assertEquals(expectedNextNode, testNode.getNextNode());
  }
}