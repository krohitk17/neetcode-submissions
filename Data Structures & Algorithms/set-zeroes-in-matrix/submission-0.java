class Solution {
    public void setZeroes(int[][] matrix) {
        boolean row = false, col = false;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) row = true;
                    if (j == 0) col = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (matrix[i][0] == 0) {
                    if (i == 0 && !row) continue;
                    matrix[i][j] = 0;
                }
                if (matrix[0][j] == 0) {
                    if (j == 0 && !col) continue;
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
