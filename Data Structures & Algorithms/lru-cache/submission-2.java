class Node {
    int key;
    int val;

    Node prev;
    Node next;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    
    int cap;
    Map<Integer, Node> map;

    Node left;
    Node right;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }

    private void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insert(Node node) {
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            remove(map.get(key));
        }

        Node node = new Node(key, value);
        map.put(key, node);
        insert(node);

        if(map.size() > cap){
            Node lru = this.left.next;
            remove(lru);
            map.remove(lru.key);
        }
    }
}
