class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> cache = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.'
                    && (!cache.add(String.format("%d{%c}", j, board[i][j]))
                        || !cache.add(String.format("{%c}%d", board[i][j], i))
                        || !cache.add(String.format("%d{%c}%d", i/3, board[i][j], j/3)))) {
                    // System.out.println(i + " " + board[i][j] + " ");
                    return false;
                }
            }
        }

        return true;
    }
}
