class Solution {
    public int rob(int[] nums) {
        int n = nums.length, rob1 = 0, rob2 = 0;

        for (int i : nums) {
            int temp = Math.max(i + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;
    }
}
