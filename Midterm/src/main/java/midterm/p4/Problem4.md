a. Method that uses a local variable:

I did not use any local variables. I instead opted to use class constants to prevent magic numbers.


b. Helper method used to implement the given ADT:
```
 /**
   * Returns whether the game has more than 500,000 downloads
   * @param game - the game to be checked, as a VideoGame
   * @return true if game has more than 500,000 downloads
   */
  private Boolean hasManyDownloads(VideoGame game) {
    return game.getNumDownloads() > MIN_DOWNLOADS;
  }

```