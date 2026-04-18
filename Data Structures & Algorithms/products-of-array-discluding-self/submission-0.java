class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n+2], suffix = new int[n+2], sol = new int[n];
        prefix[0] = 1;
        prefix[n+1] = 1;
        suffix[0] = 1;
        suffix[n+1] = 1;

        for (int i = 0; i < n; i++) {
            prefix[i+1] = prefix[i]*nums[i];
            suffix[n-i] = suffix[n-i+1]*nums[n-i-1];

            System.out.println(prefix[i+1] + " " + suffix[n-i]);
        }

        for (int i = 0; i < n; i++) {
            sol[i] = prefix[i]*suffix[i+2];
        }

        return sol;

    }
}  
