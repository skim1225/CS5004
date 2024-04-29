package Problem1;

/**
 * A cookie catalog represents a collection of Cookie objects
 */

public interface ICookieCatalog {

  /**
   * Returns whether the Cookie Catalog is empty
   * @return whether the catalog is empty
   */
  Boolean isEmpty();

  /**
   * Returns the number of Cookies in the CookieCatalog as an Integer
   * @return the number of cookies in the catalog
   */
  Integer countCookies();

  /**
   * Checks if a cookie with the requested name is in the catalog
   * @param cookieName The name of the cookie to find
   * @return Whether the given cookie exists in the catalog
   */
  Boolean checkCookie(String cookieName);

  /**
   * Adds the given Cookie to the catalog
   * @param cookie The Cookie to be added
   */
  void addCookie(Cookie cookie);

  /**
   * Removes the specified Cookie from the Cookie catalog
   * @param cookie The Cookie to be removed
   * @throws CookieNotFoundException if the given Cookie is not in the Catalog
   */
  void removeCookie(Cookie cookie) throws CookieNotFoundException;

  /**
   * Finds and returns all Cookies from the Cookie Catalog which are gluten-free and contain
   * less than 30g of sugar per serving
   * @return A Cookie array of gluten-free and low sugar Cookies
   */
  CookieCatalog findGlutenFreeSugarLiteCookies();

  /**
   * Finds and returns all Cookies from the Cookie Catalog which contain both nuts and dairy
   * @return A Cookie array of Cookies containing nuts and dairy
   */
  CookieCatalog  findNutsAndDairyCookies();
}
