class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length, n=grid[0].length, count=0;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, boolean[][] visited){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;
        if(visited[i][j] || grid[i][j] == '0') return;

        visited[i][j] = true;

        dfs(grid, i+1, j, visited);
        dfs(grid, i-1, j, visited);
        dfs(grid, i, j+1, visited);
        dfs(grid, i, j-1, visited);
    }
}
