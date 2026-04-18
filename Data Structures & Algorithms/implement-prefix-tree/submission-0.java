class PrefixTree {

    class Trie {
        char val;
        Map<Character, Trie> children;
        boolean isEnd;

        public Trie() {
            this.children = new HashMap<>();
            this.isEnd = false;
        }
    }

    Trie trie;

    public PrefixTree() {
        this.trie = new Trie();
    }

    public void insert(String word) {
        Trie curr = this.trie;
        for (int i = 0; i < word.length(); i++) {
            char x = word.charAt(i);
            curr = curr.children.computeIfAbsent(x, k -> new Trie());
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        Trie curr = this.trie;
        for (int i = 0; i < word.length(); i++) {
            char x = word.charAt(i);
            if (!curr.children.containsKey(x)) return false;
            curr = curr.children.get(x);
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie curr = this.trie;
        for (int i = 0; i < prefix.length(); i++) {
            char x = prefix.charAt(i);
            if (!curr.children.containsKey(x)) return false;
            curr = curr.children.get(x);
        }
        return true;
    }
}
