package problem2;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Class Catalog represents a collection of all items in the library.
 */

public class Catalog implements CatalogADT {

  private ArrayList<Media> collection;

  /**
   * Constructor for creating a new Catalog object with the given collection.
   * @param collection - The collection to be set, as an ArrayList.
   */
  public Catalog(ArrayList<Media> collection) {
    this.collection = collection;
  }

  /**
   * Constructor for creating a new Catalog object with an empty collection.
   */
  public Catalog() {
    this.collection = new ArrayList<Media>();
  }

  /**
   * Adds the given media items into the collection. Allows for duplicate items.
   * @param mediaToAdd - The media to be added
   */
  public void add(Media mediaToAdd) {
    this.collection.add(mediaToAdd);
  }

  /**
   * Removes the first instance of the given media item from the collection
   * @param mediaToRemove - The media to be removed
   */
  public void remove(Media mediaToRemove) {
    this.collection.remove(mediaToRemove);
  }

  /**
   * Returns an ArrayList of all the media in the collection which contains the given keyword
   * in the title.
   * @param keyword - The search query, as a String
   * @return an ArrayList of all the media in the collection which contains the given keyword
   * in the title.
   */
  public ArrayList<Media> search(String keyword) {
    keyword = keyword.toLowerCase();
    ArrayList<Media> results = new ArrayList<Media>();
    for (Media media:this.collection) {
      if (media.getTitle().toLowerCase().contains(keyword)) {
        results.add(media);
      }
    }
    return results;
  }

  /**
   * Returns an ArrayList of all the Books in the collection with the given Author.
   * @param author - The author to search for, as an Author.
   * @return an ArrayList of all the Books in the collection with the given Author.
   */
  public ArrayList<Book> search(Author author) {
    ArrayList<Book> results = new ArrayList<Book>();
    for (Media media:this.collection) {
      if (media.getCreator().equals(author)) {
        results.add((Book) media);
      }
    }
    return results;
  }

  /**
   * Returns an ArrayList of all the Music in the collection with the given RecordingArtist
   * @param artist - The artist of the music to search for, as a RecordingArtist
   * @return an ArrayList of all the Music in the collection with the given RecordingArtist
   */
  public ArrayList<Music> search(RecordingArtist artist) {
    ArrayList<Music> results = new ArrayList<Music>();
    for (Media media:this.collection) {
      Creator creator = media.getCreator();
      // COULD NOT FIGURE OUT HOW TO AVOID USING INSTANCEOF. PLEASE LET ME KNOW SOLUTION IN GRADING. THANK YOU
      if (creator instanceof RecordingArtist) {
        if (creator.equals(artist)) {
          results.add((Music) media);
        }
      } else if (creator instanceof Band) {
        Band band = (Band) media.getCreator();
        for (RecordingArtist creatorArtist:band.getBandMembers()) {
          if (creatorArtist.equals(artist)) {
            results.add((Music) media);
          }
        }
      }
    }
    return results;
  }

  /**
   * Returns the library's collection
   * @return the library's collection
   */
  public ArrayList<Media> getCollection() {
    return collection;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Catalog catalog = (Catalog) o;
    return Objects.equals(collection, catalog.collection);
  }

  @Override
  public int hashCode() {
    return Objects.hash(collection);
  }

  @Override
  public String toString() {
    return "Catalog{" +
        "collection=" + collection +
        '}';
  }
}
