class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length, n=board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(dfs(board, visited, word, 0, i, j)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, String word, int cur, int i, int j){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if(visited[i][j] || board[i][j] != word.charAt(cur)) return false;
        if(cur == word.length() - 1) return true;
        visited[i][j] = true;

        boolean res = dfs(board, visited, word, cur + 1, i+1, j) ||
                      dfs(board, visited, word, cur + 1, i-1, j) ||
                      dfs(board, visited, word, cur + 1, i, j+1) ||
                      dfs(board, visited, word, cur + 1, i, j-1);
        visited[i][j] = false;

        return res;
    }
}
