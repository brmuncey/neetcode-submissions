class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        for(int[] row : matrix){
            int l=0, r=row.length - 1;

            if(row[r] < target){
                continue;
            }

            while(l <= r){
                int m = (l+r) / 2;

                if(row[m] == target){
                    return true;
                }

                if(row[m] < target){
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }

        return false;
    }
}
