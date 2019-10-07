package items;

import java.util.Stack;

public class DailyTemperatures_739 {

    public static int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];

        // the stack stores the index instead of value, so we can traverse rightly to reduce operations.
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                res[stack.peek()] = i-stack.pop();
            }
            stack.push(i);
        }

        return res;
    }
}
