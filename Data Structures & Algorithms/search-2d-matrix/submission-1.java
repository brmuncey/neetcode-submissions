class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        for(int i=0; i<m; i++){
            if(matrix[i][0] <= target && matrix[i][n-1] >= target){
                return search(matrix[i], target);
            }
        }
        return false;
    }

    private boolean search(int[] arr, int target) {
        int l = 0, r = arr.length - 1;

        while (l <= r){
            int m = l + (r - l) / 2;

            if(arr[m] == target) return true;

            if(arr[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return false;
    }
}
