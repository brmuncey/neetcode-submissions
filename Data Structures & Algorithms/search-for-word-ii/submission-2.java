class TrieNode {
    Map<Character, TrieNode> children;
    String word;

    public TrieNode(){
        children = new HashMap<>();
        word = "";
    }
}

class Solution {

    TrieNode root;

    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        populate(words, root);

        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        List<String> result = new ArrayList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dfs(board, root, i, j, result, visited);
            }
        }
        return result;
    }

    private void dfs(char[][] board, TrieNode node, int i, int j, List<String> result, boolean[][] visited){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;
        if(visited[i][j] || !node.children.containsKey(board[i][j])) return;

        TrieNode nextNode = node.children.get(board[i][j]);
        if(!nextNode.word.equals("")){
            result.add(nextNode.word);
            nextNode.word = "";
        }
        
        visited[i][j] = true;
        dfs(board, nextNode, i+1, j, result, visited);
        dfs(board, nextNode, i-1, j, result, visited);
        dfs(board, nextNode, i, j+1, result, visited);
        dfs(board, nextNode, i, j-1, result, visited);
        visited[i][j] = false;
    }
    
    private void populate(String[] words, TrieNode root){
        TrieNode cur = root;
        for(String s : words){
            cur = root;
            for(Character c : s.toCharArray()){
                if(!cur.children.containsKey(c)) cur.children.put(c, new TrieNode());
                cur = cur.children.get(c);
            }
            cur.word = s;
        }
    }
}