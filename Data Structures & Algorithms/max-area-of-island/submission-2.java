class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length, n=grid[0].length, max=0;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    max = Math.max(max, dfs(grid, visited, i, j));
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, boolean[][] visited, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return 0;
        if(visited[i][j] || grid[i][j] != 1) return 0;
        visited[i][j] = true;

        int c = 1;
        c += dfs(grid, visited, i+1, j);
        c += dfs(grid, visited, i-1, j);
        c += dfs(grid, visited, i, j+1);
        c += dfs(grid, visited, i, j-1);
        return c;
    }
}
