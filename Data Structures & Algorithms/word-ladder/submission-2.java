class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord) || beginWord.equals(endWord)) return 0;

        Set<String> remove = new HashSet<>();

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        int sol = 0;
        while (!q.isEmpty()) {
            sol++;
            for (int i = q.size(); i > 0; i--) {
                String a = q.poll();
                if (a.equals(endWord)) return sol;
                for (String b : words) {
                    if (compare(a, b)) {
                        remove.add(b);
                        q.offer(b);
                    }
                }
                for (String x : remove) words.remove(x);
                remove.clear();
            }
        }
        return 0;
    }

    boolean compare(String a, String b) {
        boolean diff = true;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (!diff) return false;
                diff = false;
            }
        }
        return true;
    }
}
