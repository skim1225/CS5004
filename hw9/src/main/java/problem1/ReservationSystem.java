package problem1;

/**
 * Class ReservationSystem is responsible for running the reservations service for reserving seats
 * in a theater.
 */
public class ReservationSystem {
  public static void main(String[] args) {
    Theater theater = Theater.getInstance();
    ReservationsService.reservation(theater);
  }
}