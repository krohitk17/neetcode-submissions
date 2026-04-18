class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(houserob(nums, 0), houserob(nums, 1));
    }

    int houserob(int[] nums, int start) {
        int rob1 = 0, rob2 = 0;
        for (int i = start; i < nums.length + start - 1; i++) {
            int temp = Math.max(nums[i] + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}
