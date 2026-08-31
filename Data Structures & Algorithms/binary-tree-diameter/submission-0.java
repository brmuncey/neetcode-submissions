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
        if(root == null){
            return 0;
        }
        int[] size = new int[] {0};
        dfs(root, size);
        return size[0];
    }

    private int dfs(TreeNode node, int[] h){
        if(node == null){
            return 0;
        }

        int left = dfs(node.left, h);
        int right = dfs(node.right, h);

        h[0] = Math.max(h[0], left + right);

        return Math.max(left, right) + 1;
    }
}
