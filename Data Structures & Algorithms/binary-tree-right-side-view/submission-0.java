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
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            TreeNode temp = null;
            for(int i=0 ; i<size ; i++){
                TreeNode cur = queue.poll();

                if(cur.left != null){
                    queue.add(cur.left);
                }

                if(cur.right != null){
                    queue.add(cur.right);
                }

                temp = cur;
            }

            result.add(temp.val);
        }

        return result;
    }
}
