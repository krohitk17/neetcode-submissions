class Solution {
    List<List<String>> board = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        bt(0, n, new ArrayList<>());
        return board;
    }

    void bt(int row, int n, List<String> curr) {
        if (row == n) {
            board.add(new ArrayList<>(curr));
            return;
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) str.append('.');
        for (int i = 0; i < n; i++) {
            if (isViable(row, i, curr)) {
                str.setCharAt(i, 'Q');
                curr.add(str.toString());
                bt(row+1, n, curr);
                curr.remove(curr.size()-1);
                str.setCharAt(i, '.');
            }
        }
    }

    boolean isViable(int i, int j, List<String> board) {
        for (int a = 0; a < board.size(); a++) {
            String row = board.get(a);
            for (int b = 0; b < row.length(); b++) {
                char piece = row.charAt(b);
                if (piece == 'Q' &&
                    (a == i || b == j || Math.abs(a-i) == Math.abs(b-j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
