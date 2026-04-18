/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        return depth(root)[0] == 1;
    }

    int[] depth(TreeNode node) {
        if (node == null) return new int[]{ 1, 0 };

        int[] left = depth(node.left), right = depth(node.right);

        return new int[]{ (left[0] == 1 && right[0] == 1 && Math.abs(left[1] - right[1]) <= 1) ? 1 : 0, 1 + Math.max(left[1], right[1]) };
    }
}
