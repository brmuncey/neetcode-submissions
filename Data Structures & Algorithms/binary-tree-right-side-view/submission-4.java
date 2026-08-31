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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int k = queue.size();
            TreeNode cur = null;
            for(int i=0; i<k; i++){
                cur = queue.poll();
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
            result.add(cur.val);
        }
        return result;
    }
}
