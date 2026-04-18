class Solution {
    class Trie {
        Trie[] children;
        String word;

        public Trie() {
            this.children = new Trie[26];
            this.word = null;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie head = new Trie();
        for (int j = 0; j < words.length; j++) {
            String word = words[j];
            Trie curr = head;
            for (int i = 0; i < word.length(); i++) {
                char x = word.charAt(i);
                int ind = x - 'a';
                if (curr.children[ind] == null) curr.children[ind] = new Trie();
                curr = curr.children[ind];
            }
            curr.word = word;
        }

        List<String> sol = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                this.recurse(board, i, j, head, sol);
            }
        }

        return sol;
    }

    void recurse(char[][] board, int i, int j, Trie curr, List<String> sol) {
        if (curr == null || i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;
        char c = board[i][j];
        if (c == '.' || curr.children[c - 'a'] == null) return;

        curr = curr.children[c - 'a'];
        if (curr.word != null) {
            sol.add(curr.word);
            curr.word = null;
        }

        board[i][j] = '.';
        this.recurse(board, i+1, j, curr, sol);
        this.recurse(board, i-1, j, curr, sol);
        this.recurse(board, i, j-1, curr, sol);
        this.recurse(board, i, j+1, curr, sol);
        board[i][j] = c;
    }
}
