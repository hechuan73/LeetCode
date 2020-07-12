package items;

/**
 * @author hechuan
 */
public class KthAncestorOfaTreeNode_1456 {

    static class TreeAncestor {

        private int[] parents;
        private int[] heights;
        public TreeAncestor(int n, int[] parent) {
            parents = parent;
            heights = new int[n];

            for (int i = 0; i < n; i++) {
                getHeight(i);
            }
        }

        // 用于判定输入的高度是否有效，如果有效，直接log(n)时间复杂度搜索
        private int getHeight(int node) {
            if (node == 0 || heights[node] != 0) { return heights[node]; }
            return heights[node] = getHeight(parents[node])+1;
        }

        public int getKthAncestor(int node, int k) {
            if (heights[node] < k) { return -1; }
            while (k > 0) {
                node = parents[node];
                k--;
            }

            return node;
        }
    }

}
