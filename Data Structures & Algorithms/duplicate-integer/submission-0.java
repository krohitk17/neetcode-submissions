class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i : nums) set.add(i);

        return set.size() != nums.length;
    }
}