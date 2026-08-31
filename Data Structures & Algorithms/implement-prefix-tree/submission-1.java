class TreeNode {
    Map<Character, TreeNode> children;
    boolean end;

    public TreeNode(){
        children = new HashMap<>();
        end = false;
    }
}

class PrefixTree {

    TreeNode root;

    public PrefixTree() {
        this.root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode cur = root;
        for(Character c : word.toCharArray()){
            if(!cur.children.containsKey(c)){
                cur.children.put(c, new TreeNode());
            }
            cur = cur.children.get(c);
        }
        cur.end = true;
    }

    public boolean search(String word) {
        TreeNode cur = root;
        for(Character c : word.toCharArray()){
            if(!cur.children.containsKey(c)) return false;
            cur = cur.children.get(c);
        }
        return cur.end;
    }

    public boolean startsWith(String prefix) {
        TreeNode cur = root;
        for(Character c : prefix.toCharArray()){
            if(!cur.children.containsKey(c)) return false;
            cur = cur.children.get(c);
        }
        return true;
    }
}
