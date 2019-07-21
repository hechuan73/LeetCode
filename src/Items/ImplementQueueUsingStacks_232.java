package Items;

import java.util.Stack;


/**
 * Use two stacks, stack1 for pushing operation and stack2 for popping operation. When we want to pop element, we need
 * to transfer the elements from stack1 to stack2, and then pop in stack2. This is a batch process, one transferring
 * operation can apply multi popping operations.
 *
 * In addition, we can record the 'front' when stack1 is empty for peeking
 * operation, so when we want to peek, we just need to check whether stack2 is empty, if true, peeking the 'front'; if
 * not, stack2 do peeking operation.
 */
public class ImplementQueueUsingStacks_232 {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private int front;

    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks_232() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (stack1.isEmpty()) front = x;
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) stack2.push(stack1.pop());
        }

        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack2.isEmpty() ? front : stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
