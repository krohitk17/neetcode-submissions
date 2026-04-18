class Solution {
    public int trap(int[] height) {
        if (height.length == 0) return 0;

        int res = 0, n = height.length, l = 0, r = n-1, leftMax = height[l], rightMax = height[r];

        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }

        return res;
    }
}
