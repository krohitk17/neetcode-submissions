class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for (int j = 0; j < n; j++) {
            recurse(board, 0, j);
            recurse(board, m-1, j);
        }
        for (int i = 0; i < m; i++) {
            recurse(board, i, 0);
            recurse(board, i, n-1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '*') board[i][j] = 'O';
            }
        }
    }

    void recurse(char[][] board, int i, int j) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0) return;
        if (board[i][j] != 'O') return;
        board[i][j] = '*';
        recurse(board, i+1, j);
        recurse(board, i-1, j);
        recurse(board, i, j+1);
        recurse(board, i, j-1);
    }
}