class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length, n=grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int count=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, boolean[][] visited, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length) return;
        if(grid[i][j] != '1' || visited[i][j]) return;
        visited[i][j] = true;

        dfs(grid, visited, i+1, j);
        dfs(grid, visited, i-1, j);
        dfs(grid, visited, i, j+1);
        dfs(grid, visited, i, j-1);
    }
}
