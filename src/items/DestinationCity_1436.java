package items;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DestinationCity_1436 {

    public String destCity(List<List<String>> paths) {
        Map<String, Integer> outDegrees = new HashMap<>();
        for (List<String> path : paths) {
            outDegrees.put(path.get(0), outDegrees.getOrDefault(path.get(0), 0)+1);
            outDegrees.putIfAbsent(path.get(1), 0);
        }

        for (Map.Entry<String, Integer> entry : outDegrees.entrySet()) {
            if (entry.getValue() == 0) {
                return entry.getKey();
            }
        }

        return "";
    }
}
