/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        }

        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    private Node dfs(Node cur, Map<Node, Node> map){
        if(map.containsKey(cur)){
            return map.get(cur);
        }

        Node clone = new Node(cur.val);
        map.put(cur, clone);

        for(Node n : cur.neighbors){
            clone.neighbors.add(dfs(n, map));
        }

        return map.get(cur);
    }
}