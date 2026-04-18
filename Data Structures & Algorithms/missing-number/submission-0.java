class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length, xor = 0;
        for (int i = 1; i <= n; i++) xor ^= nums[i-1]^i;
        return xor;
    }
}