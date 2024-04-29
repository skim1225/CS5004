package problem2;

import java.util.ArrayList;

/**
 * Interface CatalogADT tells the client what functionalities are supported by a Catalog object.
 */

public interface CatalogADT {

  /**
   * Adds the given media items into the collection
   * @param mediaToAdd - The media to be added
   */
  void add(Media mediaToAdd);

  /**
   * Removes the given media item from the collection
   * @param mediaToRemove - The media to be removed
   */
  void remove(Media mediaToRemove);

  /**
   * Returns an ArrayList of all the media in the collection which contains the given keyword
   * in the title.
   * @param keyword - The search query, as a String
   * @return an ArrayList of all the media in the collection which contains the given keyword
   * in the title.
   */
  ArrayList<Media> search(String keyword);

  /**
   * Returns an ArrayList of all the Books in the collection with the given Author.
   * @param author - The author to search for, as an Author.
   * @return an ArrayList of all the Books in the collection with the given Author.
   */
  ArrayList<Book> search(Author author);

  /**
   * Returns an ArrayList of all the Music in the collection with the given RecordingArtist
   * @param artist - The artist of the music to search for, as a RecordingArtist
   * @return an ArrayList of all the Music in the collection with the given RecordingArtist
   */
  ArrayList<Music> search(RecordingArtist artist);
}
