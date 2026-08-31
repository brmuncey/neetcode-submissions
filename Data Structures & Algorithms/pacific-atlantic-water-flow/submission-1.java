class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length, n = heights[0].length;

        boolean[][] pacific = new boolean[m][n], atlantic = new boolean[m][n];

        for(int i=0; i<m; i++){
            dfs(heights, pacific, i, 0, 0);
            dfs(heights, atlantic, i, n-1, 0);
        }

        for(int i=0; i<n; i++){
            dfs(heights, pacific, 0, i, 0);
            dfs(heights, atlantic, m-1, i, 0);
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(pacific[i][j] && atlantic[i][j]) result.add(Arrays.asList(i,j));
            }
        }
        return result;
    }

    private void dfs(int[][] heights, boolean[][] ocean, int i, int j, int cur){
        if(i < 0 || j < 0 || i >= heights.length || j >= heights[0].length) return;
        if(ocean[i][j] || heights[i][j] < cur) return;
        ocean[i][j] = true;

        dfs(heights, ocean, i+1, j, heights[i][j]);
        dfs(heights, ocean, i-1, j, heights[i][j]);
        dfs(heights, ocean, i, j+1, heights[i][j]);
        dfs(heights, ocean, i, j-1, heights[i][j]);
    }
}
