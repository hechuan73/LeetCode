package items;

import java.util.*;

/**
 * @author hechuan
 */
public class GetWatchedVideosByYourFriends_1311 {

    /**
     * BFS solution.
     *
     * @param watchedVideos array of watched videos
     * @param friends array of friends
     * @param id start id
     * @param level friends level
     * @return the watched videos by friends in the specific level
     */
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[friends.length];
        queue.add(id);
        visited[id] = true;

        // find the last level friends.
        int person, levelLen, levelCount = 0;
        while (!queue.isEmpty() && levelCount++ < level) {
            levelLen = queue.size();
            for (int i = 0; i < levelLen; i++) {
                person = queue.poll();
                for (int fre : friends[person]) {
                    if (!visited[fre]) {
                        queue.add(fre);
                        visited[fre] = true;
                    }
                }
            }
        }

        // get the movies that the last level friends have watched.
        Map<String, Integer> movies = new HashMap<>();
        while (!queue.isEmpty()) {
            person = queue.poll();
            for (String movie : watchedVideos.get(person)) {
                movies.put(movie, movies.getOrDefault(movie, 0) + 1);
            }
        }

        // sort them
        List<String> res = new ArrayList<>(movies.keySet());
        res.sort((a, b) -> {
            int fa = movies.get(a);
            int fb = movies.get(b);
            if (fa == fb) { return a.compareTo(b); }
            else { return fa-fb; }
        });

        return res;
    }
}
