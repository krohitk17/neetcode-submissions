class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] sol = new int[n];
        sol[0] = 1;
        for (int i = 1; i < n; i++) {
            sol[i] = sol[i-1]*nums[i-1];
        }
        int temp = 1;
        for (int i = n-1; i >= 0; i--) {
            sol[i] = sol[i]*temp;
            temp*=nums[i];
        }

        return sol;
    }
}  
