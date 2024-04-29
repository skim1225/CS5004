package problem1;

import java.util.Objects;
import java.util.Scanner;

/**
 * Class ReservationsService is a class that provides functionality for a service which allows users
 * to reserve seats in a movie theater. It takes into account accessibility and seat priority.
 */

public class ReservationsService {

  /**
   * A method which allows users to reserve a number of seats in a movie theater. It allows users to
   * enter the number of seats to reserve and whether the seats need to be accessible. It takes into
   * account that the best seats are towards the middle row and assigns the best seats first
   * come first serve.
   * @param theater - The theater to reserve the seats in, as a Theater.
   */
  public static void reservation(Theater theater) {
    String input = "";
    Scanner console = new Scanner(System.in);
    Integer numSeats;
    boolean accessible = Boolean.FALSE;
    while (!input.equals("done")) {
      System.out.println("What would you like to do?");
      input = console.next();
      switch (input) {
        case "reserve":
          if (console.hasNextInt()) {
            numSeats = console.nextInt();
            System.out.println("Do you need accessible seats? Please input yes or no: ");
            input = console.next();
            if (Objects.equals(input, "yes")) {
              accessible = Boolean.TRUE;
            } else if (Objects.equals(input, "no")) {
              accessible = Boolean.FALSE;
            }
            System.out.println("What's your name?");
            String name = console.next();
            reserve(theater, numSeats, accessible, name);
          } else {
            System.out.println("Enter a valid integer.");
          }
          break;
        case "show":
          System.out.println(theater);
          break;
        case "done":
          System.out.println("Have a nice day!");
          break;
        default:
          System.out.println("Not a valid option. Try again!");
      }
    }
  }

  /**
   * Method for reserving the desired number of seats. The seats closest to the middle row of the
   * theater will fill up first, and only users who request accessible rows will be seated in the
   * accessible rows, unless no other rows are available.
   *
   * @param theater    - The theater to reserve seats in, as an Integer.
   * @param numSeats   - The number of seats to be reserved, as an Integer.
   * @param accessible - Whether the reservation needs to be in an accessible row, as a boolean.
   * @param name       - The name for the reservation, as a String.
   */
  static void reserve(Theater theater, Integer numSeats, boolean accessible, String name) {
    boolean reserved = false;
    int rowNum = 0;
    int counter = 0;
    Row row;

    if (accessible) {
      row = theater.getRows().get(rowNum);
      if (row.seatsAvailable() >= numSeats) {
        for (Seat seat : row) {
          if (seat.getReservedFor() == null && counter < numSeats) {
            seat.setReservedFor(name);
            counter++;
          }
        }
        reserved = true;
      }
    } else {
      rowNum = Theater.NUM_ROWS / 2; // start at middle row
      for (int i = 1; i < Theater.NUM_ROWS; i++) {
        row = theater.getRows().get(rowNum);
        if (row.seatsAvailable() >= numSeats) {
          for (Seat seat : row) {
            if (seat.getReservedFor() == null && counter < numSeats) {
              seat.setReservedFor(name);
              counter++;
            }
          }
          reserved = true;
          break;
        }
        if (i % 2 != 0) {
          rowNum += i;
        } else {
          rowNum -= i;
        }
      }
    }

    if (!reserved) { // Last Resort
      row = theater.getRows().get(0);
      if (row.seatsAvailable() >= numSeats) {
        for (Seat seat : row) {
          if (seat.getReservedFor() == null && counter < numSeats) {
            seat.setReservedFor(name);
            counter++;
          }
        }
        reserved = true;
      }
    }

    if (reserved) {
      System.out.println(
          "I've reserved " + numSeats + " seat(s) for you at " + Theater.THEATER_NAME +
              " in row " + (rowNum + 1) + ", " + name);
    } else {
      System.out.println("Unfortunately, your reservation could not be made.");
    }
  }
}