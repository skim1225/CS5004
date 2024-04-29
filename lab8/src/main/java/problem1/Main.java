package problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>();
    numbers.add(3);
    numbers.add(7);
    numbers.add(3);
    numbers.add(7);
    numbers.add(3);
    numbers.add(5);
    Map<Integer, Double> frequencyCounter = FrequencyCounter.countFrequencies(numbers);
    for (Map.Entry<Integer, Double> pair: frequencyCounter.entrySet()) {
      System.out.println("Number: " + pair.getKey());
      System.out.println("Frequency: " + pair.getValue());
    }
  }
}
