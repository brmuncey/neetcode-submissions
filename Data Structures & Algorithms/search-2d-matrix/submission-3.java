class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length, n=matrix[0].length;

        int r=0;
        while(r < m){
            if(matrix[r][0] <= target && target <= matrix[r][n-1]) break;
            r++;
        }

        if (r == m) return false;

        int l=0, e=n-1;
        int[] arr = matrix[r];
        while(l <= e){
            int mi = l + (e - l) / 2;

            if(arr[mi] == target) return true;

            if(arr[mi] < target) {
                l = mi + 1;
            } else {
                e = mi - 1;
            }
        }

        return false;
    }
}
