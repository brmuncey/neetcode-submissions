class Node {
    Map<Character, Node> children;
    boolean end;

    public Node(){
        children = new HashMap<>();
        end = false;
    }
}

class PrefixTree {

    Node root;

    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        Node cur = root;
        for(Character c : word.toCharArray()){
            if(!cur.children.containsKey(c)) cur.children.put(c, new Node());
            cur = cur.children.get(c);
        }
        cur.end = true;
    }

    public boolean search(String word) {
        Node cur = root;
        for(Character c : word.toCharArray()){
            if(!cur.children.containsKey(c)) return false;
            cur = cur.children.get(c);
        }
        return cur.end;
    }

    public boolean startsWith(String prefix) {
        Node cur = root;
        for(Character c : prefix.toCharArray()){
            if(!cur.children.containsKey(c)) return false;
            cur = cur.children.get(c);
        }
        return true;
    }
}
