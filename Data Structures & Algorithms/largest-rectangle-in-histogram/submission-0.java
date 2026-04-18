class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, sol = 0;

        for (int i = 0; i < n; i++) {
            int h = heights[i];
            int l = i, r = i;
            while (l >= 0 && heights[l] >= h) l--;
            while (r < n && heights[r] >= h) r++;
            // System.out.println(h + " " + l + " " + r);
            sol = Math.max(sol, (r-l-1)*h);
        }

        return sol;
    }
}
