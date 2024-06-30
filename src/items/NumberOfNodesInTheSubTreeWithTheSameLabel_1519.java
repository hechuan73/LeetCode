package items;

import java.util.*;

/**
 * @author hechuan
 */
public class NumberOfNodesInTheSubTreeWithTheSameLabel_1519 {

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> children = new HashMap<>();
        Set<Integer> nodes = new HashSet<>();
        nodes.add(0);
        for (int[] edge : edges) {
            if (nodes.contains(edge[0])) {
                children.putIfAbsent(edge[0], new ArrayList<>());
                children.get(edge[0]).add(edge[1]);
                nodes.add(edge[1]);
            } else {
                children.putIfAbsent(edge[1], new ArrayList<>());
                children.get(edge[1]).add(edge[0]);
                nodes.add(edge[0]);
            }
        }

        int[] res = new int[n];
        char[] chars = labels.toCharArray();
        Map<Integer, Map<Character, Integer>> childChaCounter = new HashMap<>();
        Map<Character, Integer> curr;
        for (int i = 0; i < n; i++) {
            curr = new HashMap<>();
            if (childChaCounter.containsKey(i)) {
                curr = childChaCounter.get(i);
            }
            else{
                compute(curr, chars[i], i, children, chars, childChaCounter);
            }
            res[i] = curr.get(chars[i]);
            childChaCounter.putIfAbsent(i, curr);
        }

        return res;
    }

    private void compute(Map<Character, Integer> parent, char currCha, int currNum, Map<Integer, List<Integer>>children,
                                char[] chars, Map<Integer, Map<Character, Integer>> childChaCounter) {
        Map<Character, Integer> curr = new HashMap<>();
        curr.put(currCha, 1);
        List<Integer> nodes = children.get(currNum);
        if (null != nodes && !nodes.isEmpty()) {
            for (Integer node : nodes) {
                compute(curr, chars[node], node, children, chars, childChaCounter);
            }
        }

        childChaCounter.put(currNum, curr);
        merge(parent, curr);
    }

    private void merge(Map<Character, Integer> parent, Map<Character, Integer> child) {
        if (null != child && !child.isEmpty()) {
            char key;
            for (Map.Entry<Character, Integer> entry : child.entrySet()) {
                key = entry.getKey();
                if (parent.containsKey(key)) {
                    parent.put(key, parent.get(key) + entry.getValue());
                }
                else {
                    parent.put(key, entry.getValue());
                }
            }
        }
    }
}
