package items;

import java.util.*;

/**
 * This RandomizedSet data structure is allowed duplicated number.
 *
 * We use ArrayList, HashMap and LinkedHashSet, the last one can delete the first element in O(1).
 *
 * @author hechuan
 */
public class RandomizedCollection_381 {

    private List<Integer> elements;
    private Map<Integer, Set<Integer>> elementIndexes;

    /** Initialize your data structure here. */
    public RandomizedCollection_381() {
        elementIndexes = new HashMap<>();
        elements = new ArrayList<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (!elementIndexes.containsKey(val)) { elementIndexes.put(val, new LinkedHashSet<Integer>()); }
        elementIndexes.get(val).add(elements.size());
        elements.add(val);
        return true;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!elementIndexes.containsKey(val)) { return false; }
        // always delete the first one.
        int index = elementIndexes.get(val).iterator().next();
        // we need firstly remove the index, otherwise, if all elements are the same number, if we remove it later, it
        // will be wrong.
        elementIndexes.get(val).remove(index);
        if (index < elements.size()-1) {
            int lastOne = elements.get(elements.size()-1);
            elements.set(index, lastOne);
            // LinkedHashSet is implemented by HashMap, so it delete by value is also O(1)
            elementIndexes.get(lastOne).remove(elements.size()-1);
            elementIndexes.get(lastOne).add(index);
        }

        elements.remove(elements.size()-1);
        if (elementIndexes.get(val).isEmpty()) { elementIndexes.remove(val); }

        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        int min = 0;
        int max = elements.size();
        int random = (int) (Math.random() * (max - min)) + min;
        return elements.get(random);
    }
}
