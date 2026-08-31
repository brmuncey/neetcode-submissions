class TrieNode {

    Map<Character, TrieNode> children;
    int count;
    boolean end;

    public TrieNode(){
        children = new HashMap<>();
        count=0;
    }

}

class Solution {

    TrieNode root;

    public String longestCommonPrefix(String[] strs) {
        root = new TrieNode();
        int k = strs.length;
        for(String s : strs){
            add(s);
        }

        int max = 0;

        for(String s : strs){
            max = Math.max(max, search(s, k));
        }

        return strs[0].substring(0, max);
    }

    private int search(String s, int k){
        TrieNode cur = root;

        int i = 0;
        for(char c : s.toCharArray()){
            cur = cur.children.get(c);
            if(cur.count != k) return i;
            i++;
        }
        return i;
    }

    private void add(String s){
        TrieNode cur = root;
        for(char c : s.toCharArray()){
            if(!cur.children.containsKey(c)) cur.children.put(c, new TrieNode());
            cur = cur.children.get(c);
            cur.count++;
        }
    }
}