class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;

        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        for(int i=0; i<m; i++){
            dfs(heights, pac, i, 0, 0);
            dfs(heights, atl, i, n-1, 0);
        }

        for(int i=0; i<n; i++){
            dfs(heights, pac, 0, i, 0);
            dfs(heights, atl, m - 1, i, 0);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(pac[i][j] && atl[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int[][] heights, boolean[][] visited, int i, int j, int prev){
        if(i < 0 || j < 0 || i >= heights.length || j >= heights[0].length) return;
        if(visited[i][j] || heights[i][j] < prev) return;
        visited[i][j] = true;

        dfs(heights, visited, i+1, j, heights[i][j]);
        dfs(heights, visited, i-1, j, heights[i][j]);
        dfs(heights, visited, i, j+1, heights[i][j]);
        dfs(heights, visited, i, j-1, heights[i][j]);
    }
}
