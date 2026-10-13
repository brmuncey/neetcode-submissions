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

    private int count;
    private int res;

    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        res = 0;
        dfs(root, k);
        return res;
    }

    private void dfs(TreeNode node, int k){
        if(node == null) return;

        dfs(node.left, k);
        count++;
        if(count == k) {
            res = node.val;
            return;
        }
        dfs(node.right, k);
    }
}
