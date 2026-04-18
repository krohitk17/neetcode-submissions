class Solution {
    class Trie {
        Trie[] children;
        int wordInd;

        public Trie() {
            this.children = new Trie[26];
            this.wordInd = -1;
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
            curr.wordInd = j;
        }

        List<String> sol = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                this.recurse(board, i, j, head, words, sol);
            }
        }

        return sol;
    }

    void recurse(char[][] board, int i, int j, Trie curr, String[] words, List<String> sol) {
        if (curr == null || i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;
        char c = board[i][j];
        if (c == '.' || curr.children[c - 'a'] == null) return;

        curr = curr.children[c - 'a'];
        if (curr.wordInd != -1) {
            sol.add(words[curr.wordInd]);
            curr.wordInd = -1;
        }

        board[i][j] = '.';
        this.recurse(board, i+1, j, curr, words, sol);
        this.recurse(board, i-1, j, curr, words, sol);
        this.recurse(board, i, j-1, curr, words, sol);
        this.recurse(board, i, j+1, curr, words, sol);
        board[i][j] = c;
    }
}
