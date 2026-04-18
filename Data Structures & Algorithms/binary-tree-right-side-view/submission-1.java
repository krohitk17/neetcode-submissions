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
    public List<Integer> rightSideView(TreeNode root) {
        return getRight(root);
    }

    List<Integer> getRight(TreeNode node) {
        if (node == null) return new ArrayList<>();
        List<Integer> left = getRight(node.left), right = getRight(node.right), sol = new ArrayList<>();
        sol.add(node.val);
        for (int i = 0; i < right.size(); i++) sol.add(right.get(i));
        for (int i = right.size(); i < left.size(); i++) sol.add(left.get(i));
        return sol;
    }
}
