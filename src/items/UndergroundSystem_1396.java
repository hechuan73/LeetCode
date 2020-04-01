package items;

import java.util.HashMap;
import java.util.Map;


/**
 * @author hechuan
 */
public class UndergroundSystem_1396 {

    class UndergroundSystem {
        Map<Integer, StationTime> idToStation;
        Map<String, double[]> tripCounter;
        public UndergroundSystem() {
            idToStation = new HashMap<>();
            tripCounter = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            idToStation.put(id, new StationTime(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            StationTime stationTime = idToStation.get(id);
            String key = stationTime.station + "-" + stationName;
            if (tripCounter.containsKey(key)) {
                double[] tripCount = tripCounter.get(key);
                tripCount[0] += t-stationTime.time;
                tripCount[1]++;
            }
            else {
                tripCounter.put(key, new double[] {t-stationTime.time, 1});
            }
        }

        public double getAverageTime(String startStation, String endStation) {
            double[] tripCount = tripCounter.get(startStation + "-" + endStation);
            return tripCount[0] / tripCount[1];
        }

        class StationTime {
            private String station;
            private int time;

            public StationTime(String station, int time) {
                this.station = station;
                this.time = time;
            }
        }
    }
}
