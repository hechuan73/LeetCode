package Items;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRecentCalls_933 {

    private Queue<Integer> queue;

    public NumberOfRecentCalls_933() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);

        while (t - queue.peek() > 3000) queue.poll();

        return queue.size();
    }
}
