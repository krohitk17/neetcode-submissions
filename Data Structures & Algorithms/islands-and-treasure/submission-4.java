class Solution {
    int INF = 2147483647;
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) q.offer(new int[]{i, j});
            }
        }

        while (!q.isEmpty()) {
            int[] point = q.poll();
            for (int[] d : this.directions) {
                int i = point[0] + d[0], j = point[1] + d[1];
                if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == this.INF) {
                    grid[i][j] = grid[point[0]][point[1]] + 1;
                    q.offer(new int[]{i, j});
                }
            }
        }
    }
}
