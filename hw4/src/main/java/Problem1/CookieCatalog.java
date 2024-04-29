package Problem1;

import java.util.Objects;

/**
 * Class CookieCatalog is  used by a cookie factory, to keep track of information about produced
 * cookies and their nutritional information.
 */
public class CookieCatalog implements ICookieCatalog{

  private CookieNode head;
  private Integer size;

  /**
   * Constructor for creating a new CookieCatalog with the given head Cookie Node and size.
   * @param head The CookieNode to be set
   * @param size The size to be set
   */
  public CookieCatalog(CookieNode head, Integer size) {
    this.head = head;
    this.size = size;
  }

  /**
   * Constructor for creating a new empty CookieCatalog
   */
  public CookieCatalog() {
    this.head = null;
    this.size = 0;
  }

  /**
   * Returns the head node
   * @return the head node
   */
  public CookieNode getHead() {
    return head;
  }

  /**
   * Returns whether the CookieCatalog is empty
   * @return whether the CookieCatalog is empty
   */
  @Override
  public Boolean isEmpty() {
    return this.size == 0;
  }

  /**
   * Returns the number of Cookies in the Catalog
   * @return the number of Cookies in the Catalog
   */
  @Override
  public Integer countCookies() {
    return this.size;
  }

  /**
   * Returns whether the Cookie with the given name is in the Cookie Catalog
   * @param cookieName The name of the cookie to find
   * @return Whether the given Cookie exists in the catalog
   */
  @Override
  public Boolean checkCookie(String cookieName) {
    CookieNode curr = this.head;
    for (int i = 0; i < this.size; i++) {
      if (this.head.getCookie().getName().equals(cookieName)) {
        return true;
      } else {
        curr = curr.getNextCookieNode();
      }
    }
    return false;
  }

  /**
   * Adds the given Cookie to the Catalog
   * @param cookie The Cookie to be added
   */
  @Override
  public void addCookie(Cookie cookie) {
    if (!checkCookie(cookie.getName())) {
      CookieNode cookieNodeToAdd = new CookieNode(cookie, this.head);
      this.head = cookieNodeToAdd;
      this.size += 1;
    }
  }

  /**
   * Removes the given cookie from the catalog
   * @param cookie The Cookie to be removed
   * @throws CookieNotFoundException if the given Cookie is not in the Cookie catalog
   */
  @Override
  public void removeCookie(Cookie cookie) throws CookieNotFoundException {
    if (!checkCookie(cookie.getName())) {
      throw new CookieNotFoundException(("Cannot remove cookie that's not in the catalog."));
    } else {
      CookieNode curr = this.head;
      // case 1: head is cookie to remove
      if (curr.getCookie().equals(cookie)) {
        this.head = this.head.getNextCookieNode();
      } else {
        // case 2: head is not cookie to remove
        for (int i = 1; i < this.size - 1; i++) {
          if (curr.getNextCookieNode().getCookie().equals(cookie)) {
            curr.setNextCookieNode(curr.getNextCookieNode().getNextCookieNode());
          }
        }
      }
      this.size -= 1;
    }
  }

  /**
   * Returns a new Cookie Catalog containing Cookies that are gluten-free and low sugar.
   * @return a new Cookie Catalog containing Cookies that are gluten-free and low sugar.
   */
  @Override
  public CookieCatalog findGlutenFreeSugarLiteCookies() {
    CookieCatalog gfSugarLite = new CookieCatalog();
    CookieNode curr = this.head;
    for (int i = 0; i < this.size; i++) {
      if (curr.getCookie().getGlutenFree() && curr.getCookie().getSugarPerServing() < 30) {
        gfSugarLite.addCookie(curr.getCookie());
      }
      curr = curr.getNextCookieNode();
    }
    return gfSugarLite;
  }

  /**
   * Returns a new Cookie Catalog containing Cookies that have dairy and nuts
   * @return a new Cookie Catalog containing Cookies that have dairy and nuts
   */
  @Override
  public CookieCatalog findNutsAndDairyCookies() {
    CookieCatalog nutsAndDairy = new CookieCatalog();
    CookieNode curr = this.head;
    for (int i = 0; i < this.size; i++) {
      if (curr.getCookie().getContainsNuts() && curr.getCookie().getContainsDairy()) {
        nutsAndDairy.addCookie(curr.getCookie());
      }
      curr = curr.getNextCookieNode();
    }
    return nutsAndDairy;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CookieCatalog that = (CookieCatalog) o;
    return Objects.equals(head, that.head) && Objects.equals(size, that.size);
  }

  @Override
  public int hashCode() {
    return Objects.hash(head, size);
  }

  @Override
  public String toString() {
    return "CookieCatalog{" +
        "head=" + head +
        ", size=" + size +
        '}';
  }
}
