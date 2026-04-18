class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // convert words to set
        Set<String> words = new HashSet<>(wordList);
        // if endWord isnt in words or begin and end are same
        if (!words.contains(endWord) || beginWord.equals(endWord)) return 0;
        
        // another set to store strings which have been checked
        Set<String> remove = new HashSet<>();

        // queue to store possible transforms
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        // count each transform
        int sol = 0;
        while (!q.isEmpty()) {
            // increment for each transform
            sol++;
            for (int i = q.size(); i > 0; i--) {
                // transformed to a
                String a = q.poll();
                // transformed to end string
                if (a.equals(endWord)) return sol;
                // find all next possible transforms
                for (String b : words) {
                    if (compare(a, b)) {
                        // remove strings added in queue from words
                        remove.add(b);
                        q.offer(b);
                    }
                }
                // remove strings added in queue from words
                for (String x : remove) words.remove(x);
                // clear remove set for next transform
                remove.clear();
            }
        }
        // if queue gets empty; transform impossible
        return 0;
    }

    // check that both strings differ by one character only
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
