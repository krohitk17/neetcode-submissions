class Solution {
    public int maxSubArray(int[] nums) {
        int sol = Integer.MIN_VALUE, curr = 0;
        for (int i = 0; i < nums.length; i++) {
            curr += nums[i];
            sol = Math.max(sol, curr);
            if (curr < 0) curr = 0;
        }
        return sol;
    }
}
