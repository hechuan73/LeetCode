package items;

import java.util.*;

public class TweetCounts_1348 {

    Map<String, Integer> times;
    TreeMap<Integer, Set<String >> map;
    public TweetCounts_1348() {
        map = new TreeMap<>();
        times = new HashMap<>();
        times.put("minute", 60);
        times.put("hour", 3600);
        times.put("day", 3600*24);
    }

    public void recordTweet(String tweetName, int time) {
        if (!map.containsKey(time)) { map.put(time, new HashSet<>()); }
        map.get(time).add(tweetName);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> res = new ArrayList<>();
        int timeInterval = times.get(freq);
        int[] intervals = new int[((endTime-startTime) / timeInterval)+1];

        for (Map.Entry<Integer, Set<String>> entry : map.subMap(startTime, endTime+1).entrySet()) {
            if (entry.getValue().contains(tweetName)) {
                intervals[(entry.getKey()-startTime) / timeInterval]++;
            }
        }

        for (int val : intervals) { res.add(val); }

        return res;
    }
}
