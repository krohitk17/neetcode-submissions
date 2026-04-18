class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int[] sol = new int[2];
        for (int i = 0; i < n; i++) map.put(nums[i], i);

        for (int i = 0; i < n; i++) {
            if (map.containsKey(target-nums[i]) && map.get(target-nums[i]) != i) {
                sol[0] = i;
                sol[1] = map.get(target-nums[i]);
                return sol;
            }
        }

        return sol;
    }
}
