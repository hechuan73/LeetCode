package items;

import java.util.LinkedList;

/**
 * @author hechuan
 */
public class CombinationIterator_1286 {

    private LinkedList<String> combinations;

    public CombinationIterator_1286(String characters, int combinationLength) {
        combinations = new LinkedList<>();
        backtracking(characters, combinationLength, 0, new StringBuilder());
    }

    private void backtracking(String characters, int combinationLength, int start, StringBuilder sb) {
        if (combinationLength == 0) {
            combinations.add(sb.toString());
            return;
        }

        for (int i = start; i < characters.length()-combinationLength+1; i++) {
            sb.append(characters.charAt(i));
            backtracking(characters, combinationLength-1, i+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public String next() {
        return combinations.removeFirst();
    }

    public boolean hasNext() {
        return !combinations.isEmpty();
    }
}
