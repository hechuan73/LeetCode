package Items;

import com.sun.xml.internal.ws.resources.WsdlmodelMessages;

/**
 * Approach 1 : implement by array without wasting one element space.
 *
 * Approach 2: implement by linked list
 */
public class DesignCircularDeque_641 {

    private int[] data;
    private int front;
    private int rear;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public DesignCircularDeque_641(int k) {
        data = new int[k+1]; // the extra one space to check if the queue is full;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front == 0) ? data.length-1 : --front; // use "--front" instead of "front--"
        data[front] = value;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        data[rear] = value;
        rear = (rear+1) % data.length;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front+1) % data.length;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = (rear == 0) ? data.length-1 : --rear;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return isEmpty() ? -1 : data[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return isEmpty() ? -1 :
                (rear == 0 ? data[data.length-1] : data[rear-1]);
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return front == rear;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (rear+1) % data.length == front;
    }
}
