class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n+1)/2; i++)
            for (int j = 0; j < n/2; j++)
                this.swap(matrix, -1001, i, j);
    }

    void swap(int[][] matrix, int x, int i, int j) {
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