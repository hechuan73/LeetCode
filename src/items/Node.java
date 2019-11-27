package items;

import java.util.List;

/**
 * Definition for a Node of N_Ary tree.
 *
 * @author hechuan
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}