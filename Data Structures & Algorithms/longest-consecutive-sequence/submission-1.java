class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i : nums) set.add(i);
        int max = 0;
        for (int i : nums) {
            int count = 0;
            if (!set.contains(i-1)) {
                count++;
                while (set.contains(i+1)) {
                    count++;
                    i++;
                }
            }
            max = Math.max(count, max);
        }

        return max;
    }
}
