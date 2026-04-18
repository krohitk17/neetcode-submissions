class Solution {
    class DisjointSet {
        int[] parent;

        public DisjointSet(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        public int find(int i) {
            if (this.parent[i] == i) return i;
            return this.find(this.parent[i]);
        }

        public void union(int x, int y) {
            this.parent[this.find(x)] = this.find(y);
        }
    }

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n-1) return false;
        DisjointSet unionFind = new DisjointSet(n);
        for (int[] edge : edges) unionFind.union(edge[0], edge[1]);
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (root == -1) root = unionFind.find(i);
            else if (unionFind.find(i) != root) return false;
        }
        return true;
    }
}
