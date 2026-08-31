class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n=matrix[0].length;
        int l=0, t=0, r=n, b=m;
        List<Integer> res = new ArrayList<>();
        while(l<r && t<b){
            for(int i=l; i<r; i++){
                res.add(matrix[t][i]);
            }
            t++;

            for(int i=t; i<b; i++){
                res.add(matrix[i][r - 1]);
            }
            r--;

            if(!(l <r && t < b)) break;

            for(int i=r-1; i>=l; i--){
                res.add(matrix[b-1][i]);
            }
            b--;

            for(int i=b-1; i>=t; i--){
                res.add(matrix[i][l]);
            }
            l++;
        }
        return res;
    }
}
