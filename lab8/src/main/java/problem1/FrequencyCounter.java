package problem1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyCounter {

  public FrequencyCounter() {
  }

  public static Map<Integer, Double> countFrequencies(List<Integer> integersList) {
    Map<Integer, Double> frequencyMap = new HashMap<>();
    Double defaultValue = 1.0 / integersList.size();
    for(Integer e: integersList) {
      double count = frequencyMap.getOrDefault(e, 0.0);
      frequencyMap.put(e, count + defaultValue);
    }
    return frequencyMap;
  }
}
