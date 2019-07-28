package Items;

import java.util.LinkedList;

public class ImplementStackUsingQueues_225 {

    private LinkedList<Integer> elements;

    /** Initialize your data structure here. */
    public ImplementStackUsingQueues_225() {
        elements = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        elements.add(x);

        int size = elements.size();
        while (size > 1) {
            elements.add(elements.remove());
            size--;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return elements.pop();
    }

    /** Get the top element. */
    public int top() {
        return elements.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return elements.isEmpty();
    }
}
