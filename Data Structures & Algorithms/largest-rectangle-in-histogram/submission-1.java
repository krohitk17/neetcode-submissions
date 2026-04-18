class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, sol = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() &&
                (i == n || heights[i] <= heights[stack.peek()])) {
                int h = heights[stack.pop()], w = stack.isEmpty() ? i : i - stack.peek() - 1;
                sol = Math.max(sol, h*w);
            }
            stack.push(i);
        }

        return sol;
    }
}
