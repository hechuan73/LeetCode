package items;

public class DesignCircularQueue_622_WithLikedList {

    private ListNode front;
    private ListNode rear;
    private int capacity;
    private int size;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public DesignCircularQueue_622_WithLikedList(int k) {
        capacity = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) return false;

        ListNode node = new ListNode(value);
        if (isEmpty()) front = node;
        else {
            rear.next = node;
            node.next = front;
        }

        rear = node;
        size++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) return false;
        front = front.next;
        rear.next = front;

        size--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        return isEmpty() ? -1 : front.val;
    }

    /** Get the last item from the queue. */
    public int Rear() {
        return isEmpty() ? -1 : rear.val;
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == capacity;
    }
}
