class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length, n=grid[0].length, time=0, fresh=0;

        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                } else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[][] dirs = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
        while(!queue.isEmpty() && fresh > 0){
            int s = queue.size();
            for(int i=0; i<s; i++){
                int[] cur = queue.poll();
                for(int[] d : dirs){
                    int row = d[0] + cur[0], col = d[1] + cur[1];
                    if(row < 0 || col < 0 || row >= m || col >= n || grid[row][col] != 1) continue;
                    grid[row][col] = 2;
                    queue.add(new int[] {row, col});
                    fresh--;
                }
            }
            time++;
        }

        return fresh == 0 ? time : -1;
    }
}