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
    int global;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        global = root.val;
        dfs(root);
        return global;
    }

    private int dfs(TreeNode node){
        if(node == null) return 0;

        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        global = Math.max(global, left + right + node.val);

        return Math.max(left, right) + node.val;
    }
}
