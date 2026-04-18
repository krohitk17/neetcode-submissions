class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int max = 0, start = 0;

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= start) {
                start = map.get(s.charAt(i)) + 1;
                map.put(s.charAt(i), i);
            } else {
                max = Math.max(max, i - start + 1);
                map.put(s.charAt(i), i);
            }
        }

        return max;
    }
}
