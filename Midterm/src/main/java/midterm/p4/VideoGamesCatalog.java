package midterm.p4;

public interface VideoGamesCatalog {

  /**
   * Returns the number of video games in the catalog
   * @return the number of video games in the catalog
   */
  Integer count();

  /**
   * Adds the given video game into the catalog. Duplicates are allowed.
   * @param game - The video game to be added, as a VideoGame.
   * @return a new VideoGamesCatalog with the given game added.
   */
  VideoGamesCatalog add(VideoGame game);

  /**
   * Returns a VideoGameCatalog containing all the games from this VideoGamesCatalog containing all
   * games that have more than 500,000 downloads and more than 5 creators.
   * @return a VideoGameCatalog containing all the games from this VideoGamesCatalog containing all
   *    * games that have more than 500,000 downloads and more than 5 creators.
   */
  VideoGamesCatalog getPopular();

}
