class Solution {
    int INF = 2147483647; 

    public void islandsAndTreasure(int[][] grid) {
        int m=grid.length, n=grid[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0) dfs(grid, i, j, 0);
            }
        }
    }

    private void dfs(int[][] grid, int i, int j, int cur){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;
        if(grid[i][j] < cur || grid[i][j] == -1) return;
        
        grid[i][j] = cur;

        dfs(grid, i+1, j, cur+1);
        dfs(grid, i-1, j, cur+1);
        dfs(grid, i, j+1, cur+1);
        dfs(grid, i, j-1, cur+1);
    }
}
