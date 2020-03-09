package items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidateBinaryTreeNodes_1361 {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        // build edges
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) { edges.add(new ArrayList<>(Arrays.asList(i, leftChild[i]))); }
            if (rightChild[i] != -1) { edges.add(new ArrayList<>(Arrays.asList(i, rightChild[i]))); }
        }
        // edges + 1 == vertex
        if (edges.size() + 1 != n) { return false; }

        UnionFind uf = new UnionFind(n);
        for (List<Integer> edge : edges) {
            if (uf.union(edge.get(0), edge.get(1))) { return false; }
        }
        return true;
    }

    static class UnionFind {
        int[] roots;
        int[] ranks;

        UnionFind(int n) {
            this.roots = new int[n];
            this.ranks = new int[n];

            Arrays.fill(roots, -1);
            Arrays.fill(ranks, -1);
        }

        int find(int x) {
            if (roots[x] == -1) return x;
            return roots[x] = find(roots[x]);
        }

        boolean union(int a, int b) {
            int rootA = find(a), rootB = find(b);

            if (rootA == rootB) { return true; } // already connected

            if (ranks[rootA] > ranks[rootB]) {
                roots[rootB] = rootA;
            } else if (ranks[rootA] < ranks[rootB]) {
                roots[rootA] = rootB;
            } else {
                roots[rootA] = rootB;
                ranks[rootB]++;
            }
            return false;
        }
    }
}
