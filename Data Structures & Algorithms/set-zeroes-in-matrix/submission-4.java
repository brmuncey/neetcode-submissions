class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n=matrix[0].length;
        boolean[] rows = new boolean[n], cols = new boolean[m];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    cols[i] = true;
                    rows[j] = true;
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(cols[i] || rows[j]) matrix[i][j] = 0;
            }
        }
    }
}
