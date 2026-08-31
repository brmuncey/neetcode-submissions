class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int max = 0;
        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid[i].length ; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    max = Math.max(max, dfs(grid, i, j, visited));
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length){
            return 0;
        }

        if(grid[i][j] == 0 || visited[i][j]){
            return 0;
        }

        visited[i][j] = true;

        int c = 1;
        c += dfs(grid, i+1, j, visited);
        c += dfs(grid, i-1, j, visited);
        c += dfs(grid, i, j+1, visited);
        c += dfs(grid, i, j-1, visited);

        return c;
    }
}
