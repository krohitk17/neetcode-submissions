class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> indices = new HashMap<>();

        for (int i = 0; i < s.length(); i++) indices.put(s.charAt(i), i);

        List<Integer> sol = new ArrayList<>();
        for (int i = 0, l = 0, r = 0; i < s.length(); i++) {
            r = Math.max(r, indices.get(s.charAt(i)));
            if (i == r) {
                sol.add(r - l + 1);
                l = i+1;
            }
        }
        return sol;
    }
}
