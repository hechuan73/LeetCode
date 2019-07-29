package items;

import java.util.Stack;

public class BaseballGame_682 {
    public int calPoints(String[] ops) {
        Stack<Integer> results = new Stack<>();

        for (String op : ops) {
            if ("C".equals(op)) results.pop();
            else if ("D".equals(op)) results.push(2 * results.peek());
            else if ("+".equals(op)) {
                int lastScore = results.pop();
                int currentScore = lastScore + results.peek();
                results.push(lastScore);
                results.push(currentScore);
            }
            else results.push(Integer.parseInt(op));
        }

        int result = 0;
        for (Integer integer : results) result += integer;

        return result;
        //return results.stream().reduce(0, Integer::sum); // stream is time consuming.
    }
}
