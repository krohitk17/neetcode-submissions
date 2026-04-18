class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length, l = 0, r = n-1, sol = Integer.MIN_VALUE;
        while (l < r) {
            sol = Math.max(sol, Math.min(heights[l], heights[r])*(r-l));
            if (heights[l] < heights[r]) l++;
            else r--;
        }

        return sol;
    }
}
