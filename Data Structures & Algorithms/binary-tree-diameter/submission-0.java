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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        depth(root, res);
        return res[0];
    }

    int depth(TreeNode node, int[] height) {
        if (node == null) return 0;
        int left = depth(node.left, height), right = depth(node.right, height);
        height[0] = Math.max(height[0], left + right);
        return 1 + Math.max(left, right);
    }
}
