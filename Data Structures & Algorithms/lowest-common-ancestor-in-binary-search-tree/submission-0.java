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
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null){
            return node;
        }

        if(node.val == p.val){
            return p;
        }

        if(node.val == q.val){
            return q;
        }

        TreeNode left = lowestCommonAncestor(node.left, p, q);
        TreeNode right = lowestCommonAncestor(node.right, p, q);

        if(left == null){
            return right;
        }

        if(right == null){
            return left;
        }

        return node;

    }
}
