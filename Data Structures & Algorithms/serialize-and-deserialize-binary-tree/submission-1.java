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
        dfsS(root, sb);
        return sb.toString();   
    }

    private void dfsS(TreeNode node, StringBuilder sb){
        if(node == null){
            sb.append("N,");
            return;
        }
        sb.append(node.val).append(",");
        dfsS(node.left, sb);
        dfsS(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        int[] i = new int[]{0};
        return dfsD(arr, i);
    }

    private TreeNode dfsD(String[] arr, int[] i){
        if(arr[i[0]].equals("N")) {
            i[0]++;
            return null;
        }
        TreeNode cur = new TreeNode(Integer.parseInt(arr[i[0]++]));
        cur.left = dfsD(arr, i);
        cur.right = dfsD(arr, i);
        return cur;
    }
}
