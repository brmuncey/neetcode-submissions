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
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        int[] res = new int[] {root.val};
        dfs(root, res);
        return res[0];
    }

    private int dfs(TreeNode node, int[] res){
        if(node == null) return 0;

        int left = Math.max(0, dfs(node.left, res));
        int right = Math.max(0, dfs(node.right, res));

        res[0] = Math.max(res[0], left + right + node.val);

        return Math.max(left, right) + node.val;
    }
}
