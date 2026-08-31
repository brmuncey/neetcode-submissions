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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            List<Integer> lvl = new ArrayList<>();
            int n = queue.size();
            for(int i=0; i<n; i++){
                TreeNode cur = queue.poll();
                lvl.add(cur.val);

                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
            res.add(lvl);
        }

        return res;
    }
}
