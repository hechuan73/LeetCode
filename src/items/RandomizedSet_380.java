package items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * This RandomizedSet data structure is not allowed duplicated number.
 *
 * The key point of this question is how to guarantee the time complexity of remove operation to O(1). As we know, if
 * the element is the last one in the list, the remove operation can be O(1). If not the last one, So we choose to set
 * the element which needs to remove to the value of the last one, and then remove the last one element.
 *
 * @author hechuan
 */
public class RandomizedSet_380 {

    private Map<Integer, Integer> elementIndexes;
    private ArrayList<Integer> elements;

    /** Initialize your data structure here. */
    public RandomizedSet_380() {
        elementIndexes = new HashMap<>();
        elements = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (elementIndexes.containsKey(val)) { return false; }
        // the size of the elements is the index of the new added element.
        elementIndexes.put(val, elements.size());
        elements.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!elementIndexes.containsKey(val)) { return false; }

        int index = elementIndexes.get(val);
        if (index < elements.size()-1) {
            // set target value as the last one element.
            int lastOne = elements.get(elements.size()-1);
            elements.set(index, lastOne);
            elementIndexes.put(lastOne, index);
        }

        // remove the last one element.
        elementIndexes.remove(val);
        elements.remove(elements.size()-1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int max = elements.size();
        int min = 0;
        int index =  (int)(Math.random() * (max - min) + min);
        return elements.get(index);
    }
}
