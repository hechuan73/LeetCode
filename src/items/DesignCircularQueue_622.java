package items;

/**
 * Approach 1 : implement by array without wasting element space.
 *     In this implementation, we need an extra element space tp check if the queue is full,
 *         1. Queue empty: rear == front.
 *         2. Queue full: (rear+1) % data.capacity == front.
 *
 * Approach 2: implement by linked list
 *
 *
 */
public class DesignCircularQueue_622 {

    private int[] data;
    private int front;
    private int rear;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public DesignCircularQueue_622(int k) {
        data = new int[k+1]; // the extra one space to check if the queue is full;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) return false;
        data[rear] = value;
        rear = (rear+1) % data.length;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front+1) % data.length;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        return isEmpty() ? -1 : data[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        return isEmpty() ? -1 :
                (rear == 0 ? data[data.length-1] : data[rear-1] );
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return front == rear;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (rear + 1) % data.length == front;
    }
}