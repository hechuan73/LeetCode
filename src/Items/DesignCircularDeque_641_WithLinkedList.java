package Items;

public class DesignCircularDeque_641_WithLinkedList {

    private DoubleListNode front;
    private DoubleListNode rear;
    private int capacity;
    private int size; // need a variable to store the current count of the queue.

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public DesignCircularDeque_641_WithLinkedList(int k) {
        this.capacity = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        DoubleListNode node = new DoubleListNode(value);
        if (isEmpty()) {
            rear = node;
        }
        else {
            front.prev = node;
            node.next = front;
            node.prev = rear;
            rear.next = node;
        }

        front = node;
        size++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        DoubleListNode node = new DoubleListNode(value);
        if (isEmpty()) {
            front = node;
        }
        else {
            rear.next = node;
            node.prev = rear;
            node.next = front;
            front.prev = node;
        }

        rear = node;
        size++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) return false;

        if ((front = front.next) == null) rear = null; // there is just one data, so when execute 'front = front.next', front is null, and we need to reset rear to null.
        else {
            front.prev = rear;
            rear.next = front;
        }

        size--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        if ((rear = rear.prev) == null) front = null; // there is just one data, so when execute 'rear = rear.prev', rear is null, and we need to reset front to null.
        else {
            rear.next = front;
            front.prev = rear;
        }

        size--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        return isEmpty() ? -1 : front.val;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        return isEmpty() ? -1 : rear.val;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return size == capacity;
    }
}
