package Problem1;

import java.util.Objects;

/**
 * Class CookieNode represents one member of the Cookie Catalog ADT
 */

public class CookieNode {

  private Cookie cookie;
  private CookieNode nextCookieNode;

  /**
   * Constructor for creating a new Cookie Node with the given cookie and next cookie
   * @param cookie - The Cookie to be the data of the Cookie Node
   * @param nextCookieNode - The next Cookie Node in the link
   */
  public CookieNode(Cookie cookie, CookieNode nextCookieNode) {
    this.cookie = cookie;
    this.nextCookieNode = nextCookieNode;
  }

  /**
   * Return the Cookie of this node
   * @return the Cookie for this node
   */
  public Cookie getCookie() {
    return cookie;
  }

  /**
   * Return the next CookieNode
   * @return the next CookieNode
   */
  public CookieNode getNextCookieNode() {
    return nextCookieNode;
  }

  /**
   * Set the next CookieNode for this Node
   * @param nextCookieNode - The next cookie node to be set
   */
  public void setNextCookieNode(CookieNode nextCookieNode) {
    this.nextCookieNode = nextCookieNode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CookieNode that = (CookieNode) o;
    return Objects.equals(cookie, that.cookie) && Objects.equals(nextCookieNode,
        that.nextCookieNode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cookie, nextCookieNode);
  }
}
