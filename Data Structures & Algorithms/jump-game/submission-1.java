class Solution {
    public boolean canJump(int[] nums) {
        int currMax = nums[0], curr = 0;

        while (currMax < nums.length && curr <= currMax) {
            currMax = Math.max(currMax, nums[curr] + curr);
            curr++;
        }

        return currMax >= nums.length - 1;
    }
}
