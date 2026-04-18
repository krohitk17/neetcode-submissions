class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int sol = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 1)
                    sol = Math.max(sol, this.recurse(grid, i, j));
        }
        return sol;
    }

    int recurse(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return 0;
        if (grid[i][j] == 0) return 0;

        grid[i][j] = 0;
        return 1
            + recurse(grid, i+1, j)
            + recurse(grid, i, j+1)
            + recurse(grid, i-1, j)
            + recurse(grid, i, j-1);
    }
}