class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i + 1) continue;

            int index = nums[i] - 1;

            if (nums[i] == nums[index])return nums[i];

            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;

            i--;
        }
        return -1;
    }
}
