package midterm.p4;

public class EmptyVideoGamesCatalog implements VideoGamesCatalog {

  /**
   * Returns the number of video games in the catalog
   *
   * @return the number of video games in the catalog
   */
  @Override
  public Integer count() {
    return 0;
  }

  /**
   * Adds the given video game into the catalog. Duplicates are allowed.
   *
   * @param game - The video game to be added, as a VideoGame.
   * @return a new VideoGamesCatalog with the given game added.
   */
  @Override
  public VideoGamesCatalog add(VideoGame game) {
    return new NonEmptyVideoGamesCatalog(game, this);
  }

  /**
   * Returns a VideoGameCatalog containing all the games from this VideoGamesCatalog containing all
   * games that have more than 500,000 downloads and more than 5 creators.
   *
   * @return a VideoGameCatalog containing all the games from this VideoGamesCatalog containing all
   *    * games that have more than 500,000 downloads and more than 5 creators.
   */
  @Override
  public VideoGamesCatalog getPopular() {
    return this;
  }
}
