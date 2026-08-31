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

    int res = -1;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    private int dfs(TreeNode node, int k){
        if(node == null){
            return 0;
        }

        int left = 1 + dfs(node.left, k);

        if(left == k){
            res = node.val;
        }

        return left + dfs(node.right, k - left);
    }
}
