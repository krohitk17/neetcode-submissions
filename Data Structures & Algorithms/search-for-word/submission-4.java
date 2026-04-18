class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (recurse(i, j, 0, word, board)) return true;
        return false;
    }

    boolean recurse(int i, int j, int k, String word, char[][] board) {
        if (k == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;
        boolean res = board[i][j] == word.charAt(k);
        if (res && k < word.length()) {
            board[i][j] = '.';
            res = res && (recurse(i+1, j, k+1, word, board)
                    || recurse(i-1, j, k+1, word, board)
                    || recurse(i, j+1, k+1, word, board)
                    || recurse(i, j-1, k+1, word, board));
            board[i][j] = word.charAt(k);
        }
        return res;
    }
}
