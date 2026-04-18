class Solution {
    int[][] adj;
    int sol = Integer.MAX_VALUE;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        adj = new int[n][n];
        for (int[] f : flights) adj[f[0]][f[1]] = f[2];
        dfs(src, dst, 0, 0, k);
        if (sol == Integer.MAX_VALUE) return -1;
        return sol;
    }

    void dfs(int from, int to, int cost, int stops, int maxStops) {
        System.out.println(from + " " + to + " " + cost + " " + stops + " " + maxStops);
        if (from == to) {
            if (cost < sol) sol = cost;
            return;
        }
        if (stops > maxStops) return;
        for (int i = 0; i < adj.length; i++) {
            System.out.println(adj[from][i]);
            if (adj[from][i] > 0) {
                dfs(i, to, cost + adj[from][i], stops + 1, maxStops);
            }
        }
    }
}
