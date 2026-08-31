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
    public int maxDepth(TreeNode root) {
        return max(root, 0);
    }

    private int max(TreeNode node, int height){
        if(node == null){
            return 0;
        }

        int left = max(node.left, height + 1);
        int right = max(node.right, height + 1);

        return Math.max(left, right) + 1;
    }
}
