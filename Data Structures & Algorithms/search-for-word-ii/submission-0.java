class TrieNode {

    Map<Character, TrieNode> children;
    String word;

    public TrieNode(){
        children = new HashMap<>();
    }
}

class Solution {

    TrieNode root;

    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        TrieNode cur = root;
        for(String s : words){
            add(s, cur);
        }

        List<String> res = new ArrayList<>();
        int m = board.length, n=board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dfs(board, visited, i, j, res, cur);
            }
        }
        return res;
    }

    private void dfs(char[][] board, boolean[][] visited, int i, int j, List<String> res, TrieNode cur){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;
        if(visited[i][j]) return;
        if(!cur.children.containsKey(board[i][j])) return;
        cur = cur.children.get(board[i][j]);

        if(cur.word != null){
            res.add(cur.word);
            cur.word = null;
        }

        visited[i][j] = true;

        dfs(board, visited, i+1, j, res, cur);
        dfs(board, visited, i-1, j, res, cur);
        dfs(board, visited, i, j+1, res, cur);
        dfs(board, visited, i, j-1, res, cur);

        visited[i][j] = false;
    }

    private void add(String s, TrieNode cur){
        for(int i=0; i<s.length(); i++){
            if(!cur.children.containsKey(s.charAt(i))){
                cur.children.put(s.charAt(i), new TrieNode());
            }
            cur = cur.children.get(s.charAt(i));
        }
        cur.word = s;
    }
}
