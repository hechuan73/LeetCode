package algorithms.cache;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * Use double linked list to store the cache nodes, each node store some nodes which have the same usage count int list
 * 'keys'. Also used HashMap to make the time complexity of each operation be O(1).
 *
 * @author hechuan
 */
public class LFUWithDoubleLinkedList {

    private Node head = null;
    private int capacity;
    private HashMap<Integer, Integer> values;
    private HashMap<Integer, Node> nodes;

    public LFUWithDoubleLinkedList(int capacity) {
        this.capacity = capacity;
        values = new HashMap<>();
        nodes = new HashMap<>();
    }

    /**
     * Get the value of the node with specific key.
     *
     * @param key the key of the node which need to be added into the cache
     */
    public int get(int key) {
        if (values.containsKey(key)) { increaseCount(key); }
        return values.getOrDefault(key, -1);
    }

    /**
     * Put a node with specific key and value.
     *
     * @param key the key of the node which need to be added into the cache
     * @param value the value of the node which need to be added into the cache.
     */
    public void put(int key, int value) {
        if (capacity <= 0) { return; }

        // this key already in the values map.
        if (values.put(key, value) != null) { increaseCount(key);}
        else {
            // if the cache is full, remove the minimum usage node, if several nodes has the same minimum usage, remove
            // the oldest node.
            if (nodes.size() == capacity) { removeMinimumUsageAndOldestNode(); }
            add(key);
        }
    }

    /**
     * Remove the minimum usage node, if several nodes has the same minimum usage, remove the oldest node.
     */
    private void removeMinimumUsageAndOldestNode() {
        // the head node store the minimum count nodes, and the head.keys.iterator().next() returns the oldest node.
        int minimumOldest = head.keys.iterator().next();
        head.keys.remove(minimumOldest);
        if (head.keys.isEmpty()) { remove(head); }
        nodes.remove(minimumOldest);
        values.remove(minimumOldest);
    }

    /**
     * Add a node with the specific key to the cache list.
     *
     * @param key the node's key
     */
    private void add(int key) {
        if (head == null) { head = new Node(null, null, 1, key); }
        else if (head.count == 1) { head.keys.add(key); }
        else { head = head.prev = new Node(null, head, 1, key); }

        nodes.put(key, head);
    }

    /**
     * Increase the usage count of the node with the specific key.
     *
     * @param key the node's key
     */
    private void increaseCount(int key) {
        Node curr = nodes.get(key);
        curr.keys.remove(key);

        // next node is null
        if (curr.next == null) { curr.next = new Node(curr, null, curr.count+1, key); }
        // count of next node is curr.count + 1, add it in next node.
        else if (curr.next.count == curr.count + 1) { curr.next.keys.add(key); }
        // count of next node is not curr.count + 1, create a new node.
        else { curr.next = curr.next.prev = new Node(curr, curr.next, curr.count+1, key); }

        nodes.put(key, curr.next);
        if (curr.keys.isEmpty()) { remove(curr); }
    }

    /**
     * Remove the specific node.
     *
     * @param node to be removed
     */
    private void remove(Node node) {
        if (head == node) { head = node.next; }
        else { node.prev.next = node.next; }

        if (node.next != null) { node.next.prev = node.prev; }
    }

    static class Node {
        public Node prev, next;
        public final int count;
        public LinkedHashSet<Integer> keys = new LinkedHashSet<>();

        public Node(Node prev, Node next, int count, int key) {
            this.prev = prev;
            this.next = next;
            this.count = count;
            keys.add(key);
        }
    }
}
