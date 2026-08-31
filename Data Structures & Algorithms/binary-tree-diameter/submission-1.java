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
        int[] size = new int[1];
        dfs(root,size);
        return size[0];
    }

    private int dfs(TreeNode node, int[] size){
        if(node == null) return 0;

        int left = dfs(node.left, size);
        int right = dfs(node.right, size);

        size[0] = Math.max(size[0], left + right);
        return Math.max(left, right) + 1;
    }
}
