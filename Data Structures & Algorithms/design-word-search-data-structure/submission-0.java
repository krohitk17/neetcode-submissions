class WordDictionary {

    class Trie {
        Trie[] children;
        boolean isEnd;

        public Trie() {
            this.children = new Trie[26];
            this.isEnd = false;
        }
    }

    Trie head;

    public WordDictionary() {
        this.head = new Trie();
    }

    public void addWord(String word) {
        Trie curr = head;
        for (int i = 0; i < word.length(); i++) {
            char x = word.charAt(i);
            int ind = x - 'a';
            if (curr.children[ind] == null) curr.children[ind] = new Trie();
            curr = curr.children[ind];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        return this.recurse(head, word);
    }

    public boolean recurse(Trie curr, String word) {
        if (curr == null) return false;

        for (int i = 0; i < word.length(); i++) {
            char x = word.charAt(i);
            if (x == '.') {
                for (Trie next : curr.children)
                    if (this.recurse(next, word.substring(i+1, word.length())))
                        return true;
                return false;
            }
            int ind = x - 'a';
            if (curr.children[ind] == null) return false;
            curr = curr.children[ind];
        }

        return curr.isEnd;
    }
}
