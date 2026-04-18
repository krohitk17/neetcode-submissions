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

        public void union(int i, int j) {
            this.parent[this.find(i)] = this.find(j);
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet dsu = new DisjointSet(edges.length);
        int[] sol = new int[2];
        for (int[] edge : edges) {
            int u = edge[0]-1, v = edge[1]-1;
            if (dsu.find(v) == dsu.find(u)) sol = edge;
            dsu.union(v, u);
        }
        return sol;
    }
}
