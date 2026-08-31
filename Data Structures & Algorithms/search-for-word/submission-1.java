class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(dfs(board, word, visited, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, int x){
        if(x == word.length()) return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if(visited[i][j] || board[i][j] != word.charAt(x)) return false;
        visited[i][j] = true;
        x++;
        boolean res = dfs(board, word, visited, i+1, j, x) 
                    || dfs(board, word, visited, i-1, j, x) 
                    || dfs(board, word, visited, i, j+1, x) 
                    ||dfs(board, word, visited, i, j-1, x);
        visited[i][j] = false;
        return res;
    }
}
