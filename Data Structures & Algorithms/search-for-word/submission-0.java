class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && word.charAt(0) == board[i][j]){
                    if(dfs(board, visited, word, i, j, 0)) return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] grid, boolean[][] visited, String word, int i, int j, int c){
        if(c == word.length()) return true;
        int m = grid.length, n = grid[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n) return false;
        if(visited[i][j] || grid[i][j] != word.charAt(c)) return false;
        c++;
        visited[i][j] = true;
        boolean res = (dfs(grid, visited, word, i+1, j, c) ||
                dfs(grid, visited, word, i-1, j, c) ||
                dfs(grid, visited, word, i, j+1, c) ||
                dfs(grid, visited, word, i, j-1, c));
        visited[i][j] = false;
        return res;
    }

}