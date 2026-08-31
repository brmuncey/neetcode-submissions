class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        int t=-1;
        for(int i=0; i<m; i++){
            if(target >= matrix[i][0] && target <= matrix[i][n-1]){
                t = i;
            }
        }

        if(t < 0) return false;

        int l=0, r=n-1;
        while(l <= r){
            int mid = l + (r - l) / 2;

            if(target == matrix[t][mid]) return true;

            if(matrix[t][mid] < target){
                l++;
            } else {
                r--;
            }
        }
        return false;
    }
}
