class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n+1)/2; i++)
            for (int j = 0; j < n/2; j++)
                this.swap(matrix, -1001, i, j);
    }

    void swap(int[][] matrix, int x, int i, int j) {
        System.out.println(matrix[i][j]);
        int cell = matrix[i][j];
        if (cell == -1001) {
            matrix[i][j] = x;
            return;
        }
        matrix[i][j] = -1001;
        swap(matrix, cell, j, matrix.length-1-i);
        if (x != -1001) matrix[i][j] = x;
    }
}
// 1  2  3  4
// 5  6  7  8
// 9  10 11 12
// 13 14 15 16

// 0 0 -> 0 n-1
// 0 1 -> 1 n-1
// 0 2 -> 2 n-1
// 0 3 -> m-1 n - 1
// 1 0 -> 0 n-2
// 1 1 -> 1 n-2
// 1 2 -> 2 n-2
// 1 3 -> m-1 n-2