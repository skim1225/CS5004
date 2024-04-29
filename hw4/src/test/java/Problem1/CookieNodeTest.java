package Problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CookieNodeTest {

  private CookieNode testCookieNode;
  private Cookie expectedCookie;
  private CookieNode expectedNextCookieNode;

  @BeforeEach
  void setUp() {
    testCookieNode = new CookieNode(new Cookie("Chocolate Chip", new String[] {"flour", "butter", "sugar", "chocolate chips"}, 1.0,
        200.0, 30.0, 20.0, 1.0,
        10.0, false, true, false), null);
    expectedCookie = new Cookie("Chocolate Chip", new String[] {"flour", "butter", "sugar", "chocolate chips"}, 1.0,
        200.0, 30.0, 20.0, 1.0,
        10.0, false, true, false);
    expectedNextCookieNode = null;
  }

  @Test
  void getCookie() {
    assertEquals(expectedCookie, testCookieNode.getCookie());
  }

  @Test
  void getNextCookie() {
    assertEquals(expectedNextCookieNode, testCookieNode.getNextCookieNode());
  }

  @Test
  void setNextCookie() {
    CookieNode newNextNode = new CookieNode(new Cookie("Chocolate Chip", new String[] {"flour", "butter", "sugar", "chocolate chips"}, 1.0,
        200.0, 30.0, 20.0, 1.0, 10.0, false, true, false), null);
    testCookieNode.setNextCookieNode(new CookieNode(new Cookie("Chocolate Chip", new String[] {"flour", "butter", "sugar", "chocolate chips"}, 1.0,
        200.0, 30.0, 20.0, 1.0,
        10.0, false, true, false), null));
    assertEquals(newNextNode, testCookieNode.getNextCookieNode());
  }
}