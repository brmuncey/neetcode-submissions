class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix[0].length, l=0, r=n-1, t=-1;
        for(int i=0; i<matrix.length; i++){
            if(matrix[i][0] <= target && matrix[i][r] >= target) {
                t = i;
                break;
            }
        }

        if(t < 0) return false;

        while(l <= r){
            int m = l + (r-l)/2;

            if(matrix[t][m] == target) return true;
            if(matrix[t][m] < target){
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }
}
