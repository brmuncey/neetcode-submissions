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

    int res;
    int count;
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
        if(k == count){
            res = node.val;
            return;
        }
        dfs(node.right, k);
    }
}
