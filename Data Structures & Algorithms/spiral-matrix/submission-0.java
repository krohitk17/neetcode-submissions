class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> sol = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;

        int fr = 0, fc = 0, lr = m-1, lc = n-1;

        while (fr <= lr && fc <= lc) {
            for (int i = fc; i <= lc; i++) {
                sol.add(matrix[fr][i]);
            }
            fr++;
            for (int j = fr; j <= lr; j++) {
                sol.add(matrix[j][lc]);
            }
            lc--;
            if (fr > lr || fc > lc) break;
            for (int i = lc; i >= fc; i--) {
                sol.add(matrix[lr][i]);
            }
            lr--;
            for (int j = lr; j >= fr; j--) {
                sol.add(matrix[j][fc]);
            }
            fc++;
        }

        return sol;
    }
}
