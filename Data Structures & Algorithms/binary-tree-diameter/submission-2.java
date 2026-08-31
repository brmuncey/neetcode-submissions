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
        int[] d = new int[1];
        dfs(root, d);
        return d[0];
    }

    private int dfs(TreeNode node, int[] d){
        if(node == null) return 0;

        int left = dfs(node.left, d);
        int right = dfs(node.right, d);

        d[0] = Math.max(d[0], left + right);

        return Math.max(left, right) + 1;
    }
}
