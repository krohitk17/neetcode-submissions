class Solution {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();

        int m = grid.length, n = grid[0].length;
        
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) fresh++;
                if (grid[i][j] == 2) q.offer(new int[]{i, j});
            }
        }

        int sol = 0;
        while (fresh > 0 && !q.isEmpty()) {
            int currQ = q.size();
            for (int i = 0; i < currQ; i++) {
                int[] rot = q.poll();
                for (int[] dir : this.directions) {
                    int row = rot[0] + dir[0], col = rot[1] + dir[1];
                    if (row >= 0 && row < m && col >= 0 && col < n
                            && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        q.offer(new int[]{row, col});
                        fresh--;
                    }
                }
            }
            sol++;
        }

        return fresh == 0 ? sol : -1;
    }
}
