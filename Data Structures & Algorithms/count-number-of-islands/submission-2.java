class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length, n=grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    count++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, boolean[][] visited, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;
        if(visited[i][j] || grid[i][j] == '0') return;

        visited[i][j] = true;

        dfs(grid, visited, i+1, j);
        dfs(grid, visited, i-1, j);
        dfs(grid, visited, i, j+1);
        dfs(grid, visited, i, j-1);
    }
}
