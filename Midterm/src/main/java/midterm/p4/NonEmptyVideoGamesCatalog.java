package midterm.p4;

public class NonEmptyVideoGamesCatalog implements VideoGamesCatalog {

  private final Integer MIN_DOWNLOADS = 500000;
  private final Integer MIN_CREATORS = 5;

  private VideoGame head;
  private VideoGamesCatalog rest;

  public NonEmptyVideoGamesCatalog(VideoGame head, VideoGamesCatalog rest) {
    this.head = head;
    this.rest = rest;
  }

  /**
   * Returns the number of video games in the catalog
   *
   * @return the number of video games in the catalog
   */
  @Override
  public Integer count() {
    return 1 + this.rest.count();
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
    if (this.hasManyCreators(this.head) && this.hasManyDownloads(head)) {
      return new NonEmptyVideoGamesCatalog(this.head, this.rest.getPopular());
    } else {
      return this.rest.getPopular();
    }
  }

  /**
   * Returns whether the game has more than 500,000 downloads
   * @param game - the game to be checked, as a VideoGame
   * @return true if game has more than 500,000 downloads
   */
  private Boolean hasManyDownloads(VideoGame game) {
    return game.getNumDownloads() > MIN_DOWNLOADS;
  }

  /**
   * Returns whether the game has more than 5 creators
   * @param game - the game to be checked, as a VideoGame
   * @return whether the game has more than 5 creators
   */
  private Boolean hasManyCreators(VideoGame game) {
    return game.getCreators().length > MIN_CREATORS;
  }
}
