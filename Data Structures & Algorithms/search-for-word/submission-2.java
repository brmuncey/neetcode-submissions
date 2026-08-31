class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length, n=board[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(dfs(board, visited, i, j, 0, word)) return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int i, int j, int cur, String word){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if(visited[i][j] || board[i][j] != word.charAt(cur)) return false;
        if(cur == word.length() - 1) return true;
        visited[i][j] = true;

        boolean result = (dfs(board, visited, i+1, j, cur+1, word) ||
                            dfs(board, visited, i-1, j, cur+1, word) ||
                            dfs(board, visited, i, j+1, cur+1, word) ||
                            dfs(board, visited, i, j-1, cur+1, word));
        visited[i][j] = false;

        return result;
    }
}
