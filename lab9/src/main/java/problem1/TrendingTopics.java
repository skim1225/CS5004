package problem1;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TrendingTopics {
public static Map<String, Long> countTopics(List<String> topics) {
  // turns list of strings into a stream
  // no intermediate operators
  // terminal operator: collect creates a map
  return topics.stream()
      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
}
}
