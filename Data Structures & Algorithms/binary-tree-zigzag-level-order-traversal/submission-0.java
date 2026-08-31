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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean revesre = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> lvl = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();

                if (!revesre) {
                    lvl.add(cur.val);
                } else {
                    lvl.add(0, cur.val);
                }

                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            revesre = !revesre;
            res.add(lvl);
        }
        return res;
    }
}