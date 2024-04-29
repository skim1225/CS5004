package problem1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservationsServiceTest {
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private final InputStream originalIn = System.in;

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @AfterEach
  public void tearDown() {
    System.setOut(originalOut);
    System.setIn(originalIn);
  }

  @Test
  public void testReservation() {
    String simulatedUserInput = "reserve 3\nno\nJohn\ndone";
    System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
    Theater mockTheater = new Theater();
    ReservationsService.reservation(mockTheater);
    String expectedOutput = "What would you like to do?\n"
        + "Do you need accessible seats? Please input yes or no: \n"
        + "What's your name?\n"
        + "I've reserved 3 seat(s) for you at The Fresh Tomato in row 8, John\n"
        + "What would you like to do?\n"
        + "Have a nice day!\n";
    assertEquals(expectedOutput, outputStreamCaptor.toString());
  }

  @Test
  public void testReserve() {
    String simulatedUserInput = "reserve 3\nno\nJohn\ndone";
    System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
    Theater mockTheater = new Theater();
    ReservationsService.reserve(mockTheater, 3, false, "John");
    String expectedOutput = "I've reserved 3 seat(s) for you at The Fresh Tomato in row 8, John\n";
    assertEquals(expectedOutput, outputStreamCaptor.toString());
  }
}
