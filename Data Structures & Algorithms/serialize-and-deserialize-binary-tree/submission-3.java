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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode node, StringBuilder sb){
        if(node == null){
            sb.append("N,");
            return;
        }
        sb.append(node.val).append(",");
        serialize(node.left, sb);
        serialize(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        int[] i = new int[]{0};
        return build(strs, i);
    }

    private TreeNode build(String[] strs, int[] i){
        if(strs[i[0]].equals("N")){
            i[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(strs[i[0]++]));
        node.left = build(strs, i);
        node.right = build(strs, i);
        return node;
    }
}
