package problem2;

/**
 * Class book represents a Book object as its title, creator, and year created.
 */

public class Book extends Media {

  /**
   * Constructor for creating a new Book with the given author, title, and publishing year.
   * @param author - The Creator of the Book, as an Author.
   * @param title - The title of the Book, as a String.
   * @param year - The year the Book was published, as an Integer.
   */
  public Book(Author author, String title, Integer year) {
    super(author, title, year);
  }
}
