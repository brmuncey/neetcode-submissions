class TrieNode {

    Map<Character, TrieNode> children;
    boolean end;

    public TrieNode(){
        children = new HashMap<>();
        end = false;
    }
}

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            if(!cur.children.containsKey(c)) cur.children.put(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.end = true;
    }

    public boolean search(String word) {
        return dfs(word, root);
    }

    private boolean dfs(String word, TrieNode node){
        TrieNode cur = node;

        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(c == '.') {
                for(TrieNode child : cur.children.values()){
                    if(dfs(word.substring(i+1), child)) return true;
                }
                return false;
            } else {
                if(!cur.children.containsKey(c)) return false;
                cur = cur.children.get(c);
            }
        }

        return cur.end;
    }
}
