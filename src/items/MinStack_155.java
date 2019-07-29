package items;

import java.util.Stack;

public class MinStack_155 {

    private Stack<Integer> data;
    private int min;

    /** initialize your data structure here. */
    public MinStack_155() {
        data = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    /**
     * We need to record the minimum value, so we add the comparison. In addition, if the x is less than 'min', we need to
     * record the old minimum value before we change the 'min' for popping operation.
     *
     * @param x value to push
     */
    public void push(int x) {
        if (x <= min) {
            data.push(min);
            min = x;
        }

        data.push(x);
    }

    /**
     * We need to check the value popped whether it is the minimum value, if true, we need to pop again to get the new
     * minimum value which we have pushed before.
     */
    public void pop() {
        if (data.pop() == min) min = data.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min;
    }
}
