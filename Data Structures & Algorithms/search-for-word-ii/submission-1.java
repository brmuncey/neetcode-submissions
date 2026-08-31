class TrieNode {
    Map<Character, TrieNode> children;
    String word;

    public TrieNode() {
        children = new HashMap<>();
        word = null;
    }
}


class Solution {

    TrieNode root;

    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        populate(words);

        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        List<String> result = new ArrayList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dfs(board, visited, result, i, j, root);
            }
        }
        return result;
    }

    public void dfs(char[][] board, boolean[][] visited, List<String> result, int i, int j, TrieNode node){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;
        if(visited[i][j]) return;
        if(!node.children.containsKey(board[i][j])) return;
        node = node.children.get(board[i][j]);

        if(node.word != null){
            result.add(node.word);
            node.word = null;
        }

        visited[i][j] = true;

        dfs(board, visited, result, i+1, j, node);
        dfs(board, visited, result, i-1, j, node);
        dfs(board, visited, result, i, j+1, node);
        dfs(board, visited, result, i, j-1, node);

        visited[i][j] = false;
    }

    private void populate(String[] words){
        for(String s : words){
            TrieNode cur = root;
            for(Character c : s.toCharArray()){
                if(!cur.children.containsKey(c)){
                    cur.children.put(c, new TrieNode());
                }
                cur = cur.children.get(c);
            }
            cur.word = s;
        }
    }
}